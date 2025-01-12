public class FirstOccurenceInString {
    public static void main(String args[]) {
        String universal = "sadbutsad";
        String sub = "sad";
        System.out.println(firstOccurence(universal, sub));
    }

    static int firstOccurence(String universal, String sub) {
        // Return the First occurence of the element in the given string

        return universal.indexOf(sub);
    }

}