public class MergeSortedLists {

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

    private ListNode mergeLL(ListNode leftHead, ListNode rightHead) {
        // note that this function will be returning the final head of the
        // linked list

        ListNode head = new ListNode();
        // using an additonal linked list
        ListNode tail = head;

        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                tail.next = leftHead;
                leftHead = leftHead.next;
                tail = tail.next;
            } else {
                tail.next = rightHead;
                rightHead = rightHead.next;
                tail = tail.next;
            }

        }

        // adding the remaining nodes to the linked lists
        while (leftHead != null) {
            tail.next = leftHead;
            leftHead = leftHead.next;
            tail = tail.next;
        }

        while (rightHead != null) {
            tail.next = rightHead;
            rightHead = rightHead.next;
            tail = tail.next;

        }

        return head.next;

    }

}
