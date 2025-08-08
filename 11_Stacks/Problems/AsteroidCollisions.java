package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollisions {

    public static void main(String[] args) {
        // dry run version
        int arr[] = { 5, 10, -5 };
        System.out.println(Arrays.toString(asteroidCollisionWrongCode(arr)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        // Simply Maintain a LIFO stack and keep on traversing the elements and
        // Keep on adding the positive elements till we enounter a valid collision that
        // is a negative element
        // so we keep on popping all the positive ones which can be detroyed by the
        // collision with negative
        // and continue traversing ahead in the array

        int n = asteroids.length;
        int i = 0;
        List<Integer> li = new ArrayList<>();

        while (i < n) {
            if (asteroids[i] > 0) {
                li.addLast(asteroids[i]);
            } else {
                // Means asteroid is travelling in the leftward direction so keep on comparing
                // with all the elements travelling towards rightwards direction which are seen
                // till
                // before thaat negative element
                int l = asteroids[i];

                while (!li.isEmpty() && li.getLast() < Math.abs(l) && li.getLast() > 0) {
                    li.removeLast();
                }

                if (!li.isEmpty() && li.getLast() == Math.abs(l)) {

                    li.removeLast();
                } else if (li.isEmpty() || li.getLast() < 0) {
                    // if the negative part destroys all the previous asteroids ==> add it to the
                    // stack
                    li.addLast(l);
                }

            }
            i++;
        }

        // Adding the elements remaining in the stack to the array

        int sol[] = new int[li.size()];
        for (int j = 0; j < sol.length; j++) {
            sol[j] = li.getFirst();
            li.removeFirst();
        }

        return sol;
    }

    public static int[] asteroidCollisionWrongCode(int[] asteroids) {

        /*
         * # Note that the following solution to the problem due to the miss
         * intrepretation
         * of how the asteroid collision question actually works . The main crisp of the
         * question
         * was understood by me but the importance of the relative positions of the
         * asteroids and their
         * signs is also important as they will decide whether a collision is even
         * possible or not
         * 
         * EDGE CASE : [-2,-1,1,2]
         * 
         */

        Stack<Integer> left = new Stack();
        Stack<Integer> right = new Stack<>();
        int n = asteroids.length;
        // Adding all the left direction elements from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (asteroids[i] < 0)
                left.push(asteroids[i]);
        }

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0)
                right.push(asteroids[i]);
        }

        // continue while either of the stack becomes empty
        while (!left.isEmpty() && !right.isEmpty()) {
            int l = -1 * left.pop();
            int r = right.pop();
            if (l > r) {
                left.push(-1 * l);
            } else if (r > l) {
                left.push(r);
            }
        }

        // now making an array equivalent to the size of either of the stacks if any of
        // those are still empty

        int sol[] = new int[Math.max(left.size(), right.size())];
        if (!left.isEmpty()) {
            int i = 0;
            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while (!right.isEmpty()) {
                sol[i] = right.pop();
                i++;
            }
        } else {

            int i = 0;
            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            while (!left.isEmpty()) {
                sol[i] = left.pop();
                i++;
            }
        }

        return sol;

    }

}
