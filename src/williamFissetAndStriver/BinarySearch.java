package williamFissetAndStriver;

// Linear search is traversing from first element to last element and searching
// Binary Search is applicable when data is monotonically sorted
// Everything between low and high is search space

// lower bound : smallest index of ele which is greater or equal to x in a sorted array
// upper bound : smallest index of ele greater than x in a sorted array

// Patterns :
//	- Normal BS (==, >, <)
//	- Only two possibilities (>= and <) or (<= and >) like finding upper bound etc.
//  - Many problems can be solved using lower bound and upper bound. But take care of extreme cases like elem not present in array etc.


public class BinarySearch {

	// TC : O(log n) base 2
	public static int binarySearchIter(int[] arr, int ele) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			// int mid = (low + high) / 2; // (low + high could overflow if big numbers)
			int mid = low + (high - low) / 2;
			if (arr[mid] == ele) return mid;
			else if (arr[mid] < ele) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
	}

	// TC : O(log n) base 2
	public static int binarySearchRec(int[] arr, int ele, int low, int high) {
		if (high < low) return -1;
		int mid = low + (high - low) / 2;
		if (arr[mid] == ele) return mid;
		else if (arr[mid] > ele) return binarySearchRec(arr, ele, low, mid - 1);
		else return binarySearchRec(arr, ele, mid + 1, high);
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 12, 14, 45, 56, 66, 79, 80, 90};
		System.out.println(binarySearchIter(arr, 1));
		System.out.println(binarySearchIter(arr, 90));
		System.out.println(binarySearchIter(arr, 14));
		System.out.println(binarySearchIter(arr, 3));
		System.out.println(binarySearchIter(arr, 56));
		System.out.println(binarySearchIter(arr, 506));

		System.out.println(binarySearchRec(arr, 1, 0, arr.length - 1));
		System.out.println(binarySearchRec(arr, 90, 0, arr.length - 1));
		System.out.println(binarySearchRec(arr, 14, 0, arr.length - 1));
		System.out.println(binarySearchRec(arr, 3, 0, arr.length - 1));
		System.out.println(binarySearchRec(arr, 56, 0, arr.length - 1));
		System.out.println(binarySearchRec(arr, 506, 0, arr.length - 1));
	}
}
