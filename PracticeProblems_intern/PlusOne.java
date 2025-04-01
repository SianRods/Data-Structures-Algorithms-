package PracticeProblems_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        int num[] = { 1, 2, 3 };
        System.out.println("The Numeric Updated Form is : "+Arrays.toString(incrementByOne(num)));

    }

    static int [] incrementByOne(int arr[]) {

        int carry = 0;
        ArrayList<Integer> ar = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            if (i == arr.length - 1) {

                if (arr[i] + 1  > 9) {
                    arr[i] = 0;
                    carry = (arr[i] + 1) - 9;
                } else {
                    arr[i] = arr[i] + 1;
                    break;
                }
            }
            else{
                if (arr[i] + carry > 9) {
                    arr[i] = 0;
                    carry = (arr[i] + carry) - 9;
                } else {
                    arr[i] = arr[i] + 1;
                }
            }
        }

        for(int i=0;i<arr.length+carry;i++){
            if(carry!=0 && i==0){
                ar.add(carry);
            }
            ar.add(arr[i]);
        }

    //    Converting it to the New Array Variable 
        arr = new int[ar.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=ar.get(i);
        }

        return arr;
    }
}
