import java.lang.classfile.components.ClassPrinter.ListNode;

public class ReverseLinkedListApproach2SwapData {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = head;
        
        ListNode rightNode = head;

        int i = 1;
        while (i <= left) {
            leftNode=leftNode.next;
            i++;
        }
        i=1;
        while (i<=right) {
            rightNode=rightNode.next;
            i++;
            
        }

        while(right-left!=0){
            
        }

    }
}
