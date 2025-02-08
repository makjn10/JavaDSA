package geeksforgeeks.arrays;

public class LinkedListProblems {

	// User function Template for Java
	private static class Node {
		int data;
		Node next;

		Node() { data = 0; }
		Node(int d) { data = d; }  //constructor to create a new node
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
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return head;
	}


}
