package leetcode.arrays;

public class LinkedListProblems {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// https://leetcode.com/problems/delete-node-in-a-linked-list/
	// TC : O(n), n is length of linked list
	// SC : O(1)
	class Solution {
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
	}
}
