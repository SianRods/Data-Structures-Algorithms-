import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int o = sc.nextInt();
            int w = sc.nextInt();
            int j = 1;
            int res = 0;
            for (int i = 1; i <= o; i++) {
                while (j < w && j!= 2*i) {
                    j++;
                }

                if ((double)j / (double)i == 2.0) {
                    // System.out.println("Orange"+i);
                    // System.out.println("Water"+j);
                    res = Math.max(res, j + i);
                }
              

            }
            System.out.println(res);

        }

	}
}
