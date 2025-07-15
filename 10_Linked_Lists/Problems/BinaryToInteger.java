import java.lang.classfile.components.ClassPrinter.ListNode;

public class BinaryToInteger {
    public static void main(String[] args) {

    }

    public static int getDecimalValue(ListNode head) {

        ListNode temp=head
        int n=0;

        while (temp!=null) {
            n++;
            temp=temp.next;
        }

        int result=0;

        temp=head;
        int j=n-1;
            while (temp!=null) {
           result+=Math.pow(2, j);
            temp=temp.next;
            j--;
        }

        return result;

        }

}
