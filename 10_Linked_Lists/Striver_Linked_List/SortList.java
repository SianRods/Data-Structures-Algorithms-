import java.util.Arrays;

public class SortList {

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

    public static void main(String[] args) {

    }

    public static ListNode findMiddleNode(ListNode head) {
        // here in case of even number of nodes we need to return
        // the first middle node
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortLL(ListNode head) {
        // base condition of length=1 | length = null
        if (head == null || head.next == null) {
            return null;
        }

        // divide the linked list into two equal halfs
        ListNode mid = findMiddleNode(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;

        // cut the connection between both the nodes
        mid.next = null;

        leftHead = sortLL(leftHead);
        rightHead = sortLL(rightHead);

        // return the head of the merged linked list
        return mergeLL(leftHead, rightHead);
    }

    public ListNode bruteForce(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int arr[] = new int[size];

        temp = head;
        int i;
        for (i = 0; i < arr.length; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }

        Arrays.sort(arr); // O(NlogN)

        temp = head;
        i = 0;

        while (temp != null) {
            temp.val = arr[i];
            i++;
            temp = temp.next;
        }
        return head;
    }

}
