public class FindPeakElement {
    public static void main(String[] args) {
        // int arr[] = {1,2,1,3,5,6,4};
        int arr[] ={1,2,3,1};
        System.out.println(peakElement(arr, 0, arr.length-1));
    }

    // @return the index of the peak element 
    static  int peakElement(int arr[] , int start , int end ){
        int middle = start + (end-start)/2;
        if(middle==start && middle==end){
            return -1;
        }

        else if(arr[middle]>arr[middle+1] && arr[middle-1]<arr[middle]){
            return middle;
        }
        else if(arr[middle-1]>arr[middle]){
            return peakElement(arr, start, middle);
        }else{
           return  peakElement(arr, middle, end);
        }

    }
}
