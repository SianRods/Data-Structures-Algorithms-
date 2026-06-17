public class NthRoot {
    public static void main(String[] args) {
        System.out.println(findNthRootofM(27, 4));
    }

    public static int findNthRootofM(int m, int n) {

        return helper(1, m, m, n);

    }

    /**
     * Here we are returning the nth root of number m using the floor 
     * so even if the perfect nth root does not exists we just simply return floor 
     *  
     * 
     * @param start
     * @param end
     * @param m
     * @param n
     * @return
     */
    public static int helper(int start, int end, int m, int n) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // if the perfect square does not exists we have to return the floor of a number
            // this implementation logic on the search space of answer is very very similar
            // to
            // that of lowerbound and upper bound questions
            if (Math.pow(mid, n) <= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;

    }
}
