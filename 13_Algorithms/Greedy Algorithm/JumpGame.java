public class JumpGame {
    public static void main(String[] args) {

    }

    public boolean canJump(int nums[]) {
        // Mainitaing a max index variable which will help us to determine the farthest
        // we can go from
        // a given index position
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }
}

// My Initial Wrong Apporach which made the solution unecessarily worst case
// scenario O(n**2)
// If the Array has no zeros in it then we will always be able to reach the end
// of the array
// problem is with zeros
// Whenever you reach an index with the value zero check if the previous indexes
// values are such that
// they can cross the index with value zero
// if (nums.length <= 1) {
// return true;
// }
// int j = 0;
// for (int i = 0; i < nums.length; i++) {
// if (nums[i] != 0) {
// continue;

// } else {
// j = i - 1;
// while (j >= 0) {
// if (nums[j] > (i - j)) {
// break;
// } else {
// j--;
// }
// }
// if (j == -1) {
// return false;
// }
// }
// }

// return true;