package 13_ Algorithms.Greedy Algorithm;
// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/

import java.util.Arrays;

public class MaximumMatchingOfPlayerWithTrainers {
    public static void main(String[] args) {

    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
                Arrays.sort(trainers);
        Arrays.sort(players);

        int i, j = 0;
        // i >> pointer for the greed array
        // j >> pointer for cookies in a packet array

        while (i < trainers.length && j < players.length) {
            if (players[j] <= trainers[i]) {
                i++;
                j++;
            } else {
                j++;
            }

        }

        return i;
    }
}
