public class PeakIndexMountainnumsay {
    public static void main(String args[]) {
        int nums[] = {24,69,100,99,79,78,67,36,26,19};
        System.out.println("The peak index is :" + getPeakIndex(nums));

    }

    static int getPeakIndex(int nums[]) {
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end) / 2;

        do {
            if (nums[middle + 1] - nums[middle] < 0) {
                if (nums[middle] - nums[middle-1] > 0) {
                    return middle;
                }else{
                    end=middle-1;
                    middle=(start+end)/2;
                }
            } else if (nums[middle + 1] - nums[middle] >= 0) {
                start = middle + 1;
                middle = (start + end) / 2;
            }
        } while (!(start > end));
        return -1;
    }

}
