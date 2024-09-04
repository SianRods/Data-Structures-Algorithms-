public class SearchRange {
    public static void main(String args[]){
        int nums []={1,32,432,3435,3454,34,32,35};
        System.out.println(searchInRange(3, 6, nums, 34));

    }

    static boolean searchInRange(int start,int end ,int arr[],int ele){
        if (arr.length == 0) {
            return false;
        }

        // Condition where the specified range is out of bounds
        else if(start>arr.length || end>arr.length){
            return false;
        }

        else {
           
            for (int i = start; i <= end; i++) {
                if (arr[i] == ele) {
                    return true;
                }
            }
            return false;
        }
    }
}
