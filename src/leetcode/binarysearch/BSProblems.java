package leetcode.binarysearch;

public class BSProblems {

	// https://leetcode.com/problems/binary-search/description/
	public static int search(int[] arr, int ele) {
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

	// https://leetcode.com/problems/search-insert-position/
	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) return mid;
			else if (nums[mid] < target) low = mid + 1;
			else    high = mid - 1;
		}
		return high + 1;
	}

	// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
	public int firstOccurrence(int[] nums, int target) {
		int low = 0, high = nums.length - 1, index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(nums[mid] == target) {
				index = mid;
				high = mid - 1;
			} else if (nums[mid] > target)  high = mid - 1;
			else    low = mid + 1;
		}
		return index;
	}
	public int lastOccurrence(int[] nums, int target) {
		int low = 0, high = nums.length - 1, index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(nums[mid] == target) {
				index = mid;
				low = mid + 1;
			} else if (nums[mid] > target)  high = mid - 1;
			else    low = mid + 1;
		}
		return index;
	}
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = firstOccurrence(nums, target);
		result[1] = lastOccurrence(nums, target);
		return result;
	}
}
