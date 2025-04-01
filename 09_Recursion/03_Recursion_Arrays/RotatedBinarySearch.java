public class RotatedBinarySearch {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,8,9,1,2,3};
        System.out.println("The element 2 is at the index "+searchRotatedArray(arr, 2, 0, arr.length-1)+" in the array");
    }


    static int searchRotatedArray(int arr[] , int target , int s , int e){
        
        if(s>e){
            return -1;
        }

        int middle = s+(e-s)/2;

        if(arr[middle]==target){
            return middle;
        }
        if(arr[s]<=arr[middle] ){
            if(arr[s]<=target && arr[middle]>= target){
                return searchRotatedArray(arr, target, s, middle-1);
            }else{
                return searchRotatedArray(arr, target, middle+1, e);
            }
        }
        
        if(target>=arr[middle] && target<=arr[e]){
            return searchRotatedArray(arr, target, middle+1, e);
        }

        return searchRotatedArray(arr, target, s, e-1);
    }

}
