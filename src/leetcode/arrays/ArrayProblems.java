package leetcode.arrays;

public class ArrayProblems {

	// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	public int removeDuplicates(int[] nums) {

		// O(n) TC
		// O(1) SC
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) continue;
			nums[index++] = nums[i];
		}
		return index;

		// O(n) TC
		// O(n) SC
		// int n = nums.length;
		// int[] newArr = new int[n];
		// newArr[0] = nums[0];

		// int p = 1;
		// for (int i = 1; i < n; i++) {
		//     if (nums[i] == nums[i - 1]) continue;
		//     newArr[p++] = nums[i];
		// }

		// for (int i = 0; i < p; i++) {
		//     nums[i] = newArr[i];
		// }
		// return p;
	}
}
