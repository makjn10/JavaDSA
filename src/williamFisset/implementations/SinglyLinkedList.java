package williamFisset.implementations;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class SinglyLinkedList<T> implements LinkedListInterface<T> {

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	private class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	Node<T> head;
	Node<T> tail;
	int size = 0;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addLast(T ele) {
		Node<T> newNode = new Node<>(ele);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addFirst(T ele) {
		Node<T> newNode = new Node<>(ele);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public void addAt(int index, T ele) {
		if (index < 0 || index >= size) throw new IllegalArgumentException();
		if (index == 0) {
			addFirst(ele);
			return;
		}
		Node<T> temp = head;
		int currIndex = 1;

		while (currIndex < index) {
			temp = temp.next;
			currIndex++;
		}
		Node<T> newNode = new Node<>(ele);
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
	}

	@Override
	public T peekFirst() {
		if (size == 0) throw new RuntimeException("Empty List");
		return head.data;
	}

	@Override
	public T peekLast() {
		if (size == 0) throw new RuntimeException("Empty List");
		return tail.data;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		while (head != null) {
			Node<T> trav = head.next;
			head.next = null;
			head = trav;
		}
		tail = null;
		size = 0;
	}

	@Override
	public T removeFirst() {
		if (size == 0) throw new RuntimeException("Empty List");

		T data = head.data;
		if (size == 1) {
			clear();
			return data;
		}

		Node<T> temp = head.next;
		head.next = null;
		head = temp;
		size--;
		return data;
	}

	@Override
	public T removeLast() {
		if (size == 0) throw new RuntimeException("Empty List");

		T data = tail.data;
		if (size == 1) {
			clear();
			return data;
		}

		Node<T> temp = head;
		while (temp.next != null && temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		tail = temp;
		size--;
		return data;
	}

	@Override
	public T removeAt(int index) {
		if (index < 0 || index >= size) throw new IllegalArgumentException();
		if (index == 0) return removeFirst();
		if (index == size - 1) return removeLast();

		Node<T> temp = head;
		int currRemIndex = 1;

		while (currRemIndex < index) {
			temp = temp.next;
			currRemIndex++;
		}

		Node<T> deletedNode = temp.next;
		temp.next = deletedNode.next;
		deletedNode.next = null;
		size--;
		return deletedNode.data;
	}

	@Override
	public boolean remove(Object obj) {
		if (size == 0) throw new RuntimeException("Empty List");
		// null obj not supported
		if (obj == null) {
			return false;
		}
		if (obj.equals(head.data)) {
			removeFirst();
			return true;
		}
		Node<T> temp1 = head;
		Node<T> temp2 = head.next;
		while (temp2 != null) {
			if (obj.equals(temp2.data)) {
				temp1.next = temp2.next;
				temp2.next = null;
				size--;
				return true;
			}
			temp1 = temp2;
			temp2 = temp2.next;
		}
		return false;
	}

	@Override
	public int indexOf(Object obj) {
		// do not support null
		if (obj == null) return -1;

		int index = 0;
		Node<T> temp = head;
		while (temp != null) {
			if (obj.equals(temp.data)) {
				return index;
			}
			index++;
			temp = temp.next;
		}
		return -1;
	}

	@Override
	public boolean contains(Object obj) {
		// do not support null
		return indexOf(obj) != -1;
	}

	@Override
	public String toString() {
		Node<T> temp = head;
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		while (temp != null) {
			sb.append(temp.data);
			if (temp.next != null) sb.append(" -> ");
			temp = temp.next;
		}
		sb.append(" ]");
		return sb.toString();
	}
}