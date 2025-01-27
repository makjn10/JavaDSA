package williamFisset.implementations;

public class SinglyLinkedList <T> {
	Node<T> head;
	Node<T> tail;

	SinglyLinkedList() {
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







}

class Node <T> {
	T data;
	Node<T> next;

	public Node (T data) {
		this.data = data;
		this.next = null;
	}
}