import java.util.HashMap;
import java.util.Map;
import java.util.stream.Gatherer.Integrator;

public class FruitsIntoBasket {
    public static void main(String[] args) {

    }

    public static int slidingWindowApporachtotalFruit(int[] fruits) {
        // Here we will using map data structure to store the fequency of characters
        // enoutered
        // in the the valid sliding window

        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int maxLength = 0;

        while (j < n) {
            if (hm.get(fruits[j]) != null) {
                hm.put(fruits[j], hm.get(fruits[j]) + 1);
            } else {
                hm.put(fruits[j], 1);
            }

            // Check if the number of fruits in the Hashmap are valid so as to increase the
            // lenghth variable

            // First we have to write down the condition of if it is not possible to
            // consider fruits[j] then first we
            // will make sure that it becomes possible and then we would update the max
            // length
            // as if at first we check for valid then if it's invalid after making it valid
            // we won't be able to
            // update the max length functiona and it would lead to improper updation of len
            // variable

            if (hm.size() > 2) {
                while (hm.size() > 2) {
                    hm.put(fruits[i], hm.get(fruits[i]) - 1);
                    if (hm.get(fruits[i]) == 0) {
                        hm.remove(fruits[i]);
                    }
                    i++;
                }

            }
            if (hm.size() <= 2) {
                maxLength = Math.max(maxLength, j - i + 1);

            }
            j++;

        }

        return maxLength;

    }

    public static int myinitialApporachtotalFruit(int[] fruits) {
        // can be more optimized using set data structure
        int b1 = -1;
        int b2 = -1;
        int max = 0;
        int i = 0;
        int j = 0;
        int n = fruits.length;

        while (j < n) {
            // If the baskets are initially empty add the fruits which are encountered
            if (b1 < 0 || b2 < 0) {
                if (b1 < 0)
                    b1 = fruits[j];
                else
                    b2 = fruits[j];
            }

            if (b1 != fruits[j] && b2 != fruits[j]) {
                j--;
                i = j;
                if (b1 == fruits[j])
                    b2 = fruits[j + 1];
                else
                    b1 = fruits[j + 1];
            }

            else
                j++;
            max = Math.max(max, j - i);

        }
        return max;
    }
}
