import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {

    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Maximum => First instinct is to sort the array as we have to maximize the
        // number of units given
        // the number of box on the trucks constrain
        // Sorting and Greediness comes to the mind first
        // Sort the Array as per the total numberOfUnitsPerBox ;
        // We can also choose to select only a limited number of boxes belonging to
        // certain types
        // But optimal Approach is to maximize output per selection of a single box
        // First the number of units per box and then

        Arrays.sort(boxTypes, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]); // a[1] = j1, b[1] = j2
            }
        });

        int numberOfUnits = 0;
        int boxes = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] >= (truckSize - boxes)) {
                numberOfUnits += boxTypes[i][1] * (oxTypes[i][0] - truckSize + boxes);
                boxes += boxTypes[i][0] - truckSize;
                // break the loop after this point
                break;
            } else {
                numberOfUnits += boxTypes[i][1];
                boxes += boxTypes[i][0] - truckSize;
            }
        }

        return numberOfUnits;

    }
}
