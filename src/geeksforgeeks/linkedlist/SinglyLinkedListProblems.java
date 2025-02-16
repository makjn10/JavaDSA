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
	private static class Node2 {
		int data;
		Node2 next;
		Node2 bottom;

		Node2(int d) {
			data = d;
			next = null;
			bottom = null;
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
		if (head == null || head.next == null) return 0;
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

	// https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it
	// Function to sort a linked list of 0s, 1s and 2s.
	static Node updateVal(Node head, int val, int count) {
		Node temp = head;
		while (temp != null && count > 0) {
			temp.data = val;
			count--;
			temp = temp.next;
		}
		return temp;
	}

	static Node segregate(Node head) {
		// add your code here

		// changing links (one-pass)
		// TC : O(n)
		// SC : O(1)
		Node head0 = new Node(-1), tail0 = head0, head1 = new Node(-1), tail1 = head1, head2 = new Node(-1), tail2 = head2;
		Node temp = head;

		while (temp != null) {
			if (temp.data == 0) {
				tail0.next = temp;
				tail0 = tail0.next;
			} else if (temp.data == 1) {
				tail1.next = temp;
				tail1 = tail1.next;
			} else {
				tail2.next = temp;
				tail2 = tail2.next;
			}
			temp = temp.next;
		}

		tail0.next = null;
		tail1.next = null;
		tail2.next = null;
		head0 = head0.next;
		head1 = head1.next;
		head2 = head2.next;

		if (head2 != null) {
			if (head1 != null) tail1.next = head2;
			else if (head0 != null) tail0.next = head2;
			else return head2;
		}
		if (head1 != null) {
			if (head0 != null) tail0.next = head1;
			else return head1;
		}
		return head0;

		// brute-force (update val in node)
		// TC : O(2n)
		// SC : O(1)
		// int count0 = 0, count1 = 0, count2 = 0;
		// Node temp = head;
		// while (temp != null) {
		//     if (temp.data == 0) count0++;
		//     else if (temp.data == 1) count1++;
		//     else count2++;
		//     temp = temp.next;
		// }

		// Node temp2 = updateVal(head, 0, count0);
		// temp2 = updateVal(temp2, 1, count1);
		// temp2 = updateVal(temp2, 2, count2);
		// return head;
	}

	// https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list
	// https://www.naukri.com/code360/problems/add-one-to-a-number-represented-as-linked-list_920557?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=SUBMISSION
	// TC : O(3*N)
	// SC : O(1)
	public int addOneRec(Node head) {
		if (head == null) {
			return 1;
		}

		int sum = addOneRec(head.next) + head.data;
		int carry = sum / 10;
		int val = sum % 10;
		head.data = val;
		return carry;
	}

	public Node reverseLL(Node head) {
		Node prev = null, temp = head;
		while (temp != null) {
			Node next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		return prev;
	}

	public Node addOne(Node head) {
		// code here.

		// TC : O(n)
		// SC : O(n) // recursion stack
		int res = addOneRec(head);
		if (res > 0) {
			Node newNode = new Node(res);
			newNode.next = head;
			return newNode;
		}
		return head;

		// TC : O(3N)
		// SC : O(1)
		// Node reverseList = reverseLL(head);
		// Node temp = reverseList;
		// int carry = 1, sum = 0;

		// while(temp != null) {
		//     sum = temp.data + carry;
		//     temp.data = sum % 10;
		//     carry = sum / 10;
		//     temp = temp.next;
		// }

		// reverseList = reverseLL(reverseList);

		// if (carry == 0) return reverseList;
		// else {
		//     Node newNode = new Node(carry);
		//     newNode.next = reverseList;
		//     return newNode;
		// }
	}

	// https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list
	// Function to flatten a linked list
	Node2 mergeSortedSubLists(Node2 node1, Node2 node2) {
		Node2 head = new Node2(-1), tail = head;
		Node2 temp1 = node1, temp2 = node2;
		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				tail.bottom = temp1;
				tail = temp1;
				temp1 = temp1.bottom;

			} else {
				tail.bottom = temp2;
				tail = temp2;
				temp2 = temp2.bottom;
			}
			tail.next = null;
			tail.bottom = null;
		}
		if (temp1 != null) {
			tail.bottom = temp1;
		}
		if (temp2 != null) {
			tail.bottom = temp2;
		}
		return head.bottom;
	}

	Node2 flatten(Node2 root) {
		// TC : O(N^2 * M)
		// SC : O(1)
		// merge two sorted sub-lists
		if (root == null || root.next == null) {
			return root;
		}

		Node2 t1 = root, t2 = root.next;
		while (t2 != null) {
			Node2 t2Next = t2.next;
			t1 = mergeSortedSubLists(t1, t2);
			t2 = t2Next;
		}
		return t1;

		// code here
		// TC : O(nm + nmlognm + nm)
		// SC : O(nm + nm)
		// Node2 temp = root;
		// List<Integer> arr = new ArrayList<>();
		// while (temp != null) {
		//     arr.add(temp.data);
		//     Node2 bottom = temp.bottom;
		//     while (bottom != null) {
		//         arr.add(bottom.data);
		//         bottom = bottom.bottom;
		//     }
		//     temp = temp.next;
		// }
		// Collections.sort(arr);

		// Node2 newNode = new Node(-1), tail = newNode;
		// for (int ele : arr) {
		//     tail.bottom = new Node2(ele);
		//     tail = tail.bottom;
		// }
		// return newNode.bottom;
	}

}
