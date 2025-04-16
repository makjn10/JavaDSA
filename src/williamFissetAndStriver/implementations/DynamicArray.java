package williamFissetAndStriver.implementations;

import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class DynamicArray <T> implements Iterable <T>{

	private T[] arr;
	private int len = 0;
	private int capacity = 0;

	public DynamicArray() {
		this(8);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0)	throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		arr = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	// O(1) TC
	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return len == 0;
	}

	// O(1) TC complexity, O(n) in case of resizing which happens few times
	public void add(T ele) {
		if (len >= capacity) {
			capacity *= 2;
			T[] newArr = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[len++] = ele;
	}

	// O(1) TC
	public T get(int index) {
		if(index >= len || index < 0)	throw new IndexOutOfBoundsException();
		return arr[index];
	}

	// O(1) TC
	public void set(int index, T ele) {
		if(index >= len || index < 0)	throw new IndexOutOfBoundsException();
		arr[index] = ele;
	}

	// O(n) TC
	public T removeAt(int index) {
		if(index >= len || index < 0)	throw new IndexOutOfBoundsException();
		T ele = arr[index];

		for (int i = index + 1; i < len; i++) {
			arr[i - 1] = arr[i];
		}
		len--;

		return ele;
	}

	// O(n) TC
	public boolean remove(T ele) {
		for (int i = 0; i < len; i++) {
			if(Objects.equals(ele, arr[i])) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	// O(n) TC
	public void clear() {
		for (int i = 0; i < capacity; i++) {
			arr[i] = null;
		}
		len = 0;
	}

	// O(n) TC
	public int indexOf(T ele) {
		for (int i = 0; i < len; i++) {
			if(Objects.equals(ele, arr[i])) {
				return i;
			}
		}
		return -1;
	}

	// O(n) TC
 	public void reverse() {
		int i = 0, j = len - 1;
		while (i < j) {
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public void printArray () {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Iterator is still fast but not as fast as iterative for loop
	@Override
	public java.util.Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			int index = 0;

			public boolean hasNext() {
				return index < len;
			}

			public T next() {
				return arr[index++];
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}


	@Override
	public void forEach(Consumer<? super T> action) {
		Iterable.super.forEach(action);
	}

	@Override
	public Spliterator<T> spliterator() {
		return Iterable.super.spliterator();
	}
}
