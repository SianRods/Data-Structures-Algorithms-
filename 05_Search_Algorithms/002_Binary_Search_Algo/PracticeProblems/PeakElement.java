public class PeakElement {
    public static void main(String[] args) {
        int nums[] = {1};
        System.out.println("The peak index is :" + peakElementIndex(nums));
    }

    static int peakElementIndex(int nums[]) {
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end) / 2;

        if (nums.length > 2) {
            do {
                if (nums[middle + 1] - nums[middle] < 0) {
                    if (nums[middle] - nums[middle - 1] > 0) {
                        return middle;
                    } else {
                        end = middle - 1;
                        middle = (start + end) / 2;
                    }
                } else if (nums[middle + 1] - nums[middle] >= 0) {
                    start = middle + 1;
                    middle = (start + end) / 2;
                }
            } while (!(start > end));

        } else if (nums.length ==2 ) {
            if (nums[1] - nums[0] < 0) {
                return 0;
            }
        }
        return 0;

    }

}
