package kru.ctci.chapter3.problem5;

import kru.collections.Queue;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MyQueueTest {

  @Test
  public void basicTest() throws Exception {
    MyQueue<Integer> queue = new MyQueue<>();
    Queue<Integer> controlQueue = new Queue<>();
    Random rnd = new Random();
    for (int i = 0; i < 20000; i++) {
      int roll = rnd.nextInt(100);
      if (roll < 15) {
        queue.enqueue(i);
        controlQueue.offer(i);
      } else {
        if (queue.isEmpty() == false) {
          int expectedElement;
          int element;
          if (roll < 30) {
            expectedElement = controlQueue.peek();
            element = queue.peek();
          } else {
            expectedElement = controlQueue.remove();
            element = queue.dequeue();
          }
          assertEquals(expectedElement, element);
        } else {
          queue.enqueue(i);
          controlQueue.offer(i);
        }
      }
      assertEquals(controlQueue.size(), queue.size());
    }
  }
}
