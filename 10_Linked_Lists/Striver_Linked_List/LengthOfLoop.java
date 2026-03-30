public class LengthOfLoop {
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

    public static int getLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;

            }
        }

        // assuming there is definitely a cycle present in the linked list
        int len = 0;

        do {
            len++;
            slow = slow.next;

        } while (slow != fast);

        return len;

    }

}
