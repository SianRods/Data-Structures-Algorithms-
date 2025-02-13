package Queues;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*  In Java Queues internnaly are implemented as a Interface so there are set of methods in the Queues Interface
 *  Which has to be implemented using other dependent datastructures like Linked List  or Stack 
 *  
 *  Queue <Data Type> q1 = new LinkedList<>();
 *  It is a Data Structure Based on the approach of LAST IN LAST OUT 
 *  Items added to the front are the one's getting out First
 * 
 * Important Methods in Queue -->
 *  1.add() --> adding element to the end of the queue
 *  2.peek() --> returns the head of the queue
 *  3.pop() --> Returns and removes the head of the queue
 * 
 * 
 * 
 * 
 */

public class InbuiltQueues {

    public static void main(String[] args) {
        Queue<Integer> qq = new LinkedList<>();
 
        qq.add(243);
        qq.add(84);
        qq.add(7234);

        System.out.println(qq.peek());
        System.out.println(qq.element());
        System.out.println(qq.remove(7234));


    }
    
}