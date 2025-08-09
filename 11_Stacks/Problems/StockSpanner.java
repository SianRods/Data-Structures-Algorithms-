
package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    Stack<List<Integer>> st;
    // Mainitaing a class variable to keep a track of the day
    private int day = -1;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(price);
        day++;
        li.add(day);

        while (!st.isEmpty() && li.get(0) > st.peek().get(0)) {
            st.pop();
        }


        // returning the proper day length dependinng upon the current day 
        int length;
        if (st.isEmpty()) {
            length = day + 1; // span is full from day 0 to current
        } else {
            length = day - st.peek().get(1);
        }

        return length;
    }
}