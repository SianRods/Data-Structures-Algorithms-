
public class PositionInInfiniteArray {
    public static void main(String args[]) {
        int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println("The given element is at the following index in the array :"+elementIndex(arr, 10));

    }

    static int elementIndex(int arr[],int element) {
        // Implementing binary search for the descending order to find the index of the element
       int  start=indexBounds(arr, element)[0];
       int end =indexBounds(arr, element)[1];
       int middle =(start + end)/2;
       do {

        if (element == arr[middle]) {
            return middle;
        } else if (element > arr[middle]) {
            start = middle + 1;
            middle = (start + end) / 2;
        } else if (element < arr[middle]) {
            end = middle - 1;
            middle = (start + end) / 2;w
            
        }

    } while (true);


    }

    static int[] indexBounds(int arr[], int element) {
        int start = 0;
        int i = 0;
        int end = 1;
        int solution[] = new int[2];
        // Running an infinite loop
        do {
            if (arr[start] <= element & element <= arr[end]) {
                solution[0] = start;
                solution[1] = end;
                return solution;

            } else {
                start = end + 1;
                end = start + (int) Math.pow(2, i);
            }
            i++;
        } while (true);
    }

}
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Basic Approach
// 1. We cannot use the length function since the array is infinite
// 2. So here we approach this question by finding the start and end index
// between which our target lies
// 3. We do so in optimized way by increasing the chunks of array we will be
// comparing
// so the overall time complexity of solving this problem will be O(log n)
// for first start end --> 1
// for second start end -->2
// for third start end --> 4
// .................. 2*n
// ex. [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16.......................]
// First start=1 end =2
// Second start=3 end =6
// third start=7 end =12................and so on
// When we realise between which start and end pointer the index lies then we
// can apply binary search on that portion
// element is between start and end point iff element>=start && element <=end ;
// if it is then we apply BinarySearch for the index else we keep on shifting
// the start and end points
