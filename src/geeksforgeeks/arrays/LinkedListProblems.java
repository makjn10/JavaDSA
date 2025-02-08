package geeksforgeeks.arrays;

public class LinkedListProblems {

	// https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-linked-list
	// User function Template for Java

	private static class Node {
		int data;
		Node next;

		Node() { data = 0; }
		Node(int d) { data = d; }  //constructor to create a new node
	}

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
