package leetcode.binarysearch;

public class BSProblems {

	// https://leetcode.com/problems/binary-search/description/
	public static int searchBS(int[] arr, int ele) {
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
			else high = mid - 1;
		}
		return high + 1;
	}

	// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
	public int firstOccurrence(int[] nums, int target) {
		int low = 0, high = nums.length - 1, index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				index = mid;
				high = mid - 1;
			} else if (nums[mid] > target) high = mid - 1;
			else low = mid + 1;
		}
		return index;
	}

	public int lastOccurrence(int[] nums, int target) {
		int low = 0, high = nums.length - 1, index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				index = mid;
				low = mid + 1;
			} else if (nums[mid] > target) high = mid - 1;
			else low = mid + 1;
		}
		return index;
	}

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = firstOccurrence(nums, target);
		result[1] = lastOccurrence(nums, target);
		return result;
	}

	// https://leetcode.com/problems/search-in-rotated-sorted-array/
	public int findInversion(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid == nums.length - 1) return -1;
			else if (nums[mid] > nums[mid + 1]) return mid;
			else if (nums[mid] > nums[nums.length - 1])    lo = mid + 1;
			else hi = mid - 1;
		}
		return -1;
	}

	public int searchEle(int[] nums, int target, int l, int r) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)    return mid;
			else if (nums[mid] > target)    r = mid - 1;
			else    l = mid + 1;
		}
		return -1;
	}

	public int search(int[] nums, int target) {
		// divide search space in two parts : sorted and not sorted (check for sorted half and then check element into it)
		// TC : O(log n)
		// SC : O(1)
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)    return mid;
				// if left half is sorted
			else if (nums[lo] <= nums[mid]) {
				if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
				else lo = mid + 1;
			} else {
				if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
				else hi = mid - 1;
			}
		}
		return -1;

		// find inverted index and then search in respective half
		// TC : O(2*log n)
		// SC : O(1)
		// int invertIndex = findInversion(nums);
		// if (invertIndex == -1)  return searchEle(nums, target, 0, nums.length - 1);
		// else {
		//     if (target <= nums[invertIndex] && target >= nums[0])   return searchEle(nums, target, 0, invertIndex);
		//     else return searchEle(nums, target, invertIndex + 1, nums.length - 1);
		// }
	}

	//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
	public boolean searchSortedRotated2(int[] nums, int target) {
		// TC : for most cases : O(log n)
		// WORST CASE : O(N)
		// SC : O(1)
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)    return true;
			else if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
				lo++;
				hi--;
			} else if (nums[lo] <= nums[mid] ) {
				// left is sorted
				if (nums[lo] <= target && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				// right is sorted
				if (nums[mid] < target && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return false;
	}

	// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	public int findInvertedEndIndex(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid == (nums.length - 1))  return -1;
			if (nums[mid] > nums[mid + 1])  return mid;
			else if (nums[mid] < nums[nums.length - 1]) hi = mid - 1;
			else lo = mid + 1;
		}
		return -1;
	}

	public int findMin(int[] nums) {
		// find inverted position indes
		// either arr[0] or arr[invIndex + 1]
		// TC : O(log n)
		// SC : O(1)
		if (nums == null || nums.length == 0)   return 0;

		int invertedIndex = findInvertedEndIndex(nums);
		if (invertedIndex == -1)    return nums[0];

		return nums[invertedIndex + 1];
	}


}
