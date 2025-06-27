import java.util.ArrayList;

public class LinearSearchRecursion {
    public static void main(String[] args) {
        int arr[] = {1,2,3,9,5,4,5};
        System.out.println("The Given Element is Present in the Array "+isPresent(arr, 0, 5));
        System.out.println("The Given Element is Present in the Array "+multipleOccurences(arr, 0, 5));
        System.out.println("The Given Element is Present in the Array "+methodOne(arr, 0, 5,new ArrayList<>()));
        System.out.println("The Given Element is Present in the Array "+methodTwoNoArgument(arr, 0, 5));
    }

    static boolean isPresent(int arr[], int index, int element) {
        if (index == arr.length - 1) {
            if (arr[index] == element) {
                return true;
            }
            return false;
        }
        else{
            if(arr[index]==element){
                return true;
            }
            return isPresent(arr, index+1, element);  
        }
    }

    // Maaking a Global Function Variable that can be accessed by the method and updated for our reference
    static ArrayList<Integer> solution = new ArrayList<>();


    // In this method our recurssive function is accessing and updating the same element which is our 
    // Solution Arraylist 
    static ArrayList<Integer> multipleOccurences(int arr[], int index, int element) {
        if (index == arr.length ) {
          return solution;
        }
        else{
            if(arr[index]==element){
                solution.add(index);
            }
            return multipleOccurences(arr, index+1, element);   
        }   
    }



    // In this method we are actually passing a the element which will be updated for answers throughout all the calls 
    // note that the same original object is being passed throughout all the calls
    static ArrayList<Integer> methodOne(int arr[], int index, int element, ArrayList<Integer> s1) {
        if (index == arr.length ) {
            return s1;
        }
        else{
            if(arr[index]==element){
                s1.add(index);
            }
            return methodOne(arr, index+1, element,s1);
        }   
    }




    static ArrayList<Integer> methodTwoNoArgument(int arr[], int index, int element) {
        // Creating new Arraylist inside each Function call
        ArrayList<Integer> s1 = new ArrayList<>();
        // Updating the Given List with the values of the previous Funciton calls is any
        if (index == arr.length ) {
            return s1;
        }
        else{
            if(arr[index]==element){
                s1.add(index);
            }
             ArrayList<Integer> ans = methodTwoNoArgument(arr, index+1, element); // Note that the recursive call takes place over in this statement 
            //  Depending upon what the 'ans' is returned from the above calls we will updates our existing list and then pass the updated index values 
            // to the above function calls 
            // So every time we update the given list and then pass that list 
               s1.addAll(ans);
                 return s1;
        }   
    }

}
