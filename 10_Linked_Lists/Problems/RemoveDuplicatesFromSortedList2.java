package 10_ Linked_Lists.Problems;

// node.val & node.next

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        // We maintaing two pointers in this problem to be able to deal with previous reference and current reference
        // we store the val for repated nodes and skip all the nodes with similar value for the data 
        // The Problem of skipping the initial part if repititive is dealt by assigning prev initially to null 
        // If it continues to remain null then we reassing head else we skip in between repititive values 
        ListNode current = head;
        ListNode prev= null;

        // The main while loop must run till the current pointer equals null as if we stop at current.next == null
        // then the last most element is not handled properly 
        while (current!=null){
            if(current.next!=null && current.val==current.next.val){
                int data =  current.val;
                while(current.val==data){
                    current=current.next;
                }
                if(prev!=null){
                    prev.next=current;

                }else{
                    head=current;
                }
            }else{
                prev=current;
                current=current.next;
            }
        }
        return head;
    }

}
