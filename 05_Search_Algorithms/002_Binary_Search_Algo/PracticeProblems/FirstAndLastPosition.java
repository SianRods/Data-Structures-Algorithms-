// We can find the Floor and the Ceiling Index for a given target and then subtract them to compare existence of the 
// element in the given numsay

public class FirstAndLastPosition {
    public static void main(String args[]) {
        int nums[] = {};
        // target = 8
        int[] solution = solution(nums, 2);
        System.out.println("The First and End position of the target variable is : " + solution[0] + solution[1]);

    }

    static int ceilIndex(int nums[], int target) {
        // Assuming Acsending Order
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end) / 2;

        do {
            if (nums[middle] == target) {
                start = middle + 1;
                middle = (start + end) / 2;

            } else if (nums[middle] > target) {
                end = middle - 1;
                middle = (start + end) / 2;

            } else if (nums[middle] < target) {
                start = middle + 1;
                middle = (start + end) / 2;

            }
        } while (!(start > end));
        return start;

    }

    static int floorIndex(int nums[], int target) {
        // Assuming Acsending Order
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end) / 2;

        do {
            if (nums[middle] == target) {
                end = middle - 1;
                middle = (start + end) / 2;

            } else if (nums[middle] > target) {
                end = middle - 1;
                middle = (start + end) / 2;

            } else if (nums[middle] < target) {
                start = middle + 1;
                middle = (start + end) / 2;

            }
        } while (!(start > end));
        return end;

    }

    static int[] solution(int nums[], int target) {
        int sol[] = new int[2];
        if (nums.length > 0) {
            int ceil = ceilIndex(nums, target);
            int floor = floorIndex(nums, target);
            if (ceil - floor > 1) {
                sol[0] = floor + 1;
                sol[1] = ceil - 1;
                return sol;
            } else if (ceil - floor == 1) {
                sol[0] = -1;
                sol[1] = -1;
                return sol;

            } else {
                sol[0] = -1;
                sol[1] = -1;
                return sol;
            }
        } else {
            sol[0] = -1;
            sol[1] = -1;
            return sol;

        }

    }

}
