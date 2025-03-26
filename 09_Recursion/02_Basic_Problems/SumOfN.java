
public class SumOfN {
    public static void main(String[] args) {
        System.out.println("Sum of first 5 numbers is : "+SumOfNumbers(5));
    }

    static int SumOfNumbers(int num){

        if(num<2){
            return num;
        }else{
            return num+SumOfNumbers(num-1);
        }
    }
}
