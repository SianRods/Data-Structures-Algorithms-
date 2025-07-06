import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class PhoneNumberCombinationMade {
    public static void main(String[] args) {
        String s="23";
        System.out.println(letterCombinations(s, ""));
    }

    // Here we have to use the similar apporach as that of processed and unprocssed
    // part of the string
    // for selecting the subset from a given string
    public static List<String> letterCombinations(String digits, String processed) {
        // Here we have to write a code to form a subset combination for variable length
        // calls depending
        // upon the size of each of the string which has been mapped to a particular
        // number

        if (digits.isEmpty()) {
            List<String> li = new ArrayList<>();
            li.add(processed);
            return li;
        }

        int digit = digits.charAt(0) - '0';
        List<String> list = new ArrayList<>();
        
        for (int i = (digit -2) * 3; i < (digit-1) * 3; i++) {
            char ch = (char) ('a' + i);
            list.addAll(letterCombinations(digits.substring(1), processed + ch));
        }
        return list;
    }

    public static String digitMapping(char ch) {
        Hashtable<Character, String> hm = new Hashtable<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        return hm.get(ch);
    }

}
