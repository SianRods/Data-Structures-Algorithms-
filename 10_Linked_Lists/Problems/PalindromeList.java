import java.util.Stack;

public class PalindromeList extends SolutionLinkedLists {
    public static void main(String[] args) {
        SolutionLinkedLists s1 = new SolutionLinkedLists();
        s1.addFirst(2);
        // s1.addFirst(2);
        s1.addFirst(1);
        // s1.addFirst(1);
        // s1.addFirst(1);
        s1.display();
        System.out.println(isPalindromeOptimized(s1));

    }

    static boolean isPalindrome(SolutionLinkedLists s1) {
        Stack<Integer> st = new Stack<>();
        Node temp = s1.head;

        while (temp.next != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        st.push(temp.data);

        temp = s1.head;

        while (!st.isEmpty()) {
            if (temp.data == st.pop()) {
                temp = temp.next;

            } else {
                return false;
            }
        }
        return true;

    }

    // OPTIMIZED SOLUTION --> Maintaining Tail an header pointer and then deleting
    // the list
    static boolean isPalindromeOptimized(SolutionLinkedLists s1) {
        Node slow = s1.head;
        Node fast = s1.head;


    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // Now the slow points to the middle of the linked list

        Node reversedHead= ReverseLinkedListFromNode(slow); // Reset slow to the head of the reversed list
        Node firstHalf = s1.head;
        while (reversedHead != null) {
            if (reversedHead.data == firstHalf.data) {
                reversedHead= reversedHead.next;
                firstHalf = firstHalf.next;
            } else {
                return false;
            }
        }


        // Retaining the Structure of the Linked List
        ReverseLinkedListFromNode(reversedHead);
        return true;
    }

    // Reversing the Linked List from a Node
    static Node ReverseLinkedListFromNode(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev; // Return the new head of the reversed list
    }

}
