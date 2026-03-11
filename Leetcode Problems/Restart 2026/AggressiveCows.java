import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        int arr[] = {};
    }

    /**
     * Here we have to maximize the minimum distance between the cows being placed
     * in the stalls
     * You are given the task of assigning stalls to 'k' cows such that the minimum
     * distance between
     * any two of them is the maximum possible
     * 
     * Here we have to understand it properly that before placing the cows we have
     * to make sure
     * that we sort the coordinates where the cows are to be placed to easily
     * calculate the distances
     * 
     * the placing of the cows for each possible minimum distance has to be done in
     * greedy manner
     * 
     * the range of the min distances which can be maximized is
     * [1,max(arr)-min(arr)]
     * The below function implements the most simplest linear search solution
     * search on possible answers --> O(n)
     * 
     * 
     * @param coordinates array containing the coordinates of the stalls where cows
     *                    are to be places
     * 
     * @param cows        number of aggressive cows to be placed compulsorily
     * 
     * @return maximmum possible minimum distance between the cows placed in the
     *         stall
     * 
     */
    public static int solution1(int coordinates[], int cows) {

        // Sorting the coordinates array
        Arrays.sort(coordinates);
        int n = coordinates.length;
        int max = coordinates[n - 1];
        int min = coordinates[0];

        // searching the possible search space
        for (int i = 1; i <= (max - min); i++) {

            // check if the possible min distance is valid
            if (canWePlaceCows(coordinates, cows, i)) {
                continue;

            } else {
                // we simply return the previous value as it is the maximum of minimum distance
                // we can reach
                return i - 1;
            }

        }
        return -1;

    }

    private static boolean canWePlaceCows(int[] coordinates, int cows, int minDistance) {

        // traverse the enitre coordniate array and keep on checking whether it is
        // possible
        // to place the cows
        cows--;
        int lastCow = coordinates[0];
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i] - lastCow >= minDistance) {
                // update the last cow placed pointer
                lastCow = coordinates[i];
                cows--;
            }
        }

        // at the end if cows ==0 return true

        return cows <= 0;

    }

    /**
     * 
     * Implementing  the binary search version of the same question 
     * 
     * @param coordinates
     * @param cows
     * @return
     */
    public static int solution2(int coordinates[], int cows) {

        // Sorting the coordinates array
        Arrays.sort(coordinates);
        int n = coordinates.length;
        int max = coordinates[n - 1];
        int min = coordinates[0];

        int end = max - min;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canWePlaceCows(coordinates, cows, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return end;

    }

}