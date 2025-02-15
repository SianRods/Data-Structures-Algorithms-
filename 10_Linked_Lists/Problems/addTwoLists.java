import java.math.BigInteger;

// This is a very inefficient solution 
// issues --> 1] Overflow issue
//  2] First calculating the sum and then adding the sum one by one is computationally heavy and is unecessary step 
// of calculating this thing




class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Using BigInteger to avoid overflow
        BigInteger num1 = returnNumber(l1);
        BigInteger num2 = returnNumber(l2);

        BigInteger sum = num1.add(num2); // Perform addition safely

        // Convert sum back to a linked list
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        if (sum.equals(BigInteger.ZERO)) {
            return new ListNode(0);
        }

        while (!sum.equals(BigInteger.ZERO)) {
            temp.next = new ListNode(sum.mod(BigInteger.TEN).intValue()); // Extract last digit
            temp = temp.next;
            sum = sum.divide(BigInteger.TEN); // Remove last digit
        }

        return dummy.next; // Return the actual result (skip dummy node)
    }

    public BigInteger returnNumber(ListNode l1) {
        ListNode temp = l1;
        BigInteger num1 = BigInteger.ZERO;
        BigInteger place = BigInteger.ONE;

        while (temp != null) {
            num1 = num1.add(place.multiply(BigInteger.valueOf(temp.val))); // Compute value
            place = place.multiply(BigInteger.TEN); // Increase place value (10^n)
            temp = temp.next;
        }

        return num1;
    }
}
