
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {

        // Get the Java Runtime
        Runtime runtime = Runtime.getRuntime();

        // Optional: Suggest a Garbage Collection before starting for a cleaner baseline
        runtime.gc();

        // 1. Start Tracking Memory and Time
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        // --- YOUR CODE GOES HERE ---
        // String s = "MCMXCIV";
        String s = "LVIII";
        System.out.println(solution1(s));

        // 2. Stop Tracking
        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        // 3. Calculate and Print
        long durationMs = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
        long memoryUsedBytes = endMemory - startMemory;
        double memoryUsedMb = memoryUsedBytes / (1024.0 * 1024.0);

        System.out.println("Runtime: " + durationMs + " ms");
        System.out.printf("Memory Used: %.4f MB%n", memoryUsedMb);
    }

    public static int solution1(String s) {
        // maintain a map for the character to integer mappingn
        // traverse the string from left towards right
        // so that the subtraction of the lower numbers on the left can be done properly

        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int n = s.length();
        int ans = 0;
        char prev = ' ';
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = dict.get(c);

            if (i < n - 1 && c == 'I' && (prev == 'V' || prev == 'X')) {
                ans -= val;
            } else if (i < n - 1 && c == 'X' && (prev == 'L' || prev == 'C')) {
                ans -= val;

            } else if (i < n - 1 && c == 'C' && (prev == 'D' || prev == 'M')) {
                ans -= val;

            }

            else {
                ans += val;
            }
          
            prev = c;

        }

        return ans;

    }

}
