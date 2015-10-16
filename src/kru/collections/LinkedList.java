package kru.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import kru.exception.runtimexception.NotImplementedException;

public class LinkedList<E> extends AbstractList<E> {

  private int size = 0;
  private LinkedListNode root;
  private LinkedListNode tail;

  public LinkedList() {

  }

  public LinkedList(Collection<E> collection) {
    this.addAll(collection);
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return (this.root == null);
  }

  @Override
  public boolean contains(Object o) {
    if (this.isEmpty()) {
      return false;
    }
    for (E element : this) {
      if (element.equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedListIterator(this);
  }

  @Override
  public Object[] toArray() {
    Object[] result = new Object[this.size];
    int i = 0;
    for (E item : this) {
      result[i] = item;
      i++;
    }
    return result;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new NotImplementedException("Odbijam implementirati ovu glupu metodu. Java, you should " +
        "know better.");
  }

  @Override
  public boolean add(E element) {
    this.add(this.size, element);
    return true;
  }

  @Override
  public void add(int index, E element) {
    LinkedListNode node = new LinkedListNode(element);
    internalAdd(index, node);
  }

  public void addFirst(E element) {
    LinkedListNode newNode = new LinkedListNode(element);
    internalAdd(0, newNode);
  }

  public void addLast(E element) {
    add(element);
  }

  public void removeFirst() {
    if (root == null) {
      throw new NoSuchElementException();
    }
    internalRemove(root);
  }

  public void removeLast() {
    if (tail == null) {
      throw new NoSuchElementException();
    }
    internalRemove(tail);
  }

  public E getFirst() {
    if (root == null) {
      throw new NoSuchElementException();
    }
    return root.element;
  }

  public E getLast() {
    if (tail == null) {
      throw new NoSuchElementException();
    }
    return tail.element;
  }

  private void internalAdd(int index, LinkedListNode node) {
    final int indexOfLastElement = this.size;
    if (index > indexOfLastElement) {
      throw new IndexOutOfBoundsException();
    }
    this.size += 1;
    if (index == 0) {
      if (this.root == null) {
        this.root = node;
        this.tail = node;
      } else {
        this.insertBefore(this.root, node);
      }
    } else if (index == indexOfLastElement) {
      this.insertAfter(this.tail, node);
    } else {
      LinkedListNode pivotNode = this.getNodeAtIndex(index);
      this.insertBefore(pivotNode, node);
    }
  }

  private void insertAfter(LinkedListNode pivotNode, LinkedListNode newNode) {
    newNode.prev = pivotNode;
    newNode.next = pivotNode.next;
    if (pivotNode.next != null) {
      (pivotNode.next).prev = newNode;
    }
    pivotNode.next = newNode;
    if (pivotNode == tail) {
      this.tail = newNode;
    }
  }

  private void insertBefore(LinkedListNode pivotNode, LinkedListNode newNode) {
    newNode.next = pivotNode;
    newNode.prev = pivotNode.prev;
    if (pivotNode.prev != null) {
      (pivotNode.prev).next = newNode;
    }
    pivotNode.prev = newNode;
    if (pivotNode == root) {
      this.root = newNode;
    }
  }

  @Override
  public E remove(int index) {
    LinkedListNode node = this.getNodeAtIndex(index);
    E removedElement = node.element;
    this.internalRemove(node);
    return removedElement;
  }

  @Override
  public boolean remove(Object object) {
    LinkedListNode node = this.getNode(object);
    if (node != null) {
      this.internalRemove(node);
      return true;
    } else {
      return false;
    }
  }

  private void internalRemove(LinkedListNode node) {
    this.size -= 1;
    if (this.root == node) {
      this.root = node.next;
    }
    if (this.tail == node) {
      this.tail = node.prev;
    }
    node.remove();
  }

  private LinkedListNode getNode(Object object) {
    LinkedListNode currentNode = this.root;
    while (currentNode != null) {
      if (currentNode.element.equals(object)) {
        return currentNode;
      }
      currentNode = currentNode.next;
    }
    return null;
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    boolean collectionChanged = false;
    LinkedListNode currentNode = this.tail.prev;
    while (currentNode != null) {
      if (collection.contains(currentNode.next.element) == false) {
        collectionChanged = true;
        currentNode.next.remove();
      }
      currentNode = currentNode.prev;
    }
    return collectionChanged;
  }

  @Override
  public void clear() {
    this.size = 0;
    LinkedListNode killPointer = this.tail.prev;
    /* GC */
    while (killPointer != null) {
      killPointer.next = null;
      killPointer = killPointer.prev;
    }
  }

  @Override
  public E get(int index) {
    LinkedListNode node = this.getNodeAtIndex(index);
    return node.element;
  }

  @Override
  public E set(int index, E element) {
    LinkedListNode node = this.getNodeAtIndex(index);
    E oldElement = node.element;
    node.element = element;
    return oldElement;
  }

  private LinkedListNode getNodeAtIndex(int index) {
    if (index > this.size) {
      throw new IndexOutOfBoundsException();
    }
    int currentIndex = 0;
    LinkedListNode currentNode = this.root;
    while (currentIndex != index) {
      currentNode = currentNode.next;
      currentIndex += 1;
    }
    return currentNode;
  }

  @Override
  public int indexOf(Object object) {
    int index = 0;
    for (E element : this) {
      if (element.equals(object)) {
        return index;
      }
      index += 1;
    }
    return index;
  }

  @Override
  public int lastIndexOf(Object object) {
    int lastIndex = size - 1;
    LinkedListNode currentNode = tail;
    while (currentNode != null) {
      if (currentNode.element.equals(object)) {
        break;
      }
      currentNode = currentNode.prev;
      lastIndex -= 1;
    }
    return lastIndex;
  }

  @Override
  public ListIterator<E> listIterator() {
    return new LinkedListIterator(this);
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return new LinkedListIterator(this, index);
  }

  public ListIterator<E> listIteratorFromTail() {
    return new LinkedListIterator(this, size);
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    LinkedList<E> subList = new LinkedList<>();
    Iterator<E> iterator = this.iterator();
    int currentIndex;
    for (currentIndex = 0; currentIndex < fromIndex; currentIndex++) {
      iterator.next();
    }
    for (/* nop */; currentIndex < toIndex; currentIndex++) {
      E item = iterator.next();
      subList.add(item);
    }
    return subList;
  }

  private class LinkedListNode {
    private E element;
    private LinkedListNode prev;
    private LinkedListNode next;

    public LinkedListNode(E element) {
      this.element = element;
    }

    public void remove() {
      LinkedListNode tempNode = this.next;
      if (this.prev != null) {
        (this.prev).next = this.next;
      }
      if (tempNode != null) {
        tempNode.prev = this.prev;
      }
      this.next = null;
      this.prev = null;
    }
  }

  private class LinkedListIterator implements ListIterator<E> {

    private LinkedList<E> linkedList;
    private LinkedListNode nextNode;
    private LinkedListNode previousNode;
    private LinkedListNode lastAccessedElement;
    private int nextIndex = 0;

    public LinkedListIterator(LinkedList<E> linkedList) {
      this(linkedList, 0);
    }

    public LinkedListIterator(LinkedList<E> linkedList, int startingIndex) {
      if (startingIndex < 0 || startingIndex > size()) {
        throw new IndexOutOfBoundsException();
      }
      this.linkedList = linkedList;
      if (startingIndex == linkedList.size()) {
        /* special case, tail requested */
        this.nextNode = null;
        this.previousNode = linkedList.tail;
      }
      else {
        this.nextNode = linkedList.root;
        this.previousNode = null;
        while (nextIndex != startingIndex) {
          next();
        }
      }
    }

    @Override
    public boolean hasNext() {
      return this.nextNode != null;
    }

    @Override
    public E next() {
      if (this.nextNode == null) {
        throw new NoSuchElementException();
      }
      E nextItem = this.nextNode.element;
      this.lastAccessedElement = this.nextNode;
      this.previousNode = this.nextNode;
      this.nextNode = this.nextNode.next;
      this.nextIndex += 1;
      return nextItem;
    }

    @Override
    public boolean hasPrevious() {
      return this.previousNode != null;
    }

    @Override
    public E previous() {
      if (this.previousNode == null) {
        throw new NoSuchElementException();
      }
      E prevItem = this.previousNode.element;
      this.lastAccessedElement = this.previousNode;
      this.nextNode = this.previousNode;
      this.previousNode = this.previousNode.prev;
      this.nextIndex += 1;
      return prevItem;
    }

    @Override
    public int nextIndex() {
      return this.nextIndex;
    }

    @Override
    public int previousIndex() {
      return this.nextIndex - 1;
    }

    @Override
    public void remove() {
      if (lastAccessedElement != null) {
        linkedList.internalRemove(lastAccessedElement);
        this.lastAccessedElement = null;
      }
    }

    @Override
    public void set(E element) {
      if (this.lastAccessedElement != null) {
        this.lastAccessedElement.element = element;
        this.lastAccessedElement = null;
      }
    }

    @Override
    public void add(E element) {
      LinkedListNode newNode = new LinkedListNode(element);
      this.nextNode = newNode;
      this.previousNode = this.nextNode.prev;
      this.linkedList.internalAdd(nextIndex, newNode);
      this.lastAccessedElement = null;
    }
  }
}
