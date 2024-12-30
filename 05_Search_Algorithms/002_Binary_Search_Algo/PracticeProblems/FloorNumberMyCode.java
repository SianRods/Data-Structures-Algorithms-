
public class FloorNumberMyCode {
    public static void main(String args[]){
        int [] sample ={2,3,5,9,14,16,18};
        System.out.println("The Ceiling of the Given Number is : "+ceilingNumber(sample, 7));
    }

    static int ceilingNumber(int arr[] , int element){
        // Implementing the Binary Search Algorithm and Modigying it 
        int start = 0;
        int end = arr.length-1;
        int middle=(start+end)/2;

        // Array is in Ascending order Assumed 
        // Rertuning the element if it is present in the array 
        do{
            // We will check if the given number exists in the array using binary sort .If it does we will 
            // return the same element
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



        // Same Logical Appproach as Ceiling of a Number only here we will return end when the condition
        // Is violated and not the start
        return arr[end];
    }
}
