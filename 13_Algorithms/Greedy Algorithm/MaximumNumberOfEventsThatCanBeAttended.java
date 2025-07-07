import java.util.Arrays;
import java.util.TreeSet;

// The Following Sum can be easily implemented by using set and it's internal operations such
//   as finding the ceiling of a number present in the set 
// Greedy Nature of the problem is quite apparent from the implementation of Sorting of the array based on the end date 
// if the end dates are same then using the start date as sorting points 

//The maximum days we have are equal to the the sroted array last element wala event's end date 
// Also the logic behind here is to first sort the array if there is eling of a day in the set with all possible numbers
// then we remove that given day and continue completeing the total possible events which can be completed 

// Till we reach index our of Bounds => This solution is not opimized as I can't use priority queue still 

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        // int arr[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        int arr[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 } };
        maxEvents(arr);
    }

    public static int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;

        TreeSet<Integer> days = new TreeSet<>();

        // Adding all possible days in the input array to the set
        // Here remember that the day starts from 1 and not 0
        // Here we are considering all the possible dates which can be fulfilled
        for (int i = 1; i <= events[events.length - 1][1]; i++) {
            days.add(i);
        }

        for (int[] event : events) {
            int s = event[0]; // Start date of the event
            int e = event[1]; // end date of the event

            Integer availableDay = days.ceiling(s); // greedily trying to extract the day in set
            if (availableDay != null && availableDay <= e) {
                // Here the availableDay <= e ==> Ensures that the event can be attended in the valid bound time 
                count++;
                days.remove(availableDay);
            }
        }

        return count;

    }

}
