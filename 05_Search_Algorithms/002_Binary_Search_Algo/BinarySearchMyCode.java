
// My Code Logic 


public class BinarySearchMyCode {

    public static void main(String args[]) {
        // int sample[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int sample[] ={10,9,8,7,6,5,4,3,2,1};
        System.out.println(elementIndex(sample, 10));
    }

    // Return the index of the given element to be searched
    // If the element does not exists in the array return -1
    // 1,2,3,4,5,6,7,8,9,10

    static int elementIndex(int[] arr, int element) {
        // We have to necessarily maintain two pointers for starts ,end and middle
        // Start and end pointers will have to be updated depending upon where our target lies w.r.t middle element 
        // we have to also decide whether the given array is in descending order or ascending order
        // Note that here all these parameters are used to denote the indexing in the given array
        int start = 0;
        int end = arr.length - 1;
        int middle = (start + end) / 2;


        // Ensuring that the length of the array is greater than 1
        if (arr.length > 1) {

            // Figuring out if the order is Ascending or Descending
            boolean asc = false;
            if (arr[start] < arr[end]) {
                asc = true;
            }

            // making three comparison and iterating till the Element is found
            // Here the end goal is to find the Element at one of the middle indexex
            if (asc) {
                do {

                    if (element == arr[middle]) {
                        return middle;
                    } else if (element > arr[middle]) {
                        // Searching in the Remaining Upper Half by shifting the start pointer
                        start = middle + 1;
                        middle = (start + end) / 2;
                    } else if (element < arr[middle]) {
                        // Searching in the Remaining Upper Half by shifting the start pointer
                        end = middle - 1;
                        middle = (start + end) / 2;
                    }

                } while (!(start > end));
            } else {
                do {

                    if (element == arr[middle]) {
                        return middle;
                    } else if (element < arr[middle]) {
                        // Searching in the Remaining Upper Half by shifting the start pointer
                        start = middle + 1;
                        middle = (start + end) / 2;
                    } else if (element > arr[middle]) {
                        // Searching in the Remaining Upper Half by shifting the start pointer
                        end = middle - 1;
                        middle = (start + end) / 2;
                    }

                } while (!(start > end));
            }

        }
        // If the element not found return -1;
        return -1;

    }
}
