package leetcode.linkedlist;

import java.util.HashMap;

public class SinglyLinkedListProblems {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// https://leetcode.com/problems/delete-node-in-a-linked-list/
	// TC : O(n), n is length of linked list
	// SC : O(1)
	public void deleteNode(ListNode node) {
		// Since it is not a tail node
		ListNode trav1 = node;
		ListNode trav2 = node.next;
		while (trav2.next != null) {
			trav1.val = trav2.val;
			trav2 = trav2.next;
			trav1 = trav1.next;
		}
		trav1.val = trav2.val;
		trav1.next = null;
	}

	// https://leetcode.com/problems/reverse-linked-list/
	// TC : O(n)
	// SC : O(n) (recursion stack)
	// Recursive
	public ListNode reverseList(ListNode head, ListNode nextNode) {
		ListNode temp = head.next;
		head.next = nextNode;
		if (temp == null) {
			return head;
		}
		return reverseList(temp, head);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		return reverseList(head, null);
	}

	// Iterative
	public ListNode reverseListItr(ListNode head) {
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	// https://leetcode.com/problems/middle-of-the-linked-list/
	// TC : O(n/2) = O(n)
	// SC : O(1)
	public ListNode middleNode(ListNode head) {
		if (head == null) return null;

		ListNode trav1 = head, trav2 = head.next;
		while (true) {
			if (trav2 == null) return trav1;
			if (trav2.next == null) return trav1.next;
			trav1 = trav1.next;
			trav2 = trav2.next.next;
		}
	}

	// https://leetcode.com/problems/linked-list-cycle/
	// TC : O(n)
	// SC : O(n)
	public boolean hasCycle(ListNode head) {
		HashMap<ListNode, Boolean> mp = new HashMap<>();
		ListNode temp = head;
		while (temp != null) {
			if (mp.containsKey(temp)) return true;
			mp.put(temp, true);
			temp = temp.next;
		}
		return false;
	}

	// TC : O(n)
	// SC : O(1)
	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null) return false;

		ListNode p1 = head, p2 = head.next;
		while (p1 != null && p2 != null) {
			if (p1 == p2) return true;
			if (p2.next == null) return false;
			p2 = p2.next.next;
			p1 = p1.next;
		}
		return false;
	}
}
