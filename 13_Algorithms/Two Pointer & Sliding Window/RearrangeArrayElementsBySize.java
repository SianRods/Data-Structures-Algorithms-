public class RearrangeArrayElementsBySize {
    public static void main(String[] args) {

    }

    public int[] rearrangeArray(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        int sol[] = new int[nums.length];
        int k = 1;
        while (j < n || i < n) {
            while (i < n && nums[i] < 0)
                i++;
            while (j < n && nums[j] > 0)
                j++;
            sol[k - 1] = nums[i];
            sol[k] = nums[j];
            k += 2;
        }
        return sol;
    }

}
