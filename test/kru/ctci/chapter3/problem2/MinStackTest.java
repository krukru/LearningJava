package kru.ctci.chapter3.problem2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

  @Test
  public void testGetMin1() throws Exception {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(1);
    minStack.push(2);
    minStack.push(3);
    minStack.push(4);
    minStack.push(5);
    assertEquals(1, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(1, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(1, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(1, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(1, minStack.getMin().intValue());
    minStack.pop();
  }

  @Test
  public void testGetMin2() throws Exception {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(5);
    minStack.push(4);
    minStack.push(3);
    minStack.push(2);
    minStack.push(1);
    assertEquals(1, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(2, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(3, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(4, minStack.getMin().intValue());
    minStack.pop();
    assertEquals(5, minStack.getMin().intValue());
    minStack.pop();
  }
}
