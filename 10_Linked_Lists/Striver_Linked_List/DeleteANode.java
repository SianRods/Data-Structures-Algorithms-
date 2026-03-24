
public class DeleteANode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        // Copy the next node's value to the current code 
        node.val = node.next.val;
        // once the value has been copied 
        // skip the successor node and current it to the next.next node 
        // which won't be null as per the give problem statement 
        node.next = node.next.next;
    }

}
