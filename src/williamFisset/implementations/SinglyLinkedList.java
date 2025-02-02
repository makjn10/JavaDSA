package williamFisset.implementations;

public class SinglyLinkedList<T> {
	Node<T> head;
	Node<T> tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	public void add(T ele) {
		Node<T> newNode = new Node<>(ele);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void addAtPos(T ele, int pos) {
		if (pos <= 0) {
			throw new IllegalArgumentException("Enter positive position");
		}

		Node<T> newNode = new Node<T>(ele);
		if (pos == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			int currPos = 1;
			Node<T> currNode = head;

			while (currPos < (pos - 1)) {
				if (currNode == null) throw new IllegalArgumentException("Position greater than length of LL");
				currNode = currNode.next;
				currPos++;
			}
			if (currNode == null) throw new IllegalArgumentException("Position greater than length of LL");

			newNode.next = currNode.next;
			currNode.next = newNode;
		}
	}

	public void printLL() {
		Node<T> currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data);
			if (currNode.next != null) System.out.print(" -> ");
			currNode = currNode.next;
		}
		System.out.println();
	}

}

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}