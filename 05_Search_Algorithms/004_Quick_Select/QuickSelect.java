import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter the elements you want to enter : ");
        size = sc.nextInt();
        int arr[] = new int[size];

        takeInput(arr, sc);
        printArray(arr);
        
        System.out.println("Enter the position of the array u want ?? ");
        int position=sc.nextInt();

        quickselect(arr, 0, arr.length - 1,position);
        printArray(arr);

    }

    static void quickselect(int arr[], int start, int end,int position) {
        // Note that Start end are necessary parameters in case of quickSort for it to
        // properly
        // function recurrsively
        if (start < end) {
            int middle = partition(arr, start, end);
            if(middle>position-1){
                quickselect(arr,start,middle-1,position);
            }else{
                quickselect(arr,middle+1,end,position);
            }
    
        }
    }

    static int partition(int arr[], int start, int end) {
        // Selecting a pivot element as start
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        int temp;

        while (i < j) {
            while ( i <= end && arr[i] <= pivot)
                i++;
            while ( j >= start && arr[j] >= pivot)
                j--;
            if (i < j) {
                // swapping the both the pointers after each check
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Also called as Cross Over Swap
        // After completeing the loop swapping pivot with j with the start position
        // starting element
        // of the array
        temp = arr[j];
        arr[j] = arr[start];
        arr[start]= temp;

        // returning J which now holds the current position for the selected pivot
        return j;
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\n");
        }
        System.out.println("\n");
    }

    static void takeInput(int arr[], Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the input for the " + (i + 1) + "Element");
            arr[i] = sc.nextInt();
        }
    }

}
