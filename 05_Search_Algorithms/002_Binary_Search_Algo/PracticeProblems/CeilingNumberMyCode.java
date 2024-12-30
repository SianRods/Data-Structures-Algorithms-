
public class CeilingNumberMyCode {
    public static void main(String args[]){
        int [] sample ={2,3,5,9,14,16,18};
        System.out.println("The Ceiling of the Given Number is : "+ceilingNumber(sample, 6));
    }

    static int ceilingNumber(int arr[] , int element){
        // Implementing the Binary Search Algorithm and Modigying it 
        int start = 0;
        int end = arr.length-1;
        int middle=(start+end)/2;

        // Array is in Ascending order Assumed 
        do{
            if(arr[start]>element){
                return arr[start];
            }
            if(arr[middle]==element){
                return arr[middle];
            } else if(arr[middle]<element){
                start=middle+1;
                middle=(start+end)/2;

            }else if(arr[middle]>element){
                end=middle-1;
                middle=(start+end)/2;
            }
        }while(!(start>end));
        return -1;
    }
}
