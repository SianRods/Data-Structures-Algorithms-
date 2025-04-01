package PracticeProblems_intern;

import java.util.Arrays;

public class SortingLinkedList extends SolutionLinkedLists {
    public static void main(String[] args) {
        SolutionLinkedLists s1 = new SolutionLinkedLists();
        s1.display();
        sortList(s1);
        s1.display();

    }

    static void sortList(SolutionLinkedLists s1) {
        ListNode temp = head ;
        int size=0;
        while(temp.next!=null){
            size++;
            temp=temp.next;
        }

        int arr[] = new int[size];

        temp=head;
        for(int i=0;i<arr.length;i++){
            arr[i]=temp.data;
            temp=temp.next;
        }

        Arrays.sort(arr); // O(NlogN)

        temp=head;
        while(temp.next!=null){
            temp.data=arr[i];
            temp=temp.next;
        }



    }

}
