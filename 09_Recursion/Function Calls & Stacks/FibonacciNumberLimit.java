public class FibonacciNumberLimit {
    public static void main(String[] args) {
        System.out.println(nthFibonacciNumber(3));
    }

    static int nthFibonacciNumber(int n) {
        // Here n is not a number instead it is the nth term in the series
        // For Fibnonacci Numbers
        if (n < 3) {
            return n;
        }

        // The below statement is called as a recurrrence relation which has to be
        // identified if present in order to
        // in order to solve problem using recurrsion
        return nthFibonacciNumber(n - 1) + nthFibonacciNumber(n - 2);

    }
}

// It is important to note that if a given number has a end statement --> Tail
// Recursion
// If it does not has an end statement and it keeps on making internal calls to
// itself

// It is v.v.v.v.imp to identify the order in which tree is called (order of
// function executions left /right )
// Use the debugger in order to understand the flow of function calls in recursion