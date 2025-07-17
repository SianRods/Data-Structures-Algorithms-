// Things we know 
// 1] We have the number of boats rewuired to carry every person
// 2] We have to use minimum number of boats 
// 3] Each boat can carry maximum of 2 people 

// First Intuition 
// a] Sorting the array as we have to minimize the number of boats required to carry the people
// b] 

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {

    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int i = 0;
        int count = 0;

        while (i < n - 2) {
            int j = n - 1;
            while (j > i && people[i] + people[j] > limit)
                j--;
            count++;
            while (i <= j && i < n-1) {
                count++;
                i++;
            }

        }

        return count;
    }

}
