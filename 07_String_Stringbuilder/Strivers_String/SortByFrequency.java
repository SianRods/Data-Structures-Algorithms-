import java.util.Arrays;

public class SortByFrequency {
    public static void main(String[] args) {
        // String s = "tree";
        // String s = "cccaaa";
        String s="Aabb";
        
        System.out.println(solution1(s));

    }

    public static String solution1(String s) {
        int arr[][] = new int[128][2];
        // initializing the given array
        for (int i = 0; i < 128; i++) {
            arr[i][0] = i;
            arr[i][1] = 0;
        }
        int n = s.length();

        // cosnsits of digits, Upper and Lowercase characters
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c][1]++;
        }

        // sorting the array using th frequency --> descending order
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = arr[i][0];
            int freq = arr[i][1];
            if (freq == 0) {
                break;
            }

            // convert --> int to char
            for (int j = 0; j < freq; j++) {
                sol.append((char) c);
            }

        }

        return sol.toString();

    }

}
