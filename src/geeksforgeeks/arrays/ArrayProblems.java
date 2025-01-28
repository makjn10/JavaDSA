package geeksforgeeks.arrays;

import java.util.ArrayList;

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
			if (arr[i] == k) return true;
		}
		return false;
	}


	// https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays
	// O(n + m) TC
	// O(n + m) SC

	public static void addToArray(ArrayList<Integer> result, int num) {
		if (result.size() == 0 || (result.get(result.size() - 1) != num)) {
			result.add(num);
		}
	}

	public static ArrayList<Integer> findUnion(int a[], int b[]) {
		// add your code here
		ArrayList<Integer> result = new ArrayList<>();

		int n = a.length, m = b.length, i = 0, j = 0;
		while (i < n && j < m) {
			if (a[i] < b[j]) {
				addToArray(result, a[i]);
				i++;
			} else {
				addToArray(result, b[j]);
				j++;
			}
		}
		while (i < n) {
			addToArray(result, a[i]);
			i++;
		}
		while (j < m) {
			addToArray(result, b[j]);
			j++;
		}

		return result;
	}
}