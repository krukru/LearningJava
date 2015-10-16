package kru.ctci.chapter3.problem1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FixedMultiQueueTest {

  @Test
  public void basicTest() {
    final int numberOfQueues = 3;
    FixedMultiQueue<Integer> fmq = new FixedMultiQueue<>(numberOfQueues);
    for (int queueIndex = 0; queueIndex < numberOfQueues; queueIndex++) {
      for (int i = 0; i < 100; i++) {
        fmq.getQueue(queueIndex).enqueue(i + 100 * queueIndex);
      }
    }
    assertEquals(0, fmq.getQueue(0).peek().intValue());
    assertEquals(100, fmq.getQueue(1).peek().intValue());
    assertEquals(200, fmq.getQueue(2).peek().intValue());
    assertEquals(0, fmq.getQueue(0).dequeue().intValue());
    assertEquals(1, fmq.getQueue(0).dequeue().intValue());
    assertEquals(100, fmq.getQueue(1).dequeue().intValue());
    assertEquals(101, fmq.getQueue(1).peek().intValue());
    assertEquals(200, fmq.getQueue(2).dequeue().intValue());
    assertEquals(201, fmq.getQueue(2).dequeue().intValue());
    assertEquals(202, fmq.getQueue(2).peek().intValue());
  }

}
