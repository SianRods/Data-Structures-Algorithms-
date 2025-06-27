
public class SkipSubString {
    public static void main(String[] args) {
        String s = "hidsfhsdapplesdfsdf";
        String subPart = "apple";
        String smallerSkip = "app";
        System.out.println(skipSubstring(s, subPart));
        // System.out.println(skipSubstringNotSuperString(s, subPart, smallerSkip));
    }

    // Here instead of skipping a character we will be skipping a substring passed
    // to the function
    // And then returning it's vallue that the function will have return type of
    // string

    public static String skipSubstring(String s, String subPart) {
        if (s.isEmpty()) {
            return "";
        }

        // to check if the given string starts with a desired prefix we can use
        // startsWith() => funciton in java
        if (s.startsWith(subPart)) {
            // Skip that subpart of the string
            // We are skipping the number of indices with the length of the string
            return skipSubstring(s.substring(0 + subPart.length()), subPart);
        } else {
            return s.charAt(0) + skipSubstring(s.substring(1), subPart);
        }

    }

    // Second variation of skipping the subtring
    // here we only want to skip the substring "app" when it's not equal to "apple"
    // Only skip "app" if it's enitirety is not apple

    public static String skipSubstringNotSuperString(String s, String subPart, String smallerSkip) {
        if (s.isEmpty()) {
            return "";
        }

        // to check if the given string starts with a desired prefix we can use
        // startsWith() => funciton in java
        if (s.startsWith(smallerSkip) && !s.startsWith(subPart)) {
            // Skip that subpart of the string
            // We are skipping the number of indices with the length of the string
            return skipSubstringNotSuperString(s.substring(0 + smallerSkip.length() ), subPart, smallerSkip);
        } else {
            return s.charAt(0) + skipSubstringNotSuperString(s.substring(1), subPart, smallerSkip);
        }

    }

}
