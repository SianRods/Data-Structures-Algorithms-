// package Codechef.Starters_200;

import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(y==x){
            System.out.println(x);
        }else if (y>x && y%x==0){
            System.out.println(n/(y/x));
        }
    }
}
