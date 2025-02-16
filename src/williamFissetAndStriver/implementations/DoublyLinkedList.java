package williamFissetAndStriver.implementations;

import java.util.Iterator;

public class DoublyLinkedList<T> implements LinkedListInterface<T> {
	private class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;

		Node(T data) {
			this.data = data;
			next = null;
			prev = null;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private Node<T> head, tail;
	private int size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		while (head != null) {
			Node<T> temp = head.next;
			head.prev = null;
			head.next = null;
			head = temp;
		}
		tail = null;
		size = 0;
	}

	public void addLast(T ele) {
		Node<T> newNode = new Node<>(ele);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addFirst(T ele) {
		Node<T> newNode = new Node<>(ele);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addAt(int index, T ele) {
		if (index < 0 || index >= size) throw new IllegalArgumentException();
		if (index == 0) {
			addFirst(ele);
			return;
		}

		Node<T> temp;
		int currentIndex;

		if (index >= size / 2) {
			currentIndex = size - 1;
			temp = tail;
			while (currentIndex > index) {
				temp = temp.prev;
				currentIndex--;
			}
		} else {
			currentIndex = 0;
			temp = head;
			while (currentIndex < index) {
				temp = temp.next;
				currentIndex++;
			}
		}

		Node<T> newNode = new Node<>(ele);
		newNode.prev = temp.prev;
		newNode.next = temp;
		temp.prev.next = newNode;
		temp.prev = newNode;
		size++;
	}

	public T peekFirst() {
		if (size == 0) throw new RuntimeException("Empty LIst");
		return head.data;
	}

	public T peekLast() {
		if (size == 0) throw new RuntimeException("Empty LIst");
		return tail.data;
	}

	public T removeFirst() {
		if (size == 0) throw new RuntimeException("Empty LIst");
		T data = head.data;
		if (size == 1) {
			clear();
		} else {
			Node<T> temp = head.next;
			head.next.prev = null;
			head.next = null;
			head = temp;
			size--;
		}
		return data;
	}

	public T removeLast() {
		if (size == 0) throw new RuntimeException("Empty LIst");
		T data = tail.data;
		if (size == 1) {
			clear();
		} else {
			Node<T> temp = tail.prev;
			tail.prev.next = null;
			tail.prev = null;
			tail = temp;
			size--;
		}
		return data;
	}

	// assuming Node is from this doubly linked list
	public T remove(Node<T> node) {
		if (node.prev == null) return removeFirst();
		else if (node.next == null) return removeLast();

		T data = node.data;

		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = node.prev = null;
		size--;

		return data;
	}

	// 0 based indexing
	public T removeAt(int index) {
		if (index < 0 || index >= size) throw new IllegalArgumentException();

		Node<T> temp;
		int currentIndex;

		if (index >= size / 2) {
			currentIndex = size - 1;
			temp = tail;
			while (currentIndex > index) {
				temp = temp.prev;
				currentIndex--;
			}
		} else {
			currentIndex = 0;
			temp = head;
			while (currentIndex < index) {
				temp = temp.next;
				currentIndex++;
			}
		}

		return remove(temp);
	}

	public boolean remove(Object ele) {
		// obj null is not supported
		if (ele == null) return false;
		for (Node<T> temp = head; temp != null; temp = temp.next) {
			if (ele.equals(temp.data)) {
				remove(temp);
				return true;
			}
		}
		return false;
	}

	public int indexOf(Object ele) {
		// obj null is not supported
		if (ele == null) return -1;
		int index = 0;
		for (Node<T> temp = head; temp != null; temp = temp.next, index++) {
			if (ele.equals(temp.data)) {
				return index;
			}
		}
		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}


	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> temp = head;

			@Override
			public boolean hasNext() {
				return temp != null;
			}

			@Override
			public T next() {
				T data = temp.data;
				temp = temp.next;
				return data;
			}
		};
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ null <-> ");

		Node<T> temp = head;
		while (temp != null) {
			sb.append(temp.data).append(" <-> ");
			temp = temp.next;
		}

		sb.append("null ]");
		return sb.toString();
	}
}

