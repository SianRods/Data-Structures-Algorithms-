// Use case and time complexity of the Algorithm 
// 1. When given numbers to be sorted from range (1,N) -->  USE CYCLIC SORT
// 2. Tries to solve the problems in linear complexity

// Hint 
// As all the elements lie between 1--> N and are jumbled in the array 
// for a given value it's corresponding index will be indexCorrect=Value-1;
// ie. 1 will be at oth index, 2 at 1st index, 3 atthird index and so on 

import java.util.Arrays;

public class CyclicSort {
    public static void main(String args[]) {
        int arr[] = { 5, 4, 6, 2, 1 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cycleSort(int arr[]) {
        int i = 0;
        // if length =5 --> it goes from 0:4
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                // Here we are placing the element which has been encountered in the ith
                // position to it's right location
                // Swapping the element is it has not been placed correctly
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            } else {
                // Moving to the next index if the element is placed correctly
                i++;

            }
        }

    }

}
// Here we are only considering the range from (1,n)
// In order to be able to consider from (0,N)
// int i=0;
// while(i<arr.length){
// if(arr[i]!=i){
// // Swapping the incorrect postions
// // Here we
// int temp =arr[arr[i]];
// arr[arr[i]]=arr[i];
// arr[i]=temp;
// }
// }