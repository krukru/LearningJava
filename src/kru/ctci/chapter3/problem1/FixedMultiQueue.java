package kru.ctci.chapter3.problem1;

public class FixedMultiQueue<E> {

  E[] data;

  private static final int DEFAULT_NUMBER_OF_QUEUES = 3;
  private static final int RESIZE_FACTOR = 4;
  private static final int DEFAULT_QUEUE_CAPACITY = 32;
  private int numberOfQueues;
  private int currentCapacity;
  private MultiQueueInstance[] queueInstances;


  public FixedMultiQueue() {
    this(DEFAULT_NUMBER_OF_QUEUES);
  }

  public FixedMultiQueue(int numberOfQueues) {
    if (numberOfQueues < 0) {
      throw new IllegalArgumentException();
    }
    this.numberOfQueues = numberOfQueues;
    int arraySize = numberOfQueues * DEFAULT_QUEUE_CAPACITY;
    this.data = initDataArray(arraySize);
    this.queueInstances = initQueueInstances(numberOfQueues, DEFAULT_QUEUE_CAPACITY);
    this.currentCapacity = DEFAULT_QUEUE_CAPACITY;
  }

  private E[] initDataArray(int size) {
    return (E[]) new Object[size];
  }

  private MultiQueueInstance[] initQueueInstances(int size, int initialQueueCapacity) {
    MultiQueueInstance[] result = (MultiQueueInstance[]) new Object[size];
    for (int i = 0; i < size; i++) {
      result[i] = new MultiQueueInstance(this, i * initialQueueCapacity, (i + 1) *
          initialQueueCapacity - 1);
    }
    return result;
  }

  public MultiQueueInstance getQueue(int index) {
    if (index < 0 || index > numberOfQueues) {
      throw new IndexOutOfBoundsException();
    }
    return queueInstances[index];
  }

  void resize() {
    int newCapacity = RESIZE_FACTOR * currentCapacity;
    for (int i = 0; i < numberOfQueues; i++) {
      queueInstances[i].startIndex = i * newCapacity;
      queueInstances[i].endIndex = (i + 1) * newCapacity - 1;
      queueInstances[i].headIndex = i * newCapacity;
      queueInstances[i].tailIndex = i * newCapacity;
    }
  }
}
