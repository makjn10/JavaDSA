package geeksforgeeks.linkedlist;

public class SinglyLinkedListProblems {

	// User function Template for Java
	private static class Node {
		int data;
		Node next;

		Node() {
			data = 0;
		}

		Node(int d) {
			data = d;
		}  //constructor to create a new node
	}

	// https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-linked-list
	// TC : O(n)
	// SC : O(1)
	static Node constructLL(int[] arr) {
		// code here
		Node head = null, tail = null;
		for (int ele : arr) {
			Node newNode = new Node(ele);
			if (head == null) head = tail = newNode;
			else {
				tail.next = newNode;
				tail = newNode;
			}
		}
		return head;
	}

	// https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-insertion
	// TC : O(n), because tail is not given
	// SC : O(1)
	Node insertAtEnd(Node head, int x) {
		// code here
		Node newNode = new Node(x);
		if (head == null) {
			return newNode;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return head;
	}

	// https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-nodes-of-linked-list
	// Recursive
	// Function to count nodes of a linked list.
	// TC : O(n)
	// SC : O(n) // no tail call optimization / tail recursion supported in Java
	public int getCount(Node head) {
		// code here
		if (head == null) return 0;
		return 1 + getCount(head.next);
	}

	// Iterative
	// Function to count nodes of a linked list.
	// TC : O(n)
	// SC : O(1)
	public int getCountItr(Node head) {
		// code here
		int count = 0;
		Node trav = head;
		while (trav != null) {
			count++;
			trav = trav.next;
		}
		return count;
	}

	// https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-in-linked-list-1664434326
	// TC : O(n)
	// SC : O(1)
	static boolean searchKey(int n, Node head, int key) {
		// Code here
		Node trav = head;
		while (trav != null) {
			if (trav.data == key) return true;
			trav = trav.next;
		}
		return false;
	}


}
