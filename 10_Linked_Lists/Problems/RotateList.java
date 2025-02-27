import java.lang.Thread.State;
import java.lang.classfile.components.ClassPrinter.ListNode;

public class RotateList {
    public static void main(String[] args) {

    }


    // APPLYING THE CONCEPT OF THE CIRCULAR LINKED LIST
    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length of the list
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Make the singly list circular by connecting the last node to the head
        temp.next = head;

        // Calculate the circular index to which the new head has to be shifted from the
        // starting head
        k = k % length; // To be shifted from the start head
        int stepsForward = length - k;
        temp = head;
        for (int i = 1; i < stepsForward; i++) {
            temp = temp.next;
        }

        // Set the new head and break the circle
        ListNode solHead = temp.next;
        temp.next = null;

        return solHead;
    }

    // BELOW APPROACH WAS MY INTITAL NORMAL UNECESASRY APPPORACH --> 
    // Solution using the Linear Singly List Operations -->
    // static ListNode rotateList(ListNode ;head, int k) {
    // // Shift the head and the tail position
    // ListNode temp = head;
    // ListNode temp2;

    // if(head==null || head.next==null|| k==0){
    // return head;
    // }
    // else{
    // while (temp.next.next != null) {
    // temp = temp.next;
    // }
    // temp2=temp.next;
    // temp.next=null;
    // temp2.next=head.next;
    // head=temp2;

    // k--;
    // return rotateList(ListNode head , int k);
    // }
    // return null;

    // }

    // Using the Concept of the Cirular List (Circular Linked List)


}
