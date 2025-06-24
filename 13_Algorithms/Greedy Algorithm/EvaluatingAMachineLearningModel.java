import java.util.Arrays;
import java.util.Collections;

public class EvaluatingAMachineLearningModel {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 6, 9 };
        System.out.println(getMaxEfficiencyOfTestingModel(arr));
    }

    // At a time atleast two test cases must be executed
    // How to be greedy here ??
    // int arr [] =[9,1,3,5,6];
    // Sorting comes to mind cause we have minimum active system time then
    // sorted array => [1,3,5,6,9]
    // For the first pair 1,3 upTime=3-1=2 and number of test cases =2
    // efficiency =2;
    // for 3,5 => upTime => 2
    // cases =2
    // efficieny = testCases-upTime=2-2=0;

    // Incase for 1-5 efficiency <0 (3(j-i+1)-4(arr[j]-arr[i])<0)
    public static int getMaxEfficiencyOfTestingModel(int arrivalTime[]) {
        // Classic Greedy Probelm
        Arrays.sort(arrivalTime);
        int i = 0;
        int j = 1; // Atleast Two cases must be executed
        int n = arrivalTime.length;
        int upTime = 0;
        int maxEfficiency = Integer.MIN_VALUE;

        while (j < n) {
            upTime = arrivalTime[j] - arrivalTime[i];
            if ((j - i + 1) - upTime > maxEfficiency) {
                maxEfficiency = (j - i + 1) - upTime;
            }

            else {
                while ((j - i + 1) - upTime  < 0 && j - i >= 1) {
                    upTime = arrivalTime[j] - arrivalTime[i];
                    maxEfficiency = Math.max(maxEfficiency, (j - i + 1) - upTime);
                    i++;
                }
            }

            j++;

        }

        return maxEfficiency;
    }

}
