
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    public static void main(String[] args) {

    }

    /**
     * 
     * In the below question we are simulating cpu processing time-time
     * Time complexity of the solution is O(total_time_execution)
     * where the total_time_excution > N mostly
     * 
     * 
     * @param tasks
     * @param n
     * @return
     */
    public static int getMinimumCPUTime(char[] tasks, int n) {
        // In this particular Question we need to focus on simulating how the
        // tasks are scheduled tick-by-tick inside a CPU scheduler

        // The approach and thought process is simple but mainitaing one priority-qeue
        // and one normal queue(coolDownQueue) which will consists of the tasks
        // which cannot be added to the execution time due to coolDown period 'n'

        // minimization --> the cpu time is minimized by selecting to complete the tasks
        // which have overall high frequency so that such tasks are not left pending at
        // the end
        // resulting in addition of unecessary 'idle' time adding to the overall cpu
        // time

        int freq[] = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // creating a max-heap using pq -->descending comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // adding all the task's frequency in the priority queue (minimization_criteria)
        for (int count : freq) {
            if (count > 0) {
                // We only care about the count, the character label is irrelevant!
                pq.add(count);
            }
        }

        int time = 0;

        // creating a cooldown queue --> containing {freq_remaining,time_till_available}
        Queue<int[]> cooldQueue = new LinkedList<>();

        while (!pq.isEmpty() || !cooldQueue.isEmpty()) {
            time++;

            // check if the working pq is empty or not if not perform the operations
            if (!pq.isEmpty()) {
                // performing that task
                int currFreq = pq.poll();
                currFreq--;

                // check if the currFreq >0 then add it to the coolDown else do nothing as that
                // task
                // can be deemed as completed
                if (currFreq > 0) {
                    cooldQueue.add(new int[] { currFreq, time + n });

                }

            }

            // also check the and add to the processing queue if any of the task have
            // completed their coolDown period
            if (!cooldQueue.isEmpty() && cooldQueue.peek()[1] == time) {
                pq.add(cooldQueue.poll()[0]);

            }

        }
        return time;

    }

    /**
     * 
     * In this particular approach we are using the maxFreq task and trying to fill it's inbetween 
     * task by the remaining task's frequency 
     * 
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;

        // Step 1: Count frequencies and find the highest frequency
        for (char task : tasks) {
            int currentFreq = ++freq[task - 'A'];

            if (currentFreq == maxFreq) {
                maxFreqCount++; // Another task tied for the highest frequency
            } else if (currentFreq > maxFreq) {
                maxFreq = currentFreq; // New highest frequency found
                maxFreqCount = 1; // Reset the tie counter
            }
        }

        // here the variable maxFreqCount --> denotes all the tasks with tied Maximum Frequency 

        // Step 2: Calculate the "framework" size
        // (maxFreq - 1) creates the "gaps" or blocks between the most frequent task.
        // (n + 1) is the size of each block (1 for the task itself + n for the
        // cooldown).
        int emptySlotsPart = (maxFreq - 1) * (n + 1);

        // Add the tasks that have the maximum frequency to the end of the sequence
        int totalCalculatedTime = emptySlotsPart + maxFreqCount;

        // Step 3: Return the maximum of calculated time or actual array length
        // If we have so many different tasks that we never actually need to be idle,
        // the time taken is simply the number of tasks we have.
        return Math.max(totalCalculatedTime, tasks.length);
    }

}
