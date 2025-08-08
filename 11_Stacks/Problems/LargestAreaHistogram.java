package Problems;

import java.util.Stack;

public class LargestAreaHistogram {

    public static void main(String[] args) {

        int arr[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(arr));

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

    // Solving the problem using nse and pse

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int pse[] = findPSE(heights);
        int nse[] = findNSE(heights);

        // The area of each of the height in heights will maximum span upto
        // area = height*(pse-nse-1)
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (pse[i] - nse[i] - 1));
        }

        return maxArea;

    }

    public static int[] findNSE(int[] heights) {
        int n = heights.length;
        int j = n - 1;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();

        while (j >= 0) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[j]) {
                // While the top of the stack is greater than the current element keep on poping
                // to maintain the monotonically decresing order
                st.pop();
            }

            if (st.isEmpty()) {
                nse[j] = n;
            } else {
                nse[j] = st.peek();
            }
            st.push(j);
            j--;
        }

        return nse;

    }

    public static int[] findPSE(int[] heights) {
        int n = heights.length;
        int j = 0;
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();

        while (j < n) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[j]) {
                // While the top of the stack is greater than the current element keep on poping
                // to maintain the monotonically decresing order
                st.pop();
            }

            if (st.isEmpty()) {
                pse[j] = -1;
            } else {
                pse[j] = st.peek();
            }
            st.push(j);
            j++;
        }

        return pse;
    }

}
