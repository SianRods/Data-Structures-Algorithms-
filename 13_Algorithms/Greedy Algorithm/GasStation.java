public class GasStation {
    public static void main(String[] args) {

    }

    public int brutecanCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            int count = 0;
            int i = start;
            while (count < n) {
                tank += gas[i] - cost[i];
                if (tank < 0) {
                    break;
                }
                i = (i + 1) % n;
                count++;
            }
            if (count == n && tank >= 0) {
                return start;
            }
        }
        return -1;
    }

    public static int canCompleteCircuit(int gas[], int cost[]) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }

        if (sum < 0) {
            return -1;
        }

        // Meaning the answer sure shot exists
        int totalCost = 0;
        int prevResult = 0;
        int i;
        for (i = 0; i < n; i++) {
            totalCost += gas[i] - cost[i];
            if (totalCost < 0) {
                totalCost = 0;
                prevResult = i + 1;
            }

        }
        return prevResult;
    }

}