package 13_ Algorithms.Greedy Algorithm;
// https://leetcode.com/problems/lemonade-change/

import java.util.Arrays;

public class LemonadeChange {
    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        // Retrun True if we are able to return the perfect change to all the customers
        // The problem is greedy because here locally optimum change will affect the
        // nature whole problem

        Arrays.sort(bills);
        // Bills can be either 5 , 10 or 20 $
        // Initially we don't have any change to handout
        // Cost of a single lemonade is $5
        // Here we have to maintain the number of bills of each denomination available
        // with us
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;

            } else if (bills[i] == 10) {
                if (count5 >= 1) {
                    count5--;
                    count10++;

                } else {
                    return false;
                }
            } else {
                if (count5 >= 1 && count10 >= 1) {

                    count5--;
                    count10--;
                    count20++;
                } else if (count5 >= 3) {
                    count5 -= 3;
                    count20++;

                } else {
                    return false;
                }
            }
        }

        return true;

    }
}
