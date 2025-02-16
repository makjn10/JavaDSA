package geeksforgeeks.linkedlist;

import java.util.ArrayList;

public class DoublyLinkedListProblems {
	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
			prev = null;
			next = null;
		}
	}

	// https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-doubly-linked-list
	// TC : O(n)
	// SC : O(1)
	Node constructDLL(int[] arr) {
		// Code here
		Node head = null, tail = null;
		for (int j : arr) {
			Node newNode = new Node(j);
			if (head == null) {
				head = tail = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = tail.next;
			}
		}
		return head;
	}

	// https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insert-a-node-in-doubly-linked-list
	// TC : O(n)
	// SC : O(1)
	// Function to insert a new node at given position in doubly linked list.
	Node addNode(Node head, int p, int x) {
		// Your code here

		int index = 0;
		Node currNode = head, newNode = new Node(x);
		while (index < p) {
			currNode = currNode.next;
			index++;
		}

		newNode.next = currNode.next;
		newNode.prev = currNode;
		if (currNode.next != null) {
			currNode.next.prev = newNode;
		}
		currNode.next = newNode;
		return head;
	}

	// https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list
	// TC : O(n)
	// SC : O(1)
	public Node deleteNode(Node head, int x) {
		// code here
		Node temp = head;
		int index = 1;
		while (index < x) {
			temp = temp.next;
			index++;
		}

		if (temp.prev == null) {
			// need to delete head
			Node newHead = temp.next;
			if (newHead == null) return null;
			newHead.prev = null;
			temp.next = null;
			return newHead;
		} else if (temp.next == null) {
			// need to delete tail
			Node newTail = temp.prev;
			if (newTail == null) return null;
			newTail.next = null;
			temp.prev = null;
		} else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			temp.next = null;
			temp.prev = null;
		}
		return head;
	}

	// https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list
	// TC : O(N)
	// SC : O(1)
	static Node deleteAllOccurOfX(Node head, int x) {
		// Write your code here
		if (head == null || (head.data == x && head.next == null)) return null;

		Node temp = head;
		while (temp != null) {
			if (temp.data == x) {
				if (temp.prev == null) {
					head = temp.next;
					if (temp.next == null) return null;
					else temp.next.prev = null;
				} else if (temp.next == null) {
					temp.prev.next = null;
				} else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
			}
			temp = temp.next;
		}
		return head;
	}

	// https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list
	public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
		// code here
		// TC : O(N + N/2)
		// SC : O(n/2) for answer
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		if (head == null || head.next == null) return list;
		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}

		Node l = head, r = tail;
		while (l != r && l.prev != r) {
			if (l.data + r.data == target) {
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(l.data);
				newList.add(r.data);
				list.add(newList);
				l = l.next;
				r = r.prev;
			} else if (l.data + r.data > target) r = r.prev;
			else l = l.next;

		}
		return list;
	}

	// https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicates-from-a-sorted-doubly-linked-list
	Node removeDuplicates(Node head) {
		// Code Here.

		// TC : O(N)
		// SC : O(1)
		Node temp = head;
		while (temp != null && temp.next != null) {
			if (temp.data == temp.next.data) {
				temp.next = temp.next.next;
				if (temp.next != null) temp.next.prev = temp;
			} else {
				temp = temp.next;
			}
		}
		return head;
	}
}
