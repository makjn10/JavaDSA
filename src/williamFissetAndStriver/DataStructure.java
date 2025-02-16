package williamFissetAndStriver;

// A DS is a way of organizing data so that it can be accessed, queried or updated easily and efficiently
// Essential ingredients in creating fast and powerful algorithms
// They help manage and organize data

// Abstract Data Types vs Data Structures
// ADT is an abstraction os a data structure which provides only the interface to which a data structure should adhere to
// Eg - List interface in java, ArrayList, LinkedList are it's implementation
//	  - Queue -> Array based, LL based, Stack based queue
//    - Map -> Tree, Hash Map


import java.util.Scanner;

public class DataStructure {

	// Computational complexity (Big-O notation)
	// How much time does this algo need to finish?
	// How much space does this algo need for its computation?

	// Big-O notation gives an upper bound of the complexity in the WORST case
	// O(1) > O(log n) > O(n^0.5) > O(n) > O(nlog n) > O(n^2) > O(n^3) > O(b^n , b > 1) > O(n!)

	// Big-O properties
	// O(n + c) == O(n)
	// O(cn) == O(n), c > 0
	// f(n) = 7log (n^3) + 15* (n^2) + 2* (n^3) + 8 ==> O(f(n)) = O(n^3)

	public static void main(String[] args) {

		// O(1)
		System.out.print("O(1) : ");
		int i = 0;
		while (i < 11) {
			i++;
		}
		System.out.println(i);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = sc.nextInt();

		// O(n)
		System.out.print("O(n) : ");
		i = 0;
		while (i < n) {
			i++;
		}
		System.out.println(i);

		// O(n / 3) = O(n)
		System.out.print("O(n) : ");
		i = 0;
		while (i < n) {
			i = i + 3;
		}
		System.out.println(i);

		// O(n^2)
		System.out.print("O(n ^ 2) : ");
		i = 0;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				i++;
			}
		}
		System.out.println(i);

		// O((n*(n + 1))/2) = O(n^2)
		System.out.print("O(n ^ 2) : ");
		i = 0;
		for (int j = 0; j < n; j++) {
			for (int k = j; k < n; k++) {
				i++;
			}
		}
		System.out.println(i);

		int[] arr = {-41, -40, -30, -1, 0, 1, 23, 34, 45, 55, 58, 200};

		// O(log n)
		int low = 0, high = arr.length - 1, val = 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == val) {
				System.out.println("At index " + mid);
				break;
			}
			if(arr[mid] > val)	high = mid - 1;
			else low = mid + 1;
		}

	}

}
