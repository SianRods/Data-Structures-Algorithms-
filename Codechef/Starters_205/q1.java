import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read the number of test cases

        while (t-- > 0) {
            solve(sc); // Process each test case
        }
        sc.close();
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt(); // Read the number of people

        boolean foundOneAtEven = false;
        boolean foundOneAtOdd = false;

        for (int i = 0; i < n; i++) {
            int strength = sc.nextInt();

            if (strength == 1) {
                // Check the parity of the 0-based indexkf
                if (i % 2 == 0) { // Even index
                    foundOneAtEven = true;
                } else { // Odd index
                    foundOneAtOdd = true;
                }
            }
        }

        if (foundOneAtEven && foundOneAtOdd) {
            System.out.println("No"); // No unreachable pairs exist.
        } else {

            System.out.println("Yes");
        }
    }
}