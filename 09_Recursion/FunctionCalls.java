
public class FunctionCalls {
    public static void main(String[] args) {
        printNumberTopDown(10);
        printNumberBottomUp(10);
    }

    static void printNumberTopDown(int num) {
        if (num == 0) {
            System.out.println(num);
            return;
        } else {
            System.out.println(num);
            printNumberTopDown(num - 1);
        }
    }

    static void printNumberBottomUp(int num) {
        if(num==30){
            System.out.println(num);
            return;
        }else{
            System.out.println(num);
            printNumberBottomUp(num+1);
        }
    }
}
