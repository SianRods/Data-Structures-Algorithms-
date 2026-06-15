import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {

        // int arr[] = { 3, 2, 3 };
        int arr[] = { 1, 2 };
        System.out.println(MajorityElement2(arr));
    }

    /**
     * Here we are implementing the Moore's Voting Algorithm which is completely based on voting 
     * for possible candidate solutions present in the given input array
     * 
     * @param arr
     * @return
     */
    public static int MajorityElement1(int arr[]) {
        int candidate1 = -1;
        int count1 = 0;
        int n = arr.length;

        // Select the majority candidate
        for (int i = 0; i < n; i++) {
            if (candidate1 == arr[i]) {
                count1++;
            } else if (count1 == 0) {
                candidate1 = arr[i];
                count1 = 1;
            } else {
                count1--;
            }

        }

        count1 = 0;
        // check it's frequency again
        for (int i = 0; i < n; i++) {
            if (candidate1 == arr[i]) {
                count1++;
            }

        }

        if (count1 > arr.length / 2) {
            return candidate1;
        }
        return -1;

    }

    public static List<Integer> MajorityElement2(int arr[]) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        int cutoff = arr.length / 3;

        // figuring out the majority of the candidates

        // Note that the order of checking count / candidate frequency increase is
        // important first
        // If you check count == 0 first, you might accidentally overwrite a valid
        // candidate instead of strengthening it.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate1) {
                count1++;
            } else if (arr[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = arr[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = arr[i];
                count2 = 1;
            } else {
                // modified verion focuses exactly on this part where is the current element 
                // matches none of the two candidates decrease both the candidates
                count1--;
                count2--;
            }
        }

        // Compulsory in case of Advaned Moore's Alogrithm 
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate1) {
                count1++;
            } else if (arr[i] == candidate2) {
                count2++;
            }
        }

        List<Integer> sol = new ArrayList<>();
        if (count1 > cutoff) {
            sol.add(candidate1);
        }

        if (count2 > cutoff) {
            sol.add(candidate2);
        }

        return sol;

    }

}
