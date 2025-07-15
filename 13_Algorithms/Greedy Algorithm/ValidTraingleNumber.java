import java.util.Arrays;

public class ValidTraingleNumber {
    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 4 };
        System.out.println(triangleNumber(arr));
    }

    public static int triangleNumber(int[] nums) {
        // The mathematical condition for any three sides to form sides of the traingle
        // should
        // sum of any two sides must always strictly be greater than the third side
        // [2,3,4,4]

        // This problem sounds very similar to that of Three sum Implementation problem
            Arrays.sort(nums);
            int count = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int j = i + 1;
                int k = n - 1;

                while (j < k) {
                    if (nums[i] + nums[j] <= nums[k]) {
                        k--;
                    } else {
                        j++;
                        count++;
                    }
                }

            }

            return count;
    }

    public static boolean isValid(int a, int b, int c) {
        // As the array is already sorted we only need to check the condition of whether
        // n[i]+n[j]>n[k] all other possibilites will always be true
        return a + b > c;
    }
}
