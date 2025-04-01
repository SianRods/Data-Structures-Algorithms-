package PracticeProblems_intern;

import java.util.Arrays;

public class kthLargestElementInArray {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] arr, int k) {
        int maxIndex=0;
        // Edge Condition for Value of K 
        if(k>=arr.length){
            return arr[arr.length-1]; 
        }
        for (int i = 0; i < k; i++) {
             maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }

        }
        return arr[maxIndex];
    }
}
