import java.util.Arrays;
public class StringSearch {
    public static void main(String[] args) {
        String newString = new String("Hello C ");
        System.out.println(charInString(newString, 'l'));     
        
        // String is also collection of different characters 
        // Implementation of Linear search can be shown using :-
        System.out.println(Arrays.toString(newString.toCharArray()));

}   

    static boolean charInString(String str, char c) {
        if (str.length() == 0) {
            return false;
        }

        else {
            // Running a For Loop to Iterate through whole array
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)==c) {
                    return true;
                }
            }

            // if no character  is found
            return false;
        }

    }
}
