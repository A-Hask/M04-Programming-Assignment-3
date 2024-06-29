public class LinkedListIterator<E> implements java.util.Iterator<E> {
private Node<E> current; // Current index

public LinkedListIterator(Node<E> head) {
	this.current = head;
}

@Override
public boolean hasNext() {
  return (current != null);
}

@Override
public E next() {
  E e = current.element;
  current = current.next;
  return e;
}

@Override
public void remove() {
  // Left as an exercise
}
}
