public class RemoveDuplicatesSortedArray {
    public static void main(String args[]) {
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        Display(arr);
        System.out.println("Sorted Array : ");
        System.out.println();
        int k=removeDuplicates(arr);
        Display(arr, k);

    }

    // Given array is in Ascending order
    // [0,0,1,1,1,2,2,3,3,4]
    static int removeDuplicates(int[] arr) {
        int j = 1;
        int temp;

        // Simple Two Pointers Approach 
        // Here the jth index keeps track of the element which has to be be exchanged 
        // starting i =1  helps us avoiding the IndexOutOfBounds Exception  
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                continue;
            } else if (arr[j - 1] < arr[i]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }

    static void Display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"-->");
        }
        System.out.print("END");
    }

    static void Display(int arr[], int limit){
        for(int i=0;i<limit;i++){
            System.out.print(arr[i]+"-->");
        }
        System.out.print("END");
    }

}
