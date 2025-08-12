package Problems;

import java.util.HashMap;
import java.util.Stack;

public class BasicCalculator_2 {

    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        // All have the associativity of left to right 
        hm.put('*', 4);
        hm.put('/', 3);
        hm.put('+', 2);
        hm.put('-', 1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Skipping the Blank Spaces
            if (c == ' ')
                continue;

            if (!hm.containsKey(c)) {
                // Read full number (could be multiple digits)
                StringBuilder num = new StringBuilder();
                while (i < n && !hm.containsKey(s.charAt(i)) && s.charAt(i) != ' ') {
                    num.append(s.charAt(i));
                    i++;
                }

                // Direclty addding the number to the stack;
                st.push(Integer.parseInt(num.toString()));
                i--; // because for-loop will increment i
                continue;
        }else{
            // if we have the operators then before popping out the number we should check that 
        }
    }

}
