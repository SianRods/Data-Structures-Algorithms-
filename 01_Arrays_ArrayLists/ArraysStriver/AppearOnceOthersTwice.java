import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AppearOnceOthersTwice {
    public static void main(String[] args) {

    }

    public static int xorGates(int arr[]) {
        int num = 0;

        for (int i : arr) {
            num ^= i;
        }

        return num;

    }

    public static int setApproach(int arr[]) {
        Set<Integer> st = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (st.contains(arr[i])) {
                st.remove(arr[i]);
            } else {
                st.add(arr[i]);
            }

        }

        ArrayList<Integer> ele = new ArrayList<>(st);

        return ele.getFirst();

    }

}
