// Note that stacks are internally implemented using --> Arrays Only
// push() method --> adding into the Stack and pop() --> removing the last added element from the Stack 


// Stacks can be used internally --> ADT
// Stacks can be made using Linked Lists 
// Stack can also be made using Arrays 
import java.util.Stack;

public class InbuiltStacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(213);
        stack.add(3242);
        stack.add(2323);
        stack.add(213);

        stack.

        System.out.println(stack.isEmpty());
        System.out.println(stack.lastIndexOf(213)); // Returns First Based Position from the Top of the Stack
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
