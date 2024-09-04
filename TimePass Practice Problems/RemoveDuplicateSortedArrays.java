// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
// Return k

public class RemoveDuplicateSortedArrays {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 2, 3, 3, 4, 4, 5 };
		System.out.println(returnCorrectArray(arr));

	}

	public static int returnCorrectArray(int arr[]) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (i == j) {
					continue;
				} else {
					if (arr[i] == arr[j]) {
						// Shifting the Array --> Removing the duplicate one
						for (int k = j; k < (arr.length - 1); k++) {
							arr[k] = arr[k + 1];
						}

					}

				}
			}

		}
		return arr.length;

	}

}
