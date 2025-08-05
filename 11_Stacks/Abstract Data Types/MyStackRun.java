public class MyStackRun {
    public static void main(String[] args) {
        // ArrayStack stack = new ArrayStack();
        // stack.push(123);
        // stack.push(1342);
        // stack.push(23);
        // stack.push(64);
        // stack.push(74);
        // // stack.push(37);
        // System.out.println(stack.peek());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());


        // System.out.println("Stacks using Linked List");
        // StackLL ll = new StackLL();
        // ll.push(123);
        // ll.push(1342);
        // ll.push(23);
        // ll.push(64);
        // ll.push(74);
        // // ll.push(37);
        // System.out.println(ll.peek());
        // // System.out.println(ll.pop());
        // // System.out.println(ll.pop());
        // ll.display();


        System.out.println("Stacks using Dynamic Array");
        ArrayDynamicStack dyn = new ArrayDynamicStack();
        dyn.push(123);
        dyn.push(1342);
        dyn.push(23);
        dyn.push(64);
        dyn.push(74);
        dyn.push(37);
        System.out.println(dyn.peek());
        System.out.println(dyn.pop());
        System.out.println(dyn.pop());
    



    }
}
