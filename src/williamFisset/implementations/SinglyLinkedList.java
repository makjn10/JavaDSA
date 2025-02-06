package williamFisset.implementations;

@SuppressWarnings("unchecked")
public class SinglyLinkedList<T> {
	Node<T> head;
	Node<T> tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	public void insertAtLast(T ele) {
		Node<T> newNode = new Node<>(ele);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void insertAtFirst(T ele) {
		Node<T> newNode = new Node<>(ele);
		newNode.next = head;
		head = newNode;
	}

	// 0 based position
	public void insertAtPos(T ele, int pos) {
		if (pos < 0)	throw new IndexOutOfBoundsException();
		if (pos == 0)	insertAtFirst(ele);

		Node<T> temp = head;
		int curPos = 0;
		while (curPos < pos - 1) {
			if (temp == null)	throw new IndexOutOfBoundsException();
			temp = temp.next;
			curPos++;
		}
		if (temp == null)	throw new IndexOutOfBoundsException();

		Node<T> newNode = new Node<>(ele);
		newNode.next = temp.next;
		temp.next = newNode;
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