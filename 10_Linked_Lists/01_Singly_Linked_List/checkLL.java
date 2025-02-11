
public class checkLL {
    public static void main(String args[]) {
        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(21);
        ll.addFirst(212);
        ll.addFirst(42342);
        ll.addLast(11);
        ll.display();
        System.out.println();
        ll.printLocation();
        ll.addPosition(32, 3);
        ll.display();
        System.out.println("The size of the current Linked Listis : " + ll.getSize());
        ll.deletePosition(2);
        ll.display();
    }
}
