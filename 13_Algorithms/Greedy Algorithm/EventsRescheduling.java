
import java.util.*;

public class EventsRescheduling {
    public static void main(String[] args) {
        int eventTime = 10;
        int k = 1;
        int startTime[] = { 0, 2, 9 };
        int endTime[] = { 1, 4, 10 };
        maxFreeTime(eventTime, k, startTime, endTime);
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // Designing a Optimum Solution
        List<Integer> gaps = new ArrayList<>();
        gaps.add(startTime[0]);
        for (int i = 1; i < startTime.length; i++) {
            gaps.add(startTime[i] - endTime[i - 1]);
        }

        gaps.add(eventTime - endTime[startTime.length - 1]);

        int currSum = 0;
        int maxDuration = 0;

        for (int i = 0; i < gaps.size(); i++) {
            currSum += gaps.get(i);

            if (i >= k + 1)
                currSum -= gaps.get(i - (k + 1));
            maxDuration = Math.max(maxDuration, currSum);
        }

        return maxDuration;

    }

}
