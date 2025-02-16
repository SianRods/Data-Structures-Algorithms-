import java.lang.classfile.components.ClassPrinter.ListNode;

public class removeElementsOfLinkedLists {
    public static void main(String[] args) {
        SolutionLinkedLists sl = new SolutionLinkedLists();

    }

 class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode t1 = head;
        ListNode t2 = null;

        if (head == null) {
            return head;
        } else {
            while (t1 != null) {
                if (t1.val == val) {
                    if (t2 == null) {
                        t1 = head.next;
                        head = t1;
                        continue;
                    }
                    t2.next = t1.next;
                    t1 = t1.next;
                    continue;
                }
                t2 = t1;
                t1 = t1.next;
            }
            return head;
        }
    }
}
}
