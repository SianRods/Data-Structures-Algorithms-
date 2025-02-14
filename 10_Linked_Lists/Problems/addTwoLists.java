import java.lang.classfile.components.ClassPrinter.Node;
import java.util.LinkedList;

public class addTwoLists {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

    }

    static LinkedList<Integer> addLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {

        LinkedList<Integer> sol = new LinkedList<>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        Node temp = headA;
        while (temp.next != null) {
            num1.append(temp.data);
            temp = temp.next;
        }

        Node temp = headB;
        while (temp.next != null) {
            num2.append(temp.data);
            temp = temp.next;
        }

        num1.reverse();
        num2.reverse();

        int sum = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
        num1=new StringBuilder(String.valueOf(sum));


        while(sum!=0){

        }
        

    }
}
