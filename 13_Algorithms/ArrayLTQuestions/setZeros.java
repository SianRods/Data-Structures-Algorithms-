// package ArrayLTQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class setZeros {
    public static void main(String[] args) {

        // int arr[][] = {
        // { 1, 1, 1 },
        // { 1, 0, 1 },
        // { 1, 1, 1 }

        // };

        int arr[][] = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }

        };

        display(arr);
        changeToZeros(arr, addZeroIndices(arr));
        display(arr);
    }

    // new ArrayList<>(Arrays.asList(i,j)) --> Method to Initialize an ArrayList
    // Directly with values

    static ArrayList<ArrayList<Integer>> addZeroIndices(int arr[][]) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    sol.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        System.out.println(sol);
        return sol;
    }

    static void changeToZeros(int arr[][], ArrayList<ArrayList<Integer>> sol) {
        while (!sol.isEmpty()) {
            int i = sol.getFirst().get(0);
            int j = sol.getFirst().get(1);

            // Make rows value Zero
            for (int k = 0; k < arr[i].length; k++) {
                arr[i][k] = 0;
            }

            // Make rows value to Zero
            for (int k = 0; k < arr.length; k++) {
                arr[k][j] = 0;
            }

            sol.remove(sol.indexOf(sol.getFirst()));
        }
    }

    static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

}
