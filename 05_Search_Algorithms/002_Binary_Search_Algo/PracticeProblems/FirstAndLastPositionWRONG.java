public class FirstAndLastPositionWRONG {
    public static void main(String args[]) {
        // Only static methods can invoke other static methods if we don't want to
        // create seperate classes
        // Nad want to implement same under single class
        int arr[] = { 2, 5, 5, 5, 7 };
        // target = 8
        int[] solution = searchRange(arr, 5);
        System.out.println("The First and End position of the target variable is : " + solution[0] + solution[1]);
    }

    static int[] searchRange(int[] nums, int target) {
        // Using time complexity of O(log n )
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end) / 2;
        int solution[] = new int[2];
        int count = 0;

        // Given that the order is in Ascending Format
        // 3 5 5 5 7
        // middle element first occurrence at second position
        // It's wrong to assume that the first occurence of the given target will be at
        // 1st middle

        do {
            if (nums[middle] == target) {
                if (count == 0) {
                    solution[0] = middle;
                    start = middle + 1;
                    middle = (start + end) / 2;
                    count++;
                } else {
                    count++;
                    start = middle + 1;
                    middle = (start + end) / 2;

                }
            } else if (nums[middle] < target) {
                start = middle + 1;
                middle = (start + end) / 2;

            } else if (nums[middle] > target) {
                end = middle - 1;
                middle = (start + end) / 2;

            }
        } while (!(start > end));

        solution[1] = solution[0] + count;

        return solution;

    }
}
