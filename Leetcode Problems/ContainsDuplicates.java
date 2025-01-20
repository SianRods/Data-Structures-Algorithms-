import java.util.Arrays;

public class ContainsDuplicates {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 1 };
        System.out.println(checkDuplicate(arr));
    }

    static boolean checkDuplicate(int arr[]) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return true;
            }
        }
        return false;
    }
}
