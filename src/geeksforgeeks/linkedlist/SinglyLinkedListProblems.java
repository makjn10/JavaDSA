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

	// https://www.geeksforgeeks.org/problems/find-length-of-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-length-of-loop
	// Function to find the length of a loop in the linked list.
	public int countNodesinLoop(Node head) {
		// Add your code here.

		// Tortoise Algo
		if (head == null || head.next == null)   return 0;
		Node n1 = head.next, n2 = head.next.next;
		while (n2 != null && n2.next != null) {
			if (n1 == n2) {
				int len = 1;
				n1 = n1.next;
				while (n1 != n2) {
					n1 = n1.next;
					len++;
				}
				return len;
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		return 0;


		// TC : O(n) considering map operations are O(1)
		// SC : O(n)
		// HashMap<Node, Integer> mp = new HashMap<>();
		// Node temp = head;
		// int timer = 1;
		// while (temp != null) {
		//     if(mp.containsKey(temp)) {
		//         return timer - mp.get(temp);
		//     }
		//     mp.put(temp, timer);
		//     timer++;
		//     temp = temp.next;
		// }
		// return 0;
	}


}
