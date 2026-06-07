import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInArray {
    public static void main(String[] args) {
        int arr[]={10, 22, 12, 3, 0, 6};
        System.out.println(Arrays.toString(arr));
        System.out.println(getLeaders(arr));
    }

    public static ArrayList<Integer> getLeaders(int arr[]) {
        int nextgreater = Integer.MIN_VALUE;
        ArrayList<Integer> li = new ArrayList<>();
        int n = arr.length;

        for (int i = n-1; i >=0 ; i--) {
            if (arr[i] > nextgreater) {
                li.add(arr[i]);
            }

            nextgreater = Math.max(nextgreater, arr[i]);
        }

        return li;

    }

}
