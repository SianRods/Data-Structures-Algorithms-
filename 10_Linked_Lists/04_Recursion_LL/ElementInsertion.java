// Two ways of imp[lementing a linkedlists 
// 1. First we can use void return type and modify the Linked list
// 2. we can have a node return type pointing to the exact position where we want the insertion to take place 

public class ElementInsertion {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.display();
        ll.recursionInsertion(1, 44);
        ll.display();
    }
}