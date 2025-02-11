
public class mergeSortedLists {
    public static void main(String args[]) {
        SolutionLinkedLists l1 = new SolutionLinkedLists();
        SolutionLinkedLists l2 = new SolutionLinkedLists();

        l1.addFirst(4);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.display();

        l2.addFirst(4);
        l2.addFirst(3);
        l2.addFirst(1);
        l2.display();

        l1.mergeLists(l1,l2).display();
        

    }

} 