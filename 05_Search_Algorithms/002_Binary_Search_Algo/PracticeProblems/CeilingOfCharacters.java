// 744. Find Smallest Letter Greater Than Target
// You are given anlettersay of characters letters that is sorted in non-decreasing order,
//  and a character target. There are at least two different characters in letters.
// Return the smallest character in letters that is lexicographically greater than target.
//  If such a character does not exist, return the first character in letters

//  Example 1:

// Input: letters = ["c","f","j"], target = "a"
// Output: "c"
// Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
// Example 2:

// Input: letters = ["c","f","j"], target = "c"
// Output: "f"
// Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
// Example 3:

// Input: letters = ["x","x","y","y"], target = "z"
// Output: "x"
// Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].

public class CeilingOfCharacters {
    public static void main(String args[]) {
        char[] sample = { 'e','e','e','e','e','e','n','n','n'};
        System.out.println("The Ceiling of the Given Number is : " + ceilingCharacter(sample, 'n'));
    }

    static char ceilingCharacter(char letters[], char target) {
        // Implementing the Binary Search Algorithm and Modigying it
        int start = 0;
        int end = letters.length - 1;
        int middle = (start + end) / 2;

        // Checking the validity of the given question (Assuming Ascending Number )
        if ((int)target >= (int)(letters[letters.length - 1])) {
            return letters[0];
        }

        // lettersay is in Ascending order Assumed
        // Rertuning the target if it is present in thelettersay
        do { 

            if ((int) letters[middle] == (int) target) {
            
            // Important Apporach to be used here 


             start=middle+1;
             middle=(start+end)/2;


            } else if ((int) letters[middle] < (int) target) {
                start = middle + 1;
                middle = (start + end) / 2;

            } else if ((int) letters[middle] > (int) target) {
                end = middle - 1;
                middle = (start + end) / 2;
            }

        } while (!(start > end));

        return letters[start];
    }
}


// -------------------------------------------------------------------------------
// here the seperate logic being that we only have to find out the smallest one greater than and skip the part where we have 
// the equality 
// So what to do when we encounter the element in binary search ???
// --> We can consider the forward pending array only the moment we enounter the element we know two things for sure 
// 1. All the Letters are arranged in alphabetical order 
// 2. to find only the greater one it must lie in the subsequent part of array after the element 
// 3. So we can shift the start pointer to the next location start=middle+1 ;
// 4 Updating the middle position middle = (start+end)/2;