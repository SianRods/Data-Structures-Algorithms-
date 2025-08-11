import java.util.Stack;

public class BackStringCompare {

    // Note that after backspacing an empty text, the text will continue empty.
    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> t1 = new Stack<>();
        Stack<Character> t2 = new Stack<>();

        int n1 = s.length();
        int n2 = t.length();
        int i = 0;
        int j = 0;

        // Process the string s first
        while (i < n1) {    

            if (s.charAt(i) == '#') {
                if (!t1.isEmpty()) {
                    t1.pop();
                }
            } else {

                t1.push(s.charAt(i));
            }

            i++;
        }

        displayStack(t1);

        while (j < n2) {
            if (t.charAt(j) == '#') {
                if (!t2.isEmpty()) {
                    t2.pop();

                }
            } else {

                t2.push(t.charAt(j));
            }

            j++;
        }

        displayStack(t2);

        if (t1.size() != t2.size())
            return false;

        while (!t1.isEmpty() && !t2.isEmpty()) {
            if (t1.pop() != t2.pop())
                return false;
        }

        // Check if either of the stack remains empty after the above iteration
        if (!t1.isEmpty())
            return false;
        if (!t2.isEmpty())
            return false;

        return true;

    }

    public static void main(String[] args) {
        // String s = "ab#c";
        // String t = "ad#c";
        String s = "bxj##tw";
        String t = "bxj###tw";
        backspaceCompare(s, t);

    }

    public static void displayStack(Stack<Character> st) {
        System.out.println("Stack Display :");
        while (!st.isEmpty()) {
            System.out.println("| " + st.pop() + " |");
        }
        System.out.println("|___|");
    }
}
