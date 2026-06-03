public class MissingNumber {
    public static void main(String[] args) {

    }

    public static int missingLink(int arr[]) {
        int n = arr.length + 1;
        int totalSum = (n * (n + 1)) / 2;
        int arraySum = 0;
        for (int i : arr) {
            arraySum += i;
        }

        return totalSum - arraySum;

    }
}
