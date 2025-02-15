package leetcode.linkedlist;

import java.util.HashMap;
import java.util.List;

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
	public ListNode reverseList(ListNode head, ListNode prevNode) {
		ListNode temp = head.next;
		head.next = prevNode;
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

	// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
	// TC : O(n/2)
	// SC : O(1)
	public ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode slow = head, fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	// https://leetcode.com/problems/add-two-numbers/
	// TC : O(max(l1.length, l2.length))
	// SC : O(1), O(n) for new LL
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode prev = null, curr = null, head = null;
		int sum = 0, carry = 0;

		while (l1 != null && l2 != null) {
			sum = (carry + l1.val + l2.val) % 10;
			carry = (carry + l1.val + l2.val) / 10;
			curr = new ListNode(sum);
			if (prev != null) {
				prev.next = curr;
			} else {
				head = curr;
			}
			prev = curr;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			sum = (carry + l1.val) % 10;
			carry = (carry + l1.val) / 10;
			curr = new ListNode(sum);
			if (prev != null) {
				prev.next = curr;
			} else {
				head = curr;
			}
			prev = curr;
			l1 = l1.next;
		}
		while (l2 != null) {
			sum = (carry + l2.val) % 10;
			carry = (carry + l2.val) / 10;
			curr = new ListNode(sum);
			if (prev != null) {
				prev.next = curr;
			} else {
				head = curr;
			}
			prev = curr;
			l2 = l2.next;
		}
		if (carry != 0) {
			curr = new ListNode(carry);
			prev.next = curr;
		}

		return head;
	}

	// https://leetcode.com/problems/intersection-of-two-linked-lists/
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		// TC : O(n + m)
		// SC : O(1)
		ListNode tempA = headA;
		ListNode tempB = headB;

		while (tempA != null && tempB != null) {
			if (tempA.next == null && tempB.next == null && tempA != tempB) return null;
			if (tempA == tempB) return tempA;

			if (tempA.next == null) tempA = headB;
			else tempA = tempA.next;
			if (tempB.next == null) tempB = headA;
			else tempB = tempB.next;
		}
		return null;

		// TC : O(2n + m) or (2m + n) whichever is shorter
		// SC : O(1)
		// int lenA = 0, lenB = 0;
		// ListNode tempA = headA, tempB = headB;
		// while (tempA != null) {
		//     lenA++;
		//     tempA = tempA.next;
		// }
		// while (tempB != null) {
		//     lenB++;
		//     tempB = tempB.next;
		// }
		// int diff = Math.abs(lenA - lenB);
		// tempA = (lenA > lenB) ? headA : headB;
		// tempB = (tempA == headA) ? headB : headA;
		// while (diff > 0) {
		//     tempA = tempA.next;
		//     diff--;
		// }
		// while (tempA != null && tempB != null) {
		//     if (tempA == tempB) return tempA;
		//     tempA = tempA.next;
		//     tempB = tempB.next;
		// }
		// return null;

		// TC : O(n + m) // assuming O(1) map operations
		// SC : O(n)
		// HashMap<ListNode, Boolean> mp = new HashMap<>();
		// ListNode tempA = headA, tempB = headB;

		// while (tempA != null) {
		//     mp.put(tempA, true);
		//     tempA = tempA.next;
		// }
		// while (tempB != null) {
		//     if(mp.containsKey(tempB)) {
		//         return tempB;
		//     }
		//     tempB = tempB.next;
		// }
		// return null;
	}

	// https://leetcode.com/problems/sort-list/description/
	// TC : O(N + M)
	public ListNode mergeTwoSortedLL(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode head = new ListNode(-1);
		ListNode tail = head;

		while (l1 != null && l2 != null) {
			if (l2.val < l1.val) {
				tail.next = l2;
				l2 = l2.next;
			} else {
				tail.next = l1;
				l1 = l1.next;
			}
			tail = tail.next;
		}
		tail.next = (l1 != null) ? l1 : l2;
		return head.next;
	}

	public ListNode mergeSortList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode temp = slow.next;
		slow.next = null;

		ListNode leftSorted = mergeSortList(head);
		ListNode rightSorted = mergeSortList(temp);
		return mergeTwoSortedLL(leftSorted, rightSorted);
	}

	public ListNode sortList(ListNode head) {
		// TC : O((n/2 + n) * log n)
		// SC : O(1)
		// divide the LL in two
		// sort divided LLs
		// Merge sorted LLs
		return mergeSortList(head);

		// Keep an array, sort the array and change vals in LL
		// TC : O(n + nlogn + n)
		// SC : O(n)
		// ArrayList<Integer> list = new ArrayList<>();

		// ListNode temp = head;
		// while (temp != null) {
		//     list.add(temp.val);
		//     temp = temp.next;
		// }
		// Collections.sort(list);

		// temp = head;
		// int index = 0;
		// while (temp != null) {
		//     temp.val = list.get(index);
		//     temp = temp.next;
		//     index++;
		// }

		// return head;
	}

	// https://leetcode.com/problems/reverse-nodes-in-k-group/
	public void reverseArrGroup(List<Integer> arr, int l, int r) {
		if (r >= arr.size()) return;
		while (l < r) {
			int temp = arr.get(l);
			arr.set(l, arr.get(r));
			arr.set(r, temp);
			l++;
			r--;
		}
	}
	public ListNode reverseKGroup(ListNode head, int k) {

		// TC : O(2 * n)
		// SC : O(1)
		// Keep A counter, reverse list in groups and adjust pointers appropriately
		if (k <= 1) return head;

		ListNode currHead = null, masterHead = null, tail = null, temp = head;
		int counter = 0;

		while (temp != null) {
			counter++;
			if (counter == 1) {
				currHead = temp;
			}

			if (counter == k) {
				counter = 0;
				ListNode tempNext = temp.next;
				temp.next = null;
				ListNode newHead = reverseList(currHead);
				if (masterHead == null) masterHead = newHead;
				if (tail != null) tail.next = newHead;
				tail = currHead;
				temp = tempNext;
			} else {
				temp = temp.next;
			}

		}
		if (counter != 0) {
			if (tail != null) tail.next = currHead;
			else return currHead;
		}
		return masterHead;

		// TC : O(n + n + n)
		// SC : O(n)
		// List<Integer> arr = new ArrayList<>();
		// ListNode temp = head;
		// while (temp != null) {
		//     arr.add(temp.val);
		//     temp = temp.next;
		// }
		// for (int i = 0; i < arr.size(); i += k) {
		//     reverseArrGroup(arr, i, i + k - 1);
		// }
		// temp = head;
		// for (int ele : arr) {
		//     temp.val = ele;
		//     temp = temp.next;
		// }
		// return head;
	}
}
