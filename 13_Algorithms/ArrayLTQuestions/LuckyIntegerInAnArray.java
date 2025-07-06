import java.util.Hashtable;

public class LuckyIntegerInAnArray {
    public static void main(String[] args) {

    }

    public static int findLucky(int[] arr) {
        Hashtable<Integer, Integer> hm = new Hashtable<>();

        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i]) != null) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        int resMax = 0;
        int j = 0;
        while (j < arr.length) {
            if (hm.get(arr[j]) == arr[j]) {
                if (resMax > arr[j]) {
                    resMax = arr[j];
                }
            }
        }

        return resMax;

    }

}