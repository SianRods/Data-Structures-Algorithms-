
import java.util.PriorityQueue;

public class MergeKSortedList {

    // Implementing it using
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;

        }

    }

    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int n = lists.length;

        if (n == 0) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        // now all the heads are added to the pq ;
        ListNode sortedList = new ListNode();
        ListNode head = sortedList;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            head.next = smallest;
            head = head.next;
            if (smallest.next != null) {

                pq.add(smallest.next);
            }

        }

        return sortedList.next;

    }

}