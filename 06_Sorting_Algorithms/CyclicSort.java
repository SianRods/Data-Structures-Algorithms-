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
        int arr[] = { 5, 4, 3, 6, 2, 1 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cycleSort(int arr[]) {
        int i=0;
        while(i<arr.length) {
            if (arr[i] != i + 1) {
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

// My Initial self-code with wrong apporach :
// for(int i=0;i<arr.length;i++){
// if(arr[i]==i+1){
// continue;
// }else{
// // Swapping w.r.t correct indices
// int temp=arr[i];
// arr[i]=i+1;
// arr[temp-1]=temp;
// }
// }