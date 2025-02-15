public class sample {
    public static void main(String[] args) {
        SolutionLinkedLists sl = new SolutionLinkedLists();
        SolutionLinkedLists l2 = new SolutionLinkedLists();
        sl.addLast(9);
     
        l2.addLast(1);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);
        l2.addLast(9);


        System.out.println(sl.returnNumber(sl));
        System.out.println(l2.returnNumber(l2));
    }
}
