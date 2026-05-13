package Codechef.Starters_238;

import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read the number of test cases

        while (t-- > 0) {

            int x =sc.nextInt();
            // x --> total runs scored by the chef 
            if(x<20){
                System.out.println(x*10);
            }else{
                System.out.println(200+(((x-20)/2)*5));
            }
        }
    }

}
