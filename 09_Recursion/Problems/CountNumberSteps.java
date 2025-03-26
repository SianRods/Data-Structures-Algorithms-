public class CountNumberSteps {
    public static void main(String[] args) {
        System.out.println("The Number of Steps Required to make the Number Zero is : "+countStepsToMakeZero(8));
    }

    // Actually Global one is better suited here

    // Here it becomes extremely important to understand that if we use an inner function count 
    // ex) countStepsToMakeZero(int num , int countValue) 
    // Then each call will have it's won value of count and it won't be reflected globally 
    // Cause here we do the increment for both the cases when the number is EVEN as well as when the number is ODD


    static int count=0;

    static int countStepsToMakeZero(int num ){
        if (num==0) {
            return count;
        } else {
            if(num%2==0){
                count++;
                return countStepsToMakeZero(num/2);
            }
            count++;
            return countStepsToMakeZero(num-1);
        }
    }   
}
