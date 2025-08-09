
package Problems;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        // The thing is that it can be in simplest be imagined as a problem which has
        // height equivalent to
        // the top to bottom continuous stancted 1' but the base may not be at the same
        // level

        int updatedInput[][] = new int[matrix.length][matrix[0].length];
        // Updating the Matrix Element in the prefix Sum Format
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == '0') { // check char against '0'
                    sum = 0;
                } else {
                    sum += 1; // only increment if it's '1'
                }
                updatedInput[i][j] = sum;
            }
        }

        int sol = 0;
        for (int i = 0; i < updatedInput.length; i++) {
            sol = Math.max(sol, largestAreaHist(updatedInput[i]));
        }

        return sol;

    }

    public int largestAreaHist(int arr[]) {
        int n = arr.length;
        // This is a optimized appraoch in which we will follow and keep collecting the
        // previous_small_element (monotonically increasing stack )
        // and hence the moment we get an element arr[st.peek()]>=arr[i] ==> it is the
        // Next Smaller Element .Hence we will keep calculating backwards till
        // this given condition is true
        Stack<Integer> st = new Stack();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int currElement = st.pop();
                if (st.isEmpty()) {
                    maxArea = Math.max(maxArea, arr[currElement] * (i - 0));
                } else {
                    maxArea = Math.max(maxArea, arr[currElement] * (i - st.peek() - 1));
                }
            }

            // Now pushing the element in the array after maintaining the monotnocity
            st.push(i);
        }

        // Now all the elements which are remaining in the stack at the end of the above
        // iteration can form
        // reactanlge with area having width till the size of the arr=n and it's
        // previous small element which can be obtained
        // after popping the element from the stack and then st.peek() == is pse of
        // st.pop() performed earlier
        while (!st.isEmpty()) {
            int currElement = st.pop();
            if (st.isEmpty()) {
                maxArea = Math.max(maxArea, arr[currElement] * (n - 0));
            } else {
                maxArea = Math.max(maxArea, arr[currElement] * (n - st.peek() - 1));
            }
        }

        return maxArea;

    }

}