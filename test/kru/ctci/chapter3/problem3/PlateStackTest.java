package kru.ctci.chapter3.problem3;

import org.junit.Test;

import static org.junit.Assert.*;


public class PlateStackTest {

  private PlateStack<Integer> plateStack = new PlateStack<>();

  @Test
  public void basicTest() {
    for (int i = 0; i < 100; i++) {
      plateStack.push(i);
    }
    assertEquals(100, plateStack.size());
    assertEquals(99, plateStack.peek().intValue());
    assertEquals(99, plateStack.pop().intValue());
    assertEquals(98, plateStack.pop().intValue());
    assertEquals(97, plateStack.pop().intValue());
    assertEquals(96, plateStack.peek().intValue());
    for (int i = 96; i >= 0; i--) {
      assertEquals(i, plateStack.pop().intValue());
    }
  }

}
