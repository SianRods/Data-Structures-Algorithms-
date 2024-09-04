public class _01TwoSum {
	public static int[] returnSolution(int arr[], int target) {
		int sol[] = new int[2] ;
		int blank[] = new int[0];
		
		
	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

				// For all the other elements
				if (i != j) {
					if (arr[i] + arr[j] == target) {
						sol[0] = i;
						sol[1] = j;

						return sol;
					}
				}
				// Skipping the same index
				if (i == j) {
					continue;
				}
			}
		}
		// Else Returning Null Array of Integer
		return blank;

	}

	public static void main(String args[]) {
		int arr[] = { 56, 15, 2, 7 };
		int tar = 9;
		System.out.println("The Length of the given array is : "+arr.length);
		int ans[] = returnSolution(arr, tar);

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}
}
