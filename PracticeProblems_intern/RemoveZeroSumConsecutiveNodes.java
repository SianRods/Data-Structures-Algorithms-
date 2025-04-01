package PracticeProblems_intern;

import java.lang.classfile.components.ClassPrinter.ListNode;

public class RemoveZeroSumConsecutiveNodes {
    public static void main(String[] args) {

    }

    static ListNode removeZeroFromSubLists(ListNode head) {
        ListNode t1 = head;
        ListNode t2 = head.next;
        ListNode prev = null;
        // If the list has only one element
        if (t2 == null) {
            return head;
        }

        // break Condition inside the Loop when one of the pointer reaches --> Null {End
        // of the List }
        while (true) {
            if (t1.val + t2.val == 0) {
                if (prev == null) {
                    head = head.next.next;
                    continue;
                } else {
                    prev.next = t2.next;
                    t1 = prev;
                    t2 = prev.next;
                }
            } else {
                prev = t1;
                if (t2 == null || t2.next == null) {
                    break;
                }
                // or else continue scanning the list
                t1 = t1.next;
                t2 = t2.next;

            }
            return head;
        }
    }

}
