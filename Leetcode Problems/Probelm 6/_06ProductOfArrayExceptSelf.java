// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// ---------------------------------------------------------------------------------------------------------
public class _06ProductOfArrayExceptSelf{
    public static void main(String args[]){
        int sampleArray[]={1,2,3,4};
        for(int i=0;i<resultArray(sampleArray).length;i++){
            System.out.println(resultArray(sampleArray)[i]);
        }
    }
    static int [] resultArray(int arr[]){
        int  arrr[]= new int[arr.length];  // In order to declare array with custome size
        for(int i=0;i<arr.length;i++){
            int product=1;
            for(int j=0;j<arr.length;j++){
                if(j==i){
                    continue;
                }else{
                    product*=arr[j];
                }
            }
            arrr[i]=product;
        }
            return arrr;
    }


}