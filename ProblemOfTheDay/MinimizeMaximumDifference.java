
// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/?envType=daily-question&envId=2025-06-13
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MinimizeMaximumDifference {
    public static void main(String[] args) {
        // int arr[] = { 10, 1, 2, 7, 1, 3 };
        // int p = 2;
        // int arr[] = { 4, 2, 1, 2 };
        // int p = 1;
        int arr[] = { 3, 4, 2, 3, 2, 1, 2 };
        int p = 3;
        int answer = minimizeMax(arr, p);
        System.out.println(answer);
    }

    public static int minimizeMax(int[] nums, int p) {

        if (nums.length > 1 && p > 0) {
            // Here we will be using arraylist to solve the problem
            int sol[] = new int[p];
            int i = 0;
            ArrayList<Integer> list = new ArrayList<>();

            // Adding all the data to the list to be sorted serially
            for (int j = 0; j < nums.length ; j++) {
                if (!list.contains(nums[j])) {
                    list.add(nums[j]);
                } else {


                    
                    list.remove(nums[j]);
                    sol[i++] = 0;
                }
            }

            // sorting the list to find the minimum distance
            Collections.sort(list);
            int j = 1;
            while (j < list.size() - 1 && i < p) {
                sol[i] = Math.abs(list.get(j - 1) - list.get(j));
                j = j + 2;
                i++;
            }

            Arrays.sort(sol);
            return sol[p - 1];
        }
        return 0;
    }
}
