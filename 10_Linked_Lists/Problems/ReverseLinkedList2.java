import java.lang.classfile.components.ClassPrinter.ListNode;

public class ReverseLinkedList2 {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (right - left <= 0 || head == null) {
            return head;
        }

        ListNode dummy;
        dummy.next = head;


        int i = 1;

        while (i < left) {
            current = current.next;
            i++;
        }

        leftPrev = current;
        current =current.next;
        ListNode tail =current;

        ListNode current = dummy;
        ListNode prev = null;
        ListNode next = null;
        ListNode leftPrev = null;


        i = (right - left) + 1;

        while (i > 0 && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i--;
        }

        leftPrev.next=prev
        leftPrev.next.next=current;

     
        return dummy.next;

    }

}
