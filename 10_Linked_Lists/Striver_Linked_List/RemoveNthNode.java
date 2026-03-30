public class RemoveNthNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Nth node from the last is L-N+1 (1-indexed based)

        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int idx = len - n + 1;

        if (idx == 1)
            return head.next;

        temp = head;
        for (int i = 1; i < idx - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;

    }

}
