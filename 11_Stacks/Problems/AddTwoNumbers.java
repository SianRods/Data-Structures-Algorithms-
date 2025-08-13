package Problems;

import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            // Keep on continuing and adding newNode in the Linked list till either of the above 
            // COndition remains true;

            // Carrying Forward the carry variable properly throughout the while() ==> Loop()
            int sum = carry;
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            // Adding the new nodes in the linkedlist properly 
            head = newNode;

            carry = sum / 10;
        }

        return head;
    }

}
