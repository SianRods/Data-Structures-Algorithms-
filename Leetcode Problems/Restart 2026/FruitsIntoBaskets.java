import java.util.HashMap;
import java.util.HashSet;

public class FruitsIntoBaskets {

    public static void main(String[] args) {

        HashSet<Integer> st = new HashSet<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        // int fruits[] = { 1, 2, 1, 1, 1, 3, 2, 2 };
        int fruits[] = { 1, 2, 3, 2, 2 };
        // int fruits[] = { 1, 1 ,2, 3, 2, 2 };

        // removal of element from the start of the array which reached freq=0 first
        int n = fruits.length;
        int i = 0;
        int j = 0;
        int maxi = 0;

        while (i < n && j < n) {
            st.add(fruits[j]);
            hm.put(fruits[j], hm.getOrDefault(fruits[j], 0) + 1);

            // check for condition violations
            while (st.size() > 2 && i < n) {
                hm.put(fruits[i], hm.getOrDefault(fruits[i], 0) - 1);
                if (hm.get(fruits[i]) == 0) {
                    hm.remove(fruits[i]);
                    st.remove(fruits[i]);
                }
                i++;
            }
            maxi = Math.max(maxi, j - i + 1);

            j++;

        }

    }
}