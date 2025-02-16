package geeksforgeeks.binarysearch;

public class BSProblems {
	// https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array
	static int findFloor(int[] arr, int k) {
		// Using Binary Search, since sorted
		// O(log n)
		int low = 0, high = arr.length - 1, index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] <= k) {
				index = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return index;

		// write code here
		// brute force
		// O(n)
		// for (int i = arr.length - 1; i >= 0; i--) {
		//     if (arr[i] <= k)    return i;
		// }
		// return -1;
	}
}
