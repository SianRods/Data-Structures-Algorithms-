public class ContainerWithMostWater {

    public static void main(String args[]) {
        // int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int height[] = { 1, 1 };
        System.out.println("The Maximum Area Occupied by the Container is " + maxArea(height));
    }

    static int maxArea(int height[]) {
        // Take Two Pointers on from Start and other from the end
        // At Each step calculate the volume and compare it with the already available
        // volume and assign if greater
        // move the pointer towards the smaller height index and keep on repeating till
        // the end conndition is satisfied
        // Which is ! start>end ;
        int vol = 0;
        int start = 0;
        int end = height.length - 1;

        do {
            int cal = (end - start) * Math.min(height[start], height[end]);
            if (cal > vol) {
                vol = cal;
            }

            if (height[start] == Math.min(height[start], height[end])) {
                start++;
            } else if (height[end] == Math.min(height[start], height[end])) {
                end--;
            }

        } while (!(start > end));

        return vol;

    }

}
