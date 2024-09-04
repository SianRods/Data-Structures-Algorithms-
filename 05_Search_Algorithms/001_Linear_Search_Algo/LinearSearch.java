public class LinearSearch {
    public static void main(String args[]) {
        int nums[]={1,324,43,54,54,6,4};
        System.out.println(searchArrayIndex(nums, 1));

    }

    // Making a Static method so that it can be called inside of psvm
    // Best Case Scenario O(1)(Constant)
    // Worst Case Scenario O(n)
    static int searchArrayIndex(int arr[], int ele) {
        // Considering Boundary Scenarios arr.length==0
        if (arr.length == 0) {
            return -1;
        }

        else {
            // Running a For Loop to Iterate through whole array
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == ele) {
                    return i;
                }
            }

            // if no element is found 
            // Here we are returning '-1' cause index can never be '-1'
            return -1;
        }
    }




    // Returning the Element found itself : But element can be '-1' hence return statment can't be '-1'
    static int returnElement(int arr[], int ele) {
        // Considering Boundary Scenarios arr.length==0
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        }

        else {
            // Running a For Loop to Iterate through whole array
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == ele) {
                    return ele;
                }
            }

            // if no element is found 
            return Integer.MAX_VALUE;
        }
    }
}
