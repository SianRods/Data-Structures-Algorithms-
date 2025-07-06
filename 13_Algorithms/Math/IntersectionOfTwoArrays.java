import java.util.Hashtable;
import java.util.ArrayList;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Hashtable<Integer, Integer> hm = new Hashtable<>();

        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i], 0);
        }

        // int sol[] = new int[Math.abs(nums1.length - nums2.length)];

        for (int j = 0; j < nums2.length; j++) {
            if (hm.get(nums2[j]) != null) {
                sol[j] = nums2[j];
            }
        }
        ArrayList<Integer> sol  =  new ArrayList<>();
        hm.re
        return sol;
    }
}
