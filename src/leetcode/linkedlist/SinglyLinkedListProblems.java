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

	// https://leetcode.com/problems/linked-list-cycle-ii/
	public ListNode detectCycle(ListNode head) {

		// tortoise algo
		// TC : O(n)
		// SC : O(1)
		if (head == null || head.next == null) return null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;

		// Using Hashmap
		// TC : O(n)
		// SC : O(n)
		// HashMap<ListNode, Boolean> mp = new HashMap<>();
		// ListNode trav = head;
		// while (trav != null) {
		//     if (mp.containsKey(trav)) {
		//         return trav;
		//     }
		//     mp.put(trav, true);
		//     trav = trav.next;
		// }
		// return null;
	}

	// https://leetcode.com/problems/palindrome-linked-list/
	public ListNode checkNode;

	public boolean checkPal(ListNode curr) {
		if (curr == null) {
			return true;
		}
		boolean checkFurther = checkPal(curr.next);
		int val = checkNode.val;
		checkNode = checkNode.next;
		return checkFurther && (curr.val == val);
	}

	public ListNode reverseLLIter(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public boolean isPalindrome(ListNode head) {
		// TC : O(2n)
		// SC : O(1)
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode newLL = reverseLLIter(slow.next);
		ListNode temp1 = head, temp2 = newLL;
		while (temp2 != null) {
			if (temp2.val != temp1.val) {
				reverseLLIter(newLL);
				return false;
			}
			temp2 = temp2.next;
			temp1 = temp1.next;
		}
		reverseLLIter(newLL);
		return true;

		// recursive
		// TC : O(n)
		// SC : O(n) recursion stack + 1 global variable
		// checkNode = head;
		// return checkPal(head);

		// brute
		// TC : O(n)
		// SC : O(n)
		// ArrayList<Integer> list = new ArrayList<>();
		// ListNode temp = head;

		// while (temp != null) {
		//     list.add(temp.val);
		//     temp = temp.next;
		// }

		// int i = 0, j = list.size() - 1;
		// while (i < j) {
		//     if (list.get(i) != list.get(j)) return false;
		//     i++;
		//     j--;
		// }
		// return true;
	}

	// https://leetcode.com/problems/odd-even-linked-list/
	// TC : O(n)
	// SC : O(1)
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		ListNode p1 = head, pHead = head;
		ListNode p2 = head.next.next;
		ListNode s1 = head.next, sHead = head.next;
		ListNode s2 = head.next.next.next;

		p1.next = p2;
		s1.next = s2;
		while (s2 != null && s2.next != null) {
			s1 = s2;
			p1 = p2;
			s2 = s2.next.next;
			p2 = p2.next.next;
			p1.next = p2;
			s1.next = s2;
		}
		p2.next = sHead;
		return pHead;
	}

	// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	// TC : O(n)
	// SC : O(1)
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) return null;
		ListNode s = head, p = head;

		int k = n;
		while (k > 0) {
			p = p.next;
			k--;
		}
		if (p == null) return head.next;
		while (p.next != null) {
			s = s.next;
			p = p.next;
		}
		s.next = s.next.next;
		return head;
	}
}
