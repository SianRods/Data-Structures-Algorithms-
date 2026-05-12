
public class ArrayMinHeap {

    public static void main(String[] args) {

    }

    // checking if an array represents a minheap
    // here we are considering the input as an array representing a complete binary
    // tree
    // so there is no need of verfying whether the tree is complete or not
    public boolean checkMinHeap(int arr[]) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * (i + 1);

            // write each of the breakdown condition seperately
            // also keep on checking the validity of the index bounds
            if (left < length && arr[left] < arr[i]) {
                return false;
            }

            if (right < length && arr[right] < arr[i]) {
                return false;
            }
        }
        return true;

    }

}
