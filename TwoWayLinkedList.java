public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
      for (int i = 0; i < objects.length; i++)
        add(i, objects[i]);
      }

    /** Return the head element in the list */
    public E getFirst() {
      if (size == 0) {
        return null;
      }
      else {
        return head.element;
      }
    }

    /** Return the last element in the list */
    public E getLast() {
      if (size == 0) {
        return null;
      }
      else {
        return tail.element;
      }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size
        if (tail == null) // The new node is the only node in list
          tail = head;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node for e
        
        if (tail == null) {
          head = tail = newNode; // The only node in list
        }
        else {
          tail.next = newNode; // Link the new node with the last node
          tail = newNode; // tail now points to the last node
        }
       
        size++; // Increase size
    }

    /** Add a new element at the specified index
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) addFirst(e); // Insert first
        else if (index >= size) addLast(e); // Insert last
        else { // Insert in the middle
          Node<E> current = head;
          for (int i = 1; i < index; i++)
            current = current.next;
          Node<E> temp = current.next;
          current.next = new Node<>(e);
          (current.next).next = temp;
          size++;
       }
    }

    /** Remove the head node and
     * return the object that is contained in the removed node. */
    public E removeFirst(int index, E e) {
        if (index == 0) addFirst(e); // Insert first
        else if (index >= size) addLast(e); // Insert last
        else { // Insert in the middle
          Node<E> current = head;
          for (int i = 1; i < index; i++)
            current = current.next;
          Node<E> temp = current.next;
          current.next = new Node<>(e);
          (current.next).next = temp;
           size++;
        }
        return e;
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0 || size == 1) {
          return removeFirst(size, null);
        }
        else {
           Node<E> current = head;
           for (int i = 0; i < size - 2; i++) {
             current = current.next;
           }
       
           E temp = tail.element;
           tail = current;
           tail.next = null;
           size--;
           return temp;
        }
    }

    /** Remove the element at the specified position in this
     * list. Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) return null; // Out of range
        else if (index == 0) return removeFirst(index, null); // Remove first
        else if (index == size - 1) return removeLast(); // Remove last
        else {
          Node<E> previous = head;
        
          for (int i = 1; i < index; i++) {
            previous = previous.next;
        }
       
        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
        return current.element;
        }
    }

    /** Override toString() to return elements in the list */
    public String toString() {
      StringBuilder result = new StringBuilder("[");

      Node<E> current = head;
      for (int i = 0; i < size; i++) {
        result.append(current.element);
        current = current.next;
        if (current != null) {
          result.append(", "); // Separate two elements with a comma
        }
        else {
          result.append("]"); // Insert the closing ] in the string
        }
      }

      return result.toString();
    }

    /** Clear the list */
    public void clear() {
      size = 0;
      head = tail = null;
    }

    /** Return true if this list contains the element e */
    public boolean contains(Object e) {
      // Left as an exercise
      return true;
    }

    /** Return the element at the specified index */
    public E get(int index) {
      // Left as an exercise
      return null;
    }

    /** Return the index of the first matching element in
     * this list. Return −1 if no match. */
    public int indexOf(Object e) {
      // Left as an exercise
      return 0;
    }

    /** Return the index of the last matching element in
     * this list. Return −1 if no match. */
    public int lastIndexOf(E e) {
      // Left as an exercise
      return 0;
    }

    /** Replace the element at the specified position
     * in this list with the specified element. */
    public E set(int index, E e) {
      // Left as an exercise
      return null;
    }

    /** Override iterator() defined in Iterable */ 
    public java.util.Iterator<E> iterator() {
      return new LinkedListIterator<E>(this.head);
    }

//    public void listIterator(){
//      return java.util.ListIterator<E>;
//    }

//    public void listIterator(int index) {
//      return java.util.ListIterator<E>;
//    }

    
  }
