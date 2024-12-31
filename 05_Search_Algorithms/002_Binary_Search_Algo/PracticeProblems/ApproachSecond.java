// We can find the Floor and the Ceiling Index for a given target and then subtract them to compare existence of the 
// element in the given array


public class ApproachSecond {
    public static void main(String args[]){
        int arr[] = {};
        // target = 8
        int[] solution = solution(arr, 2);
        System.out.println("The First and End position of the target variable is : " + solution[0] + solution[1]);

    }




    static int ceilIndex(int arr [],int target){
        // Assuming Acsending Order 
        int start=0;
        int end = arr.length-1;
        int middle =(start+end)/2;

        do{
            if(arr[middle]==target){
                start=middle+1;
                middle=(start+end)/2;

            }else if (arr[middle]>target){
                end=middle-1;
                middle=(start+end)/2;

            }else if (arr[middle]<target){
                start=middle+1;
                middle=(start+end)/2;
                

            }
        }while(!(start>end));
        return start;


    }

    static int floorIndex(int arr [],int target){
        // Assuming Acsending Order 
        int start=0;
        int end = arr.length-1;
        int middle =(start+end)/2;

        do{
            if(arr[middle]==target){
                end=middle-1;
                middle=(start+end)/2;

            }else if (arr[middle]>target){
                end=middle-1;
                middle=(start+end)/2;

            }else if (arr[middle]<target){
                start=middle+1;
                middle=(start+end)/2;
                

            }
        }while(!(start>end));
        return end;

    }

    static int[] solution(int arr[],int target){
        int sol[] = new int[2];
    if (arr.length>0){
        int ceil=ceilIndex(arr, target);
        int  floor = floorIndex(arr, target);
       if(ceil-floor>1){
        sol[0]=floor+1;
        sol[1]=ceil-1;
        return sol;
       }else if (ceil-floor==1){
        sol[0]=-1;
        sol[1]=-1;
        return sol;

       }
       else {
        sol[0]=-1;
        sol[1]=-1;
        return sol;
       }
    }else {
        sol[0]=-1;
        sol[1]=-1;
        return sol;
        
    }


    } 



}
