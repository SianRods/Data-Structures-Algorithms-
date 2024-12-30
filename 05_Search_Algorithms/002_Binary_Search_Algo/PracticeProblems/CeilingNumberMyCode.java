// edge condition --> 
// Ceiling of a number --> Samllest Number >= given Number 
// What if all the number are less than given number in the array and that number does not exists
// Ex. target =14
// {1,3,3,5,6,7} ??
// return -1;


public class CeilingNumberMyCode {
    public static void main(String args[]){
        int [] sample ={2,3,5,9,14,16,18};
        System.out.println("The Ceiling of the Given Number is : "+ceilingNumber(sample, 15));
    }

    static int ceilingNumber(int arr[] , int element){
        // Implementing the Binary Search Algorithm and Modigying it 
        int start = 0;
        int end = arr.length-1;
        int middle=(start+end)/2;


        // Checking the validity of the given question (Assuming Ascending Number )
        if(element>arr[arr.length-1]){
            return -1;
        }


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

            // The whole point of using the while loop is to check whether the answer lies between 
            // {start,answer,end}
            // But when while loop is violated we know for sure that answer does not lie between
            // Start and  end and hence --> will lie outside of end

        }while(!(start>end));

    // The moment the condition get's violated we know that start>end 
    // the break condition will look soomething like this {end, answer,start}
    // next greatest element is start pointer now 
    // It is similar to returning end+1
    // As when the While Loop Breaks start=end+1; 


        return arr[start];
    }
}
