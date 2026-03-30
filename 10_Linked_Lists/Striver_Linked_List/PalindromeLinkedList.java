

public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        // precondition checks where the linked list is empty
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip middle if odd
        if (fast != null) {
            slow = slow.next;
        }

        // slow points to the middle of the linked list
        ListNode secondHalf = getReverseHead(slow);
        ListNode firstHalf = head;

        // Important to note that the second half would always be
        // shorter or in equal length as compared to the first half
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;

        }

        return true;

    }

    public ListNode getReverseHead(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;

    }

}
