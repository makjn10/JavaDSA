package geeksforgeeks.arrays;

class ArrayProblems {

	// https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube
	// largest element in an array
	public static int largest(int[] arr) {
		// code here
		// Time Complexity -> O(n)
		// Space complexity -> O(1)
		int largestNum = 0;
		for (int num : arr) {
			if (num > largestNum) {
				largestNum = num;
			}
		}
		return largestNum;
	}

	// https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest
	// second largest element in an array
	public int getSecondLargest(int[] arr) {
		// Code Here
		// Time Complexity -> O(n)
		// Space complexity -> O(1)
		int largestNum = -1, secondLargestNum = -1;
		for (int num : arr) {
			if (num > largestNum) {
				secondLargestNum = largestNum;
				largestNum = num;
			} else if (num > secondLargestNum && num < largestNum) {
				secondLargestNum = num;
			}
		}
		return secondLargestNum;
	}

	// Linear Search
	boolean searchInSorted(int arr[], int k) {
		// Your code here
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k)    return true;
		}
		return false;
	}
}