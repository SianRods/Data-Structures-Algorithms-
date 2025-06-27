
public class SortedArray{
    public static void main(String[] args) {

        int arr[] = {1,2,3,9,4,5};
        System.out.println("The Given array is "+isSorted(arr, 0));
    }

    static boolean isSorted(int arr[] , int index ){

        if(index==arr.length-1){
            return true;
        }else{
            // Here the recurssive function will get the previous boolean value as well as upcoming boolean value 
            return arr[index]<arr[index+1] && isSorted(arr, index +1);
        }        
    }

} 


// Recursive Tree can be build for the similar function using 
// arr, index=0
// a[0]<a[1] && f(arr,1)
//         a[1]<a[2] && f(arr,2)
//             a[2]<a[3] && f(arr,3) .... till 
// This is our base condition cause for the second last most iteration index==length-1
// when i==arr.length-1 and i+1==arr.length-1 at the next call we pass index=i+1
// and hence the program must terminate there itself 