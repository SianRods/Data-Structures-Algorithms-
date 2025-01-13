// Leetcode Problem Number --> 125 .Valid Palindrome 



// Definition of Palindrom --> A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
//  all non-alphanumeric characters, it reads the same forward and backward. 
// Alphanumeric characters include letters and numbers.
import java.util.regex.*;

public class IsPalindrome {
    public static void main(String args[]) {
        String sent = "A man, a plan, a canal: Panama";
        sent = sent.toLowerCase();
        sent = sent.replaceAll("[^a-z0-9]", "");
        System.out.println(sent);
        StringBuilder build = new StringBuilder(sent);

        // Using STring builder object as it has inbuilt method for reversing a string
        // and comparing it with
        // already available string object
        if (build.reverse().toString().equals(sent)) {
            System.out.println("IsPalindrome");
        } else {
            System.out.println("NotPalindrome");
        }

    }
}
