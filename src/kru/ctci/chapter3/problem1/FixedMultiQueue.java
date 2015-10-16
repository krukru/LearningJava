package kru.ctci.chapter3.problem1;

import java.lang.reflect.Array;

/* @TODO: this class could use more optimization */
public class FixedMultiQueue<E> {

  E[] data;

  private static final int DEFAULT_NUMBER_OF_QUEUES = 3;
  private static final int RESIZE_FACTOR = 4;
  private static final int DEFAULT_QUEUE_CAPACITY = 32;
  private int numberOfQueues;
  private int currentCapacity;
  private MultiQueueInstance<E>[] queueInstances;


  public FixedMultiQueue() {
    this(DEFAULT_NUMBER_OF_QUEUES);
  }

  public FixedMultiQueue(int numberOfQueues) {
    if (numberOfQueues < 0) {
      throw new IllegalArgumentException();
    }
    this.numberOfQueues = numberOfQueues;
    this.data = initDataArray(DEFAULT_QUEUE_CAPACITY);
    this.queueInstances = initQueueInstances(numberOfQueues, DEFAULT_QUEUE_CAPACITY);
    this.currentCapacity = DEFAULT_QUEUE_CAPACITY;
  }

  private E[] initDataArray(int size) {
    return (E[]) new Object[size * numberOfQueues];
  }

  private MultiQueueInstance<E>[] initQueueInstances(int size, int initialQueueCapacity) {
    MultiQueueInstance<E>[] result = (MultiQueueInstance<E>[]) Array.newInstance(MultiQueueInstance
        .class, size);
    for (int i = 0; i < size; i++) {
      result[i] = new MultiQueueInstance(this, i * initialQueueCapacity, (i + 1) *
          initialQueueCapacity - 1);
    }
    return result;
  }

  public MultiQueueInstance<E> getQueue(int index) {
    if (index < 0 || index > numberOfQueues) {
      throw new IndexOutOfBoundsException();
    }
    return queueInstances[index];
  }

  void resize() {
    int newCapacity = RESIZE_FACTOR * currentCapacity;
    /* change the indices */
    for (int i = 0; i < numberOfQueues; i++) {
      int headOffset = queueInstances[i].headIndex - queueInstances[i].startIndex;
      int tailOffset = queueInstances[i].tailIndex - queueInstances[i].startIndex;
      queueInstances[i].startIndex = i * newCapacity;
      queueInstances[i].endIndex = (i + 1) * newCapacity - 1;
      queueInstances[i].headIndex = i * newCapacity + headOffset;
      queueInstances[i].tailIndex = i * newCapacity + tailOffset;
    }
    /* shift the data */
    E[] newDataArray = initDataArray(newCapacity);
    for (int i = 0; i < data.length; i++) {
      int shiftOffset = currentCapacity * (i / currentCapacity);
      newDataArray[i + shiftOffset] = data[i];
    }
    this.data = newDataArray;
    this.currentCapacity = newCapacity;
  }
}
