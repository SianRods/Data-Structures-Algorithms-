
import java.util.Stack;

public class RainWaterTrap {

    public static void main(String[] args) {
        int sample1[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int sample2[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trap(sample1));
    }

    static int trap(int height[]) {
        Stack<Integer> st = new Stack<>();
        int vol = 0;

        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int bottom = st.pop(); // Middle element forming the trapped water base

                if (st.isEmpty()) {
                    break; // No left boundary, so no trapped water
                }

                int left = st.peek(); // Left boundary
                int width = i - left - 1; // Distance between left and right bars
                int heightDiff = Math.min(height[left], height[i]) - height[bottom]; // Effective height

                vol += width * heightDiff; // Add trapped water volume
            }
            st.push(i);
        }
        return vol;
    }

}