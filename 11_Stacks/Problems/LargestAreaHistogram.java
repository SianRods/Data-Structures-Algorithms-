package Problems;

import java.util.Stack;

public class LargestAreaHistogram {

    public static void main(String[] args) {

    }

    static int maxAreaHistogram(int heights[]) {
        Stack<Integer> st = new Stack<>();
        int max = 0;

        // Initially pushing the starting index
        st.push(0);

        for (int i = 0; i < heights.length; i++) {

            // WE WILL KEEP ON PUSHING ALL INDICES IN STACK AND CALCULATE THEIR AREA UNLESS
            // WE GET A
            // MONOTNOICALLY INCREASING HEIGHTS
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                // Creating a seperate function which can be used to update the maximum area
                // till a given point
                // in the stack
                //
                max = getMaxValue(heights, st, max, i);
            }

            st.push(i);
        }

        // Calculating for the last index
        int i = heights.length;

        // updating for the last most remaining index position
        while (!st.isEmpty()) {
            max = getMaxValue(heights, st, max, i);
        }

        return max;

    }

    static int getMaxValue(int heights[], Stack<Integer> st, int max, int index) {
        int areaCurrent;
        int poppedIndex = st.pop();

        if (st.isEmpty()) {
            // if the stack is empty then calculating the area for the current index only
            // here we will take only it's height
            areaCurrent = heights[poppedIndex] * index;
        } else {
            areaCurrent = heights[poppedIndex] * (index - 1 - st.peek());
            // here the index denotes next smallest value and st.peek() represents -->
            // previous smallest values
            // the above formula and the concept denotes the entirety of this whole sum
        }
        return Math.max(max, areaCurrent);
    }

}
