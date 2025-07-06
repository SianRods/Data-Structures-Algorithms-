// Always remember that a subset can be a non-Adjacent Collection of bigger array 

import java.util.ArrayList;

public class SubsetIntroduction {

    // BEHIND ANY PROBLEM OF RECURSION UNDERSTANDING THE SEQUENCE OF EXECUTION OF
    // FUNCTION CALLS AND HOW THINGS
    // ACTUALLY WORK W.R.T ARGUMENTS AND BASE CONDITION

    public static void main(String[] args) {
        String s = "abc";
        // printSubsequences(s, "");
        // System.out.println(printSubsequencesReturnList(s, ""));
        System.out.println(printSubsetsContainsASCII(s, ""));

    }

    // Subsets => Adjacent / Non-adjacent Collection of Elements Note that here the
    // ordering of the elements must
    // remain same and cannot be changed

    // SUBSET PATTERN => AN ELEMENT MAY BE REMOVED OR ADDED TO THE EXISTING STRING
    // => Done using Recursion || Iteration
    // Smilar Apporach can be used in case of problems involving PERMUTATIONS AND
    // COMBINATIONS;

    // Here we will be using same approach of processed and unprocessed tree and for
    // every single
    // unprocessed part of the string we have the choice of either adding elements
    // to it (IN ORDER AS
    // CONCEPT OF SUBSET REQUIRED IT TO BE ) or else not adding the element to it

    // Here we will print the base condition for the recursive function

    // BASE CONDITION => WHEN PROCESSED PART IS EMPTY
    public static void printSubsequences(String s, String processed) {
        if (s.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char n = s.charAt(0);
        printSubsequences(s.substring(1), processed + n);
        printSubsequences(s.substring(1), processed);
    }

    // Instead of Printing If I want to return an arraylist of strings containing
    // all possible subsequences
    public static ArrayList<String> printSubsequencesReturnList(String s, String processed) {
        if (s.isEmpty()) {
            // At the base condition we will add the processed string to our answer list
            ArrayList<String> li = new ArrayList<>();
            li.add(processed);
            return li;

        }

        // Taking answer from both the arraylist parts and then combining those answers
        // together

        char n = s.charAt(0);

        // A GOOD QUESTION TO CLEAR INDEPT UNDERSTANDING OF RECURSSION CAN BE TO ASK WHY
        // WE ARE PASSING
        // PROCSSED + N AND NOT 'N+PROCESSED' THE ONLY REASON BEHIND THIS THING IS THE
        // WAY FUNCTION CALLS ARE
        // MADE AND RETURNED THROUGH THE STACK AND THE WAY COLLECTIVE ANSWERS ARE
        // RETURNED

        ArrayList<String> left = printSubsequencesReturnList(s.substring(1), processed + n);
        ArrayList<String> right = printSubsequencesReturnList(s.substring(1), processed);

        // COMBINING THE LEFT SIDE AND RIGHT SIDE ANSWERS TOGETHER
        left.addAll(right);
        return left;
    }

    public static ArrayList<String> printSubsetsContainsASCII(String s, String processed) {
        if (s.isEmpty()) {
            // At the base condition we will add the processed string to our answer list
            ArrayList<String> li = new ArrayList<>();
            
            li.add(processed);
            return li;

        }

        // Taking answer from both the arraylist parts and then combining those answers
        // together

        char n = s.charAt(0);

        // A GOOD QUESTION TO CLEAR INDEPT UNDERSTANDING OF RECURSSION CAN BE TO ASK WHY
        // WE ARE PASSING
        // PROCSSED + N AND NOT 'N+PROCESSED' THE ONLY REASON BEHIND THIS THING IS THE
        // WAY FUNCTION CALLS ARE
        // MADE AND RETURNED THROUGH THE STACK AND THE WAY COLLECTIVE ANSWERS ARE
        // RETURNED

        ArrayList<String> left = printSubsetsContainsASCII(s.substring(1), processed + n);

        // IF I CHOOSE TO SELECT A CHARACTER THEN ONLY IT'S ASCII VALUE WOULD BE
        // CONSIDERED RIGHT ? => YES
        ArrayList<String> selectASCII = printSubsetsContainsASCII(s.substring(n), processed + (n + 0));

        ArrayList<String> right = printSubsetsContainsASCII(s.substring(1), processed);

        left.addAll(selectASCII);
        left.addAll(right);

        return left;
    }

}
