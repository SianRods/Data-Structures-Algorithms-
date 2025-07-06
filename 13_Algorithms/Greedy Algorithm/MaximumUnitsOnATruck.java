import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        int boxTypes[][] = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
      
        // Sorting the array in in descending order as per the number of units per boxes
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int numberOfUnits = 0;
        // int boxes = 0;


        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] >= truckSize) {
                numberOfUnits += boxTypes[i][1] *  truckSize;
                // boxes += boxTypes[i][0] - truckSize;
                // break the loop after this point
                break;
            } else {
                numberOfUnits += boxTypes[i][1] * boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            }
        }

        return numberOfUnits;

    }
}
