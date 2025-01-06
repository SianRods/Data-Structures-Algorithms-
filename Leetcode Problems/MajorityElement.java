import java.util.Arrays;

public class MajorityElement {
    public static void main(String args[]) {
        // int arr[] = { 3, 2, 3 };
        int arr[]={2,2,1,1,1,2,2};
        System.out.println(Arrays.toString(arr));
        System.out.println(majorityElement(arr));
    }

    static int majorityElement(int arr[]) {
        // Sorting the given array using Bubble Sort Algorithm
        Arrays.sort(arr);
        int count = 1;

        // Notice that it is also important to properly decide the condition in if-else statements
        // After the array has been sorted we will keep on iteratin using the
        for (int k = 0; k < arr.length-1; k++) {
            if (arr[k] == arr[k + 1]) {
                count++;
                if(Math.floor(arr.length/2) < count){
                    return arr[k];
                }
            }
            // If both the elements are not equal check and calulate the floor if greater
            // than return else
            // else init counter to =1;
            else {
                if (arr[k] != arr[k + 1] && Math.floor(arr.length/2) < count) {
                    return arr[k];
                } else {
                    count = 1;
                }
            }
        }
        return -1;
    }
}
