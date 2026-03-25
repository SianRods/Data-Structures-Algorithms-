public class CycleStart {

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

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }

        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;

        }

        return slow;

    }

}
