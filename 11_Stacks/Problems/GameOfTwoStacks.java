package Problems;
// https://www.hackerrank.com/challenges/game-of-two-stacks/problem

import java.util.Arrays;

public class GameOfTwoStacks {
    public int twoStacks(int maxSum,int a[],int [] b){
        return twoStacks(maxSum, a, b , 0 , 0) -1;
    }

    static int twoStacks(int maxSum, int[] a, int[] b, int sum, int count) {
        if (sum > maxSum) {
            return count;
        }

        // If one of the arrays comes to and end Arrays.copyOfRange() --> will become zero 
        if(a.length==0 || b.length==0){
            // return the accumulated count
            return count;
        }


        // here we are using the recursion to check the obtain the max value of count from each value 
        int sumA = twoStacks(maxSum, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int sumB = twoStacks(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);
        return Math.max(sumA, sumB);
    }
}
