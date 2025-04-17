public class MinimumRotatedSorted_2 {
    public static void main(String[] args) {

    }

    static int findPivotIndexDuplicates(int nums[]) {
        int s = 0;
        int e = nums.length - 1;
        int m = s + (e - s) / 2;

        // Here we gonna consider 4 cases
        while (s <= e) {
            m = s + (e - s) / 2;
            if (m < e && nums[m] > nums[m + 1]) {
                return m;
            }
            if (m > s && nums[m - 1] > nums[m]) {
                return m - 1;
            }

            // If all the m s and e are equal then reduce the size from both the ends
            if (nums[m] == nums[s] && nums[e] == nums[m]) {
                if (s < e && nums[s] > nums[s + 1]) {
                    return s;
                }
                s++;
                if (e > s && nums[e] < nums[e - 1]) {
                    return e - 1;
                }
                e--;
            }

            else if (nums[s] < nums[m] || (nums[s] == nums[m] && nums[m] > nums[e])) {
                // Its in the first part of the array
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        // if the array is not rotated
        return -1;
    }

    public int findMin(int[] nums) {
        // Check for single length array
        if (nums.length == 1) {
            return nums[0];
        }

        int pivot = findPivotIndexDuplicates(nums);
        // 3 possible cases are there
        if (pivot == -1 && nums.length > 1) {
            // First element is the smallest
            return nums[0];
        }

        if (pivot != -1 && pivot < nums.length - 1) {

            return nums[pivot + 1];
        }

        return 1;
    }
}
