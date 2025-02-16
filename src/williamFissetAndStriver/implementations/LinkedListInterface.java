package williamFissetAndStriver.implementations;

public interface LinkedListInterface<T> extends Iterable<T> {
	void addLast(T ele);

	void addFirst(T ele);

	void addAt(int index, T ele);

	T peekFirst();

	T peekLast();

	int getSize();

	boolean isEmpty();

	void clear();

	T removeLast();

	T removeFirst();

	T removeAt(int index);

	boolean remove(Object obj);

	int indexOf(Object obj);

	boolean contains(Object obj);
}
