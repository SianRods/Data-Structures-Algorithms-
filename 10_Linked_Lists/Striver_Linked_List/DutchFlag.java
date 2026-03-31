public class DutchFlag {
    public static void main(String[] args) {

    }

    public static class ListNode {
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

    public static ListNode dutchFlagSort(ListNode head) {
        // the below nodes will never be null as we have created then
        // initialize them with -1 for better
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zeroHead = new ListNode(-1);

        ListNode oneTail = oneHead;
        ListNode twoTail = twoHead;
        ListNode zeroTail = zeroHead;

        // always remember that the improper handling of links and reference pointers
        // can result in unnecessary cycle creations
        while (head != null) {

            // save the old link
            ListNode next = head.next;
            // break the link
            head.next = null;

            int val = head.val;
            switch (val) {
                case 0 -> {
                    //connect
                    zeroTail.next = head;
                    // move ahead
                    zeroTail = head;

                }
                case 1 -> {
                    oneTail.next = head;
                    oneTail = head;
                }
                case 2 -> {
                    twoTail.next = head;
                    twoTail = head;
                }

            }

            head = next;

        }

        // if there are no one's then directly connect with the two
        zeroTail.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;

        return zeroHead.next;

    }

}
