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


	public void reverseArr(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}

	// https://leetcode.com/problems/rotate-array/
	public void rotate(int[] nums, int k) {

		// O(n) TC
		// O(1) SC
		int n = nums.length;
		k = k % n;
		reverseArr(nums, 0, n - k - 1);
		reverseArr(nums, n - k, n - 1);
		reverseArr(nums, 0, n - 1);

		// // O(n) TC
		// // O(n) SC

		// int n = nums.length, p = 0;
		// k = k % n;
		// if (k == 0) return;

		// int[] newArr = new int[k];
		// for (int i = n - k; i < n; i++) {
		//     newArr[p++] = nums[i];
		// }
		// for (int i = n - k - 1, j = n - 1; i >= 0; j--, i--) {
		//     nums[j] = nums[i];
		// }
		// for (int i = 0, j = 0; i < k; i++, j++) {
		//     nums[j] = newArr[i];
		// }

		// O(n) TC
		// O(n) SC
		// int n = nums.length, p = 0;
		// k = k % n;
		// int[] newArr = new int[n];

		// for (int index = n - k; index < n; index++) {
		//     newArr[p++] = nums[index];
		// }
		// for (int i = 0; i < n - k; i++) {
		//     newArr[p++] = nums[i];
		// }
		// for (int i = 0; i < n; i++) {
		//     nums[i] = newArr[i];
		// }
	}

	// https://leetcode.com/problems/move-zeroes/
	public void moveZeroes(int[] nums) {

		// O(n) TC
		// O(1) SC
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)    continue;
			nums[index++] = nums[i];
		}
		for (; index < nums.length; index++) {
			nums[index] = 0;
		}
	}

	// https://leetcode.com/problems/missing-number/
	public int missingNumber(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
			xor = xor ^ i;
		}
		return xor ^ nums.length;
	}

	// https://leetcode.com/problems/max-consecutive-ones/
	public int findMaxConsecutiveOnes(int[] nums) {
		int currentConsOnes = 0, maxConsOnes = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				currentConsOnes++;
				continue;
			} else {
				maxConsOnes = Math.max(currentConsOnes, maxConsOnes);
				currentConsOnes = 0;
			}
		}
		maxConsOnes = Math.max(currentConsOnes, maxConsOnes);
		return maxConsOnes;
	}

	// https://leetcode.com/problems/single-number/
	public int singleNumber(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
		}
		return xor;
	}
}
