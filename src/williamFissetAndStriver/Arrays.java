package williamFissetAndStriver;

// static array
// static array is a fixed length container containing n elements indexable from range [0, n - 1]
// array is allocated memory in a contiguous fashion
// Use of static arrays :
//		- Storing and accessing sequential data
//		- Temporarily storing objects
//		- Used by IO routines and buffers
//		- Lookup tables and reverse lookup tables
//		- return multiple values from a function
//		- used in Dynamic programming to cache answers to sub-problems

// dynamic array
// dynamic array have flexible length, it can grow or shrink as needed
// How to implement dynamic array?
// 	- Using static array
//		- Create a static array with an initial capacity
//		- Add elements to static array, keep track of number of elements
//		- If adding another element exceeds capacity, create new astatic array with twice the capacity and copy original elements to it.


// Time Complexities (static and dynamic (using static array implementation) arrays)
// Access time : O(1), O(1)
// Search : O(n), O(n)
// Insertion : NA, O(n)
// Appending : NA, O(1) -> resizing of static array happens very often
// Deletion : NA : O(1)

import williamFissetAndStriver.implementations.DynamicArray;

public class Arrays {
	public static void main(String[] args) {


		// array indexing is zero-based
		int[] arr = {0, 12, 45, 32, -4, 5};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		// forEach loop
		for (int i : arr) {
			System.out.println(i);
		}


		DynamicArray<Integer> dynamicArray = new DynamicArray<>();
		System.out.println(dynamicArray.isEmpty());
		for (int i = 0; i < 24; i++) {
			dynamicArray.add((int) (Math.random() * 250));
		}
		dynamicArray.printArray();

		System.out.println(dynamicArray.get(2));
		dynamicArray.set(2, 56744);
		dynamicArray.printArray();

		System.out.println(dynamicArray.removeAt(2));
		dynamicArray.printArray();

		dynamicArray.remove(dynamicArray.get(4));
		dynamicArray.printArray();

		dynamicArray.reverse();
		dynamicArray.printArray();

		System.out.println(dynamicArray.size());
		dynamicArray.clear();
		System.out.println(dynamicArray.size());
		dynamicArray.printArray();

	}
}