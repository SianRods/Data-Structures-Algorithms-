// 179. Largest Number
// Here we have to necessarily USE String Builder cause of immutability of Strings 

public class LargestNumber {
    public static String main(String args[]) {
        StringBuilder build = new StringBuilder();
        int arr[] = { 3, 30, 34, 5, 9 };
        for (int i = 0; i < arr.length; i++) {
            build = build.append(Integer.toString(arr[i]));
        }

        // Now Converting the same to IntArray
        for (int j = 0; j < build.length(); j++) {
            for (int i = 1; i < build.length() - j; i++) {
                if (Character.getNumericValue(build.charAt(i - 1)) < Character.getNumericValue(build.charAt(i))) {
                    // Swapp Both the Characters
                    Character temp = build.charAt(i);
                    build.setCharAt(i, build.charAt(i - 1));
                    build.setCharAt(i - 1, temp);
                }
            }
        }

        return build.toString();
    }
}
