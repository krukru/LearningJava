package kru.trees.binarytree;

import kru.exception.runtimexception.NotImplementedException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class BinarySearchTree<E extends Comparable<E>> implements Set<E> {

  private Node<E> root;
  private int size = 0;
  private int height = 0;

  public int height() {
    return height;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object object) {
    try {
      E element = (E) object;
      return findNode(element) != null;
    } catch (Exception e) {
      return false;
    }
  }

  private Node<E> findNode(E value) {
    if (root == null) {
      return null;
    } else {
      Node<E> currentNode = root;
      while (currentNode != null) {
        int comparison = value.compareTo(currentNode.data);
        if (comparison == 0) {
          return currentNode;
        } else if (comparison < 0) {
          currentNode = currentNode.leftChild;
        } else {
          currentNode = currentNode.rightChild;
        }
      }
      return null;
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new DfsIterator();
  }

  @Override
  public Object[] toArray() {
    throw new NotImplementedException();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new NotImplementedException();
  }

  @Override
  public boolean add(E element) {
    if (root == null) {
      this.root = new Node<>(element);
      this.height = 1;
      this.size = 1;
    } else {
      int newHeight = 1;
      Node<E> currentNode = root;
      while (true) {
        newHeight += 1;
        int comparison = element.compareTo(currentNode.data);
        if (comparison == 0) {
          return false;
        } else if (comparison < 0) {
          if (currentNode.leftChild == null) {
            currentNode.leftChild = new Node<>(currentNode, element);
            this.height = Math.max(this.height, newHeight);
            this.size += 1;
            return true;
          } else {
            currentNode = currentNode.leftChild;
          }
        } else {
          if (currentNode.rightChild == null) {
            currentNode.rightChild = new Node<>(currentNode, element);
            this.height = Math.max(this.height, newHeight);
            this.size += 1;
            return true;
          } else {
            currentNode = currentNode.rightChild;
          }
        }
      }
    }
    return true;
  }

  @Override
  public boolean remove(Object object) {
    throw new NotImplementedException();
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (contains(o) == false) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    for (E e : c) {
      add(e);
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    throw new NotImplementedException();
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    for (Object o : c) {
      remove(o);
    }
    return true;
  }

  @Override
  public void clear() {
    root = null; /* should also remove pointer from internal nodes via iterator */
    size = 0;
  }

  public class DfsIterator implements Iterator<E> {

    private Node<E> nextNode;

    public DfsIterator() {
      this.nextNode = BinarySearchTree.this.root;
    }

    @Override
    public boolean hasNext() {
      return nextNode != null;
    }

    @Override
    public E next() {
      E result = nextNode.data;
      if (nextNode.leftChild != null) {
        nextNode = nextNode.leftChild;
      } else if (nextNode.rightChild != null) {
        nextNode = nextNode.rightChild;
      } else {
        Node<E> prevNode = nextNode;
        nextNode = nextNode.parent;
        while (nextNode != null && nextNode.rightChild == prevNode) {
          prevNode = nextNode;
          nextNode = nextNode.parent;
        }
        if (nextNode != null) {
          nextNode = nextNode.rightChild;
        }
      }
      return result;
    }

    @Override
    public void remove() {
      throw new NotImplementedException();
    }
  }

}
