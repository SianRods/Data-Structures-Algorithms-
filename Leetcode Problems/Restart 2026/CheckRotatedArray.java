public class CheckRotatedArray {
    public static void main(String[] args) {
        // int nums[] = { 3, 4, 5, 1, 2 };
        // int nums[] = { 2, 1, 3, 4 };
        // int nums[] = { 1, 2, 3 };
        int nums[] = { 2, 1 };

        System.out.println(solution(nums));

    }

    public static boolean solution(int nums[]) {

        // note that the key pattern being in a rotated and sorted array
        // nums[i]>num[i+1] ==> happens only once about the pivot point

        int n = nums.length;
        int count = 0;

        // here although we will be using [i+1] and still traverse till n-1 and access
        // n+1
        // we use circular check to check whther the start and end connections are
        // proper too
        // n[0]<n[end]
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;

    }
}

// the below approach is completely wrong and enforeces condition which will
// result in
// incorrect condition checks

// public static boolean solution(int nums[]) {
// int n = nums.length;
// int smallestIndex = 0;
// int min = Integer.MAX_VALUE;

// for (int i = 0; i < n; i++) {

// if (nums[i] < min) {
// min = nums[i];
// smallestIndex = i;
// }
// }

// for (int i = smallestIndex; i < n - 1; i++) {
// if (nums[i] > nums[i + 1]) {
// return false;
// }

// }

// // check the other half of the array
// for (int i = smallestIndex - 1; i > 0; i--) {
// if (nums[i] < nums[i - 1]) {
// return false;
// }

// }

// // if (smallestIndex > 0 && nums[0] < nums[smallestIndex + 1])
// // return false;

// int i = smallestIndex;
// int j = 0;

// while (j < i && i < n) {
// if (nums[j] < nums[i]) {
// return false;

// }
// i++;
// j++;

// }

// return true;

// }
