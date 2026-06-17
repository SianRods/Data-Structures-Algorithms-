public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(getSqrt(80));
    }

    public static int getSqrt(int n) {
        if (n < 2) {
            return n;
        }

        return helper(1, n / 2, n);

    }

    public static int helper(int start, int end, int n) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // if the perfect square does not exists we have to return the floor of a number
            // this implementation logic on the search space of answer is very very similar to 
            // that of lowerbound and upper bound questions
            if (Math.pow(mid, 2) <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return end;

    }

}
