

public class ProductOfN {
    public static void main(String[] args) {
        System.out.println("Factorial of 5 is : "+Factorial(5));
    }

    // Factorial Methods
    static int Factorial(int n){
        if(n<2){
            return 1;
        }else{
            return n*Factorial(n-1);
        }
    }
}
