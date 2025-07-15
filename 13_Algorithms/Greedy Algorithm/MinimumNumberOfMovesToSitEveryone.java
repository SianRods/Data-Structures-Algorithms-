import java.rmi.StubNotFoundException;
import java.util.Arrays;

public class MinimumNumberOfMovesToSitEveryone {
    public static void main(String[] args) {

    }

    // Return the minimum number of moves required
    // to move each student to a seat such that no two students are in the same
    // seat.

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int n = seats.length;
        int i = 0;

        int count = 0;
        while (i < n) {
            count += Math.abs(seats[i] - students[i]);
            i++;
        }

        return count;

    }
}
