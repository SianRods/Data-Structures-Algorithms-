
public class SortedArray{
    public static void main(String[] args) {

        int arr[] = {1,2,3,9,4,5};
        System.out.println("The Given array is "+isSorted(arr, 0));
    }

    static boolean isSorted(int arr[] , int index ){

        if(index==arr.length-1){
            return true;
        }else{
            return arr[index]<arr[index+1] && isSorted(arr, index +1);
        }


    }

} 