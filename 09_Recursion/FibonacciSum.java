public class FibonacciSum {
    public static void main(String[] args) {
        System.out.println(sumTillFibonacci(10));
    }
    // In order to identify whther a problem can be solved using recursion or not we have to determine that 
    // the given bigger problem can be sovled in smaller steps 


    static int sumTillFibonacci(int term){
        if(term<3){
            return sumTillFibonacci(term-1)+
        }
    }
    
}
