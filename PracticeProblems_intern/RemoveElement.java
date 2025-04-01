package PracticeProblems_intern;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int arr [] = {0,1,2,2,3,0,4,2};
        System.out.println("The Solution array is : "+Arrays.toString(sol(arr, 2)));

    }

    static int  sol(int arr[], int val){

        if(arr.length==0){
            return 0;   
        }

        int j=arr.length-1;
        int temp;
        for(int i=0;i<=j;i++){
            if(arr[i]==val){
                while(j>i && arr[j]==val){
                    j--;
                }
                if (i <= j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j--; // Reduce j as it now holds val
                }
            }
        }
        return j+1;
    }
}
