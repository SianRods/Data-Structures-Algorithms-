// for a friend request to be made by x to y 
// 1] a[y]>.5*a[x]+7  ==> points towards the lower limit of the search space if started from last
// 2] a[y]<=a[x];
// 3] a[y]<=a[100] && a[x]>=100

// Coming up with a Solution 
// 1] Sorting the array 
// 2] start from behind as it makes more sense and lower limit should be optimum
// 3] Two Pointers can be used in order to determine from highest one to the lowest
// point inbetween all will mostly satisfy the condition for freindship

import java.util.Arrays;

public class FriendsOfAppropriateAge {
    public static void main(String[] args) {
        int arr[] = { 20, 30, 100, 110, 120 };
        System.out.println(numFriendRequests(arr));
    }

    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int right = n - 1;
        int left = n - 1;
        int result = 0;
        while (left >= 0) {
            left = right - 1;
            while (left >= 0 && ages[left] > 0.5 * ages[right] + 7) {
                left--;
            }
            result += right - left;
            right--;
            left = right - 1;

        }

        return result;
    }
}
