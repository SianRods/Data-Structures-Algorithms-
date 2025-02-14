
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class intersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode t1 = headA;
        ListNode t2 = headB;
        
        if (headA == headB) {
            return headA;
        }
        
        int l1 = 1;
        int l2 = 1;
        
        // Count the Length of the LinkedLists
        while (t1 != null && t1.next != null) {
            t1 = t1.next;
            l1++;
        }

        while (t1 != null && t1.next != null) {
            t1 = t1.next;
            l2++;
        }

        // Calculate the difference between the lengths
        int diff = Math.abs(l1 - l2);

        // Move the larger LinkedLists ahead so that it's size is same to that of the smaller one
        if (l1 > l2) {
            // Bring one t1orary variable to the equal size of the lists
            t1 = headA;
            t2 = headB;
            for (int i = 0; i < diff; i++) {
                t1 = t1.next;
            }

        }

        else if (l1 <= l2) {
            // Bring one t1orary variable to the equal size of the lists
            t1 = headA;
            t2 = headB;
            for (int i = 0; i < diff; i++) {
                t2 = t2.next;
            }
        }

        // if the lenght of anyone is 1 then check 
        if (t1 == t2) {
            return t1;
        }


        // if both have variable length reach the common point of intersection
        while (t2.next != null && t1.next != null) {
            if (t1 == t2) {
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }


        // if the common node is at the Last
        if (t1 == t2) {
            return t1;
        }

        // No common Point return NULL
        return null;

    }
}

// -----------------------------------------------------------------------------------------------------------
// Some of the Important Test cases
// 1]. listA=[1] , listB=[1] , and interesectVal=1 skipA=0; skipB=0; --> here in this case both the heads points to the next Node
// 2]. ListA=[1,51] listB=[2,4,6,....,50,51] --> here the common node is at the end of the twoLinkedLists check at what point does the Loop exits
// 3]. ListA=[3]  listB = [1,3] intersectVal=3  skipA==0 skipB=1 --> here we can't use the end wala while loop 