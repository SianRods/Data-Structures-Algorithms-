import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // String arr[]={"flower","flow","flight"};
        String arr[] = { "dog", "racecar", "car" };
        System.out.println(solution2(arr));

    }

    /**
     * Brute Force Approach of comparing each and every character
     * of the string and then appending them
     * 
     * 
     * @param arr array oof Strings
     * @return Longest common prefix among the strings
     */
    public static String solution1(String arr[]) {
        StringBuilder sol = new StringBuilder();
        int n = arr.length;
        String first = arr[0];

        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i); // extract the first character of the string
            for (int j = 0; j < n; j++) {
                if (i < arr[j].length() && arr[j].charAt(i) == c) {
                    continue;
                } else {
                    return sol.toString(); // return the solution collected
                    // uptil this point
                }

            }

            sol.append(c);
        }

        return sol.toString();

    }

    /**
     * 
     * In this approach we will sort the array first and then
     * traverse for min(first,last) string to cover min distance
     * 
     * for that min distance compare those min characters of first and
     * last element in the array as it has already been sorted in alphabetical order
     * 
     * this approach is almost 99.999 percent similar above approach
     * 
     * 
     * @param arr
     * @return
     */
    public static String solution2(String arr[]) {
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        StringBuilder sol = new StringBuilder();
        int minIteratelen = Math.min(first.length(), last.length());

        for (int i = 0; i < minIteratelen; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sol.toString();
            } else {
                sol.append(first.charAt(i));
            }

        }

        return sol.toString();

    }

}