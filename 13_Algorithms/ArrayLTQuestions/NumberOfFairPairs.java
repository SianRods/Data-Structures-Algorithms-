public class NumberOfFairPairs {
    public static void main(String[] args) {

    }

    static int binary_search(int s, int e, int nums[], int targetBound) {
        // returns largest i greater that or equal to x ;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] >= targetBound) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        //
        return e;
    }

    static long numberOfFairPairs(int nums[], int lower, int upper) {
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = lower - nums[i];
            int up = upper - nums[i];

            pairs+=(
                // Here we have used up+1 so that same code of bin_search works for finding the upper level 
                //  and lower level index 
                binary_search(i+1,nums.length-1,nums,up+1)-binary_search(i+1,nums.length-1,nums,low);
            );


        }

        return pairs;
    }

}
