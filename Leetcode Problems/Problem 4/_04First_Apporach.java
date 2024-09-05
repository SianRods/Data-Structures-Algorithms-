// PROBLEM NO.1672
// You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

// A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

// Example 1:

// Input: accounts = [[1,2,3],[3,2,1]]
// Output: 6
// Explanation:
// 1st customer has wealth = 1 + 2 + 3 = 6
// 2nd customer has wealth = 3 + 2 + 1 = 6
// Both customers are considered the richest with a wealth of 6 each, so return 6.

// FINDING THE CUMSUM ACROSS EACH ROW AND RETURNING THE MAXIMUM 
// ----------------------------------------------------------------------------------------------------------------------------------------------------
// Approach 1 
public class _04First_Apporach {
    public static void main(String args[]){
        int accounts[][] = {{1,2,3},
                            {3,2,1}};
    System.out.println(findLargestWealth(accounts));
    }

    static int findLargestWealth(int accounts[][]){        
        int sum=0;
        int maxWealth=0;
        for(int row=0;row<accounts.length;row++){
            sum=0;
            for(int col=0;col<accounts[row].length;col++){
                sum += accounts[row][col];
            }
            if(sum>maxWealth){
                maxWealth=sum;
            }
        }
        return maxWealth;
    }    
}
