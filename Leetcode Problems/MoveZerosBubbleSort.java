// 283. Move Zeroes
// When this Question is Solved using bubble Sort it takes unecessary time for each loop

import java.util.Arrays;

public class MoveZerosBubbleSort {
    public static void main(String[] args) {
        int arr [] ={0};
        System.out.println(Arrays.toString(shiftZeros(arr)));
    }

    static int[] shiftZeros(int arr[]) {
        boolean flag=false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] == 0) {
                    // Swapping the positions
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            if(!flag){
                break;
            }
        }
        return arr;
    }
}
