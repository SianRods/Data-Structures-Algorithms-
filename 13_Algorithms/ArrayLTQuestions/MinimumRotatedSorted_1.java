public class MinimumRotatedSorted_1 {
    public static void main(String[] args) {

    }

    // Note that here all the Elements are unique
    static int findPivotIndex(int arr[]) {
        int s = 0;
        int e = arr.length-1;
        int m = s + (e - s) / 2;

        // Here while start = end is the break condition for the while loop
        while (s <= e) {
            m = s + (e - s) / 2;
            if(m<e && arr[m]>arr[m+1]){
                return m;
            }
            if(m>s && arr[m-1]>arr[m]){
                return m-1;
            }
            else if(arr[s]<=arr[m]){
                // Its in the first part of the array 
                s=m+1;
            }else{
                e=m-1;
            }
        }
        // if the array is not rotated
        return -1;
    }


    static int findMin(int[] nums) {
        int pivot =findPivotIndex(nums);
        // 3 possible cases are there
        if(pivot==-1 && nums.length>1){
            // First element is the smallest
            return nums[0];
        }

        if(pivot!=-1 && pivot<nums.length-1){

            return nums[pivot+1];
        }

        return 1;
    }
}
