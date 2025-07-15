import java.util.*;

public class RescheduleMeetingsForMaximumFreetTime {
    public static void main(String[] args) {
        int eventTime = 10;
        int k = 1;
        int startTime[] = { 0, 2, 9 };
        int endTime[] = { 1, 4, 10 };

        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }

    public static List<List<Integer>> maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<List<Integer>> freeSlots = new ArrayList<>();
        int s = 0;

        // Adding free slots
        for (int i = 1; i <eventTime; i++) {
            if (endTime[i - 1] == startTime[i])
                continue; // Given Slot is already occupied
            if (startTime[i - 1] == 0) {
                s = endTime[i - 1];
                continue;
            } else {
                freeSlots.add(new ArrayList<>(Arrays.asList(s, startTime[i - 1])));
                s = endTime[i - 1];
            }

        }

        return freeSlots;

    }

}
