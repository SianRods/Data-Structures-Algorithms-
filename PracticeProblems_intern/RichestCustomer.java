package PracticeProblems_intern;

public class RichestCustomer {
    public static void main(String[] args) {
        // Return the MaxWealth a customer has
        int accounts[][] = {
                { 1, 2, 3 }, { 3, 2, 1 }
        };
        System.out.println("The Maximum welath a customer has is : "+maxWealth(accounts));
    }

    static int maxWealth(int acc[][]) {
        int sum = 0;
        int temp;
        for (int i = 0; i < acc.length; i++) {
            // Resetting the Counter of each customer
            temp=0;
            for (int j = 0; j < acc[i].length; j++) {
                temp += acc[i][j];
            }
            if(temp>sum){
                sum=temp;
            }
        }
        return sum;
    }

}
