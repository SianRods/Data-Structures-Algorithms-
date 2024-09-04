import java.util.Scanner;

// Implementing for the Array Data Structure 
public class LinearSearch {
	public static void main(String args[]) {
		int arr[] = { 8,12, 32, 324,8,8,8, 543, 64, 65, 856, 34 ,8};
		System.out.println(SearchIndex(arr, 34));

		System.out.println(TargetElementCount(arr, 8));


	}

	// e are creating static function so that it can be accessed by other static memebers 
	// like main without creating an instance of the class 


	// PART--> 1

	// Searching and returning the index
	// Best Case for Time Complexity if --> O(1)--> Constant --> Found at first
	// index
	// Worst Case for Time --> O(N)--> Element Not Found in the Array

	static int SearchIndex(int arr[], int ele) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ele) {
				return i;
			} else {
				if (i == (arr.length) && arr[i] != ele) {
					return -1;
				}
			}
		}

		return -1;

	}

	// PART--> 2
	// Seraching and returning the Element itself
	static int TargetElementCount(int arr[], int ele) {
		int count = 0; // Initializing the count variable to Zero at Start
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ele) {
				count++;
				if(i==(arr.length-1)){
					return count ;
				}
			}
		}
		// Else Returning ZERO 
		return 0;
	}


	// Part 3--> Checking the Existence of a Given Element 
	// Retrun Type --> boolean 

	static boolean ExistElement(int arr[],int ele){
		// Any One of the Following Value is going to get returned

		for(int i=0;i<arr.length;i++){
			if(arr[i]==ele){
				return true;
			}
		}
		return false;
	}




}