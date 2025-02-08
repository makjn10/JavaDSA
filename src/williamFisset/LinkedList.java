package williamFisset;

// Linked list is a sequential list of nodes that hold data which point to other node also containing data
// Where are LLs used?
//	- Many List, Queue and Stack implementations (due to optimum time complexity for addition/deletion)
//	- Great for creating circular lists (modelling circular problems like round-robin etc.)
//	- Model real-world objects like trains
//	- Used in separate chaining (in hashtable implementation to deal with hash collisions)
//	- Used in implementation od adjacency lists for graphs

// Terminology :
// Head : The first node in a LL (we always maintain a reference to it)
// Tail : The last node in a LL
// Pointer/Reference : Reference to another node
// Node : An object containing data and reference

// Singly Linked Lists
// node->node->node->node->null
// Only has pointer to next node
// In implementations we maintain reference to head and tail for quick addition and deletion
// Pros :
// 	- Use less memory
//	- Simple implementation
// Cons :
//	- Cannot easily access previous elements

// Doubly Linked Lists
// null->node<->node<->node->null
// Pointer to next and previous node
// In implementations we maintain reference to head and tail for quick addition and deletion from both ends of list
// Pros :
// 	- Can be traversed backwards
// Cons :
//	- Takes 2x memory

// Time Complexities (Singly LL, Doubly LL)
// Insert at Head : O(1), O(1)
// Insert at Tail : O(1), O(1)
// Insert in middle : O(n), O(n)
// Search : O(n), O(n)
// Remove at Head : O(1), O(1)
// Remove at Tail : O(n), O(1)
// Remove in middle : O(n), O(n)

import williamFisset.implementations.DoublyLinkedList;
import williamFisset.implementations.SinglyLinkedList;

public class LinkedList {
	public static void main(String[] args) {

		SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
		singlyLinkedList.addLast(1);
		singlyLinkedList.removeLast();

		singlyLinkedList.addLast(2);
		singlyLinkedList.addLast(3);
		singlyLinkedList.addLast(6);
		singlyLinkedList.addLast(5);
		singlyLinkedList.addLast(4);
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.getSize());

		singlyLinkedList.addFirst(23);
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.getSize());

		singlyLinkedList.addAt(2, 233);
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.getSize());

		singlyLinkedList.addLast(544);
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.getSize());

		singlyLinkedList.removeAt(0);
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.getSize());

		singlyLinkedList.remove(2);
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.getSize());

		singlyLinkedList.removeLast();
		System.out.println(singlyLinkedList);
		System.out.println(singlyLinkedList.getSize());


		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

		doublyLinkedList.addLast(1);
		doublyLinkedList.addLast(2);
		doublyLinkedList.addLast(3);

		System.out.println(doublyLinkedList);

		doublyLinkedList.addAt(0, 0);
		System.out.println(doublyLinkedList);

		doublyLinkedList.addAt(3, 4);
		System.out.println(doublyLinkedList);

		doublyLinkedList.removeFirst();
		doublyLinkedList.removeLast();
		System.out.println(doublyLinkedList);

		doublyLinkedList.addAt(1, 23);
		doublyLinkedList.addAt(1, 52);
		System.out.println(doublyLinkedList);

		doublyLinkedList.removeAt(2);
		System.out.println(doublyLinkedList);
	}
}
