package PracticeProblems_intern;

import java.util.Arrays;
import java.util.Comparator;

public class MoveZeros {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 12 };
        System.out.println("The Sorted Array is as follows : " + Arrays.toString(moveZeros(arr)));
    }

    static int[] moveZeros(int nums[]) {
        if (nums.length < 2) {
            return nums;
        } else if(nums.length>2){

            int i = 0;
            int j = i + 1;
            int temp = 0;

            while (j != nums.length - 1) {
                if (nums[i] == 0 && nums[j] != 0 || nums[i] != 0 && nums[j] == 0) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j++;
                }

                if (nums[i] == 0 && nums[j] == 0) {
                    j++;
                }
            }

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            return nums;
        }else{
            int i = 0;
            int j = i + 1;
            if (nums[i] == 0 && nums[j] != 0 || nums[i] != 0 && nums[j] == 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }

    }
}
