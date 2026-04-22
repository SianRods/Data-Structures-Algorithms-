
import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;

    // creating a 0 indexed list
    // parent == (i-1)/2
    // leftChild== 2*i+1
    // rightChild == 2*(i+1)

    // constructor to instantiate the list
    public Heap() {
        list = new ArrayList<>();
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getLeft(int index) {
        return 2 * index + 1;
    }

    public int getRight(int index) {
        return 2 * (index + 1);
    }

    public void swap(int first, int two) {
        T temp = list.get(first);
        list.set(first, list.get(two));
        list.set(two, temp);
    }

    // performing insertion ==> using upheap
    public void insert(T value) {
        // inserting at the end of the list first
        // compaing and performing upheap for rearranging
        list.addLast(value);
        // upheap on the last index of the list
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }

        // here the index represents the bottomost part
        // so we have to start comparing it with it's parent
        int parent = getParent(index);

        // here we are implementing a minheap
        if (list.get(parent).compareTo(list.get(index)) > 0) {
            swap(parent, index);
            upheap(parent);
        }
    }

    // implemeting the removal --> incase of heap we always delete the first index
    // element(Topmost)
    // uses the concept of DownHeap
    public T remove() throws Exception {

        if (list.isEmpty()) {
            throw new Exception("Cannot Delete from an Empty Heap :(");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        // check if the list is empty or not after removing the last element
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;

    }

    private void downheap(int index) {
        int min = index;
        int left = getLeft(index);
        int right = getRight(index);

        // now compare with both the left and the rigth part
        // also ensure that the given node has both the left and the right part

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if (min != index) {
            // meaning either of the left or right is lower then the current min
            // keep on continuing the downheap
            // swap the minimum element with the index
            swap(min, index);
            downheap(min);
        }
    }

    // Implemeting HeapSort(NlOgN) --> Removing the first most element from the list
    // here --> as the heap is already implemented as a minheap
    // just keep on removing the elements from the list --> till it is not empty
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> sol = new ArrayList<>();

        while (!list.isEmpty()) {
            sol.add(this.remove());
        }

        return sol;
    }

    // Implementing a heapify function to convert unsorted array into --> maxHeap |
    // minHeap
    // Note that for converting an unsorted array into an max|min heap --> call
    // heapify function
    // for every non-leaf elements
    // Here we are just writing down the downHeap() function
    public void maxHeapify(int arr[], int n, int index) {
        int max = index;
        int left = getLeft(index);
        int right = getRight(index);

        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != index) {
            // largest element has to be changed
            // swap both the elements
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            maxHeapify(arr, n, max);
        }

    }

}