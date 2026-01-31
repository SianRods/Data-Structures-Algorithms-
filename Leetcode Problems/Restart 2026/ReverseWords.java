public class ReverseWords {
    public static String main(String[] args) {
        String s = "Let's take LeetCode contest";
        // s.split() --> returns the array of strings
        // add the white spaces in the brute force approach
        String sol = "";
        String[] arr = s.split(" ");
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sol += getReverse(arr[i]);
            if (i != len - 1)
                sol += " ";
        }

        return sol;

    }

    public static String getReverse(String str) {
        // Strings --> inherently immutable in the java
        return new StringBuilder(str).reverse().toString();

    }

}