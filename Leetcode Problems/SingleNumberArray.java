
// Problem Number 136 Sinlge Number
//  XOR --> Which is called as Exclusive Or or inequality detector

import java.util.Scanner;

public class SingleNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the" + (i + 1) + "Element: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Non repetive element is : " + singleNumber(arr));
    }

    static int singleNumber(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum^=arr[i];
        }
        return sum;
    }
}
