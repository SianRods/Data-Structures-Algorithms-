
public class PrintToN {
    public static void main(String[] args) {
        printTo1(10);
        OnetoN(10);
    }

    // Return type is void as we want to print Numbers and Not Specifically Return
    // Anything
    static void printTo1(int num) {
        if (num == 1) {
            System.out.println(num);
            return;
        } else {

            // It is important to understand how the function calls will work depeding upon
            // whther the recursive
            // call has been made after the print statment or before the print statement

            // IF THE CALL WAS MADE BEFORE THE PRINT STATEMENT THEN THE CALL FUNCTION WOULD
            // FIRST HAVE TO WAIT FOR BASE
            // CONDITION TO BE COMPLETED BEFORE PRINTING ITSELF --> {1,2,3,4,5}

            // WHEN THE PRINT STATEMENT IS FIRST THE STARTING WALA NUMBER IS PRINTED FIRST
            // AND THEN NEXT CALL IS GIVEN FOR N-1 NUMBER AND SO ON

            System.out.println(num);
            printTo1(num - 1);
        }
    }

    static void OnetoN(int num) {
        if (num == 1) {
            System.out.println(num);
            return;
        } else {
            OnetoN(num - 1);
            // Here First we will Pass the Value to the Funtion and then print the Number 
            System.out.println(num);
        }
    }
}
