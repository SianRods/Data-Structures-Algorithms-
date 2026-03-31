
import java.util.List;

public class IntersectionOfTwoLinkedLists {

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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        if (lenA > lenB) {
            int diff = lenA - lenB;

            while (diff-- > 0) {
                tempA = tempA.next;
            }
        } else if (lenB > lenA) {
            int diff = lenB - lenA;
            while (diff-- > 0) {
                tempB = tempB.next;
            }
        }
        // now that both the heads are aligned
        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;

    }

    public static int getLength(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        return size;

    }

    // The difference of length method requires various steps to work on it.
    // Using the same concept of difference of length, a different approach can be
    // implemented.
    // The process is as follows:-

    // Take two dummy nodes for each list. Point each to the head of the lists.
    // Iterate over them. If anyone becomes null, point them to the head of the
    // opposite lists
    // and continue iterating until they collide.

    public static ListNode optimalTwo(ListNode headA, ListNode headB) {
        // here we use two dummy pointers and keep on iterating them over the list
        // until both the pointers meet together
        ListNode d1 = headA;
        ListNode d2 = headB;
        while (d1 != d2) {
            d1 = d1 == null ? headA : d1.next;
            d2 = d2 == null ? headB : d2.next;
        }

        //  if no intersection then they will intersect at 
        return d1;

    }

}
