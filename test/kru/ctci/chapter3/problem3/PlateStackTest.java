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
    assertEquals(97, plateStack.size());
    for (int i = 96; i >= 0; i--) {
      assertEquals(i, plateStack.pop().intValue());
    }
    assertEquals(0, plateStack.size());
    assertTrue(plateStack.isEmpty());
  }

  @Test
  public void testPopAtStack() {
    for (int i = 0; i < 100; i++) {
      plateStack.push(i);
    }
    plateStack.popAtStack(0); /* popped 9 */
    plateStack.popAtStack(1); /* popped 19 */
    plateStack.popAtStack(2); /* popped 29 */
    plateStack.popAtStack(3); /* popped 39 */
    plateStack.popAtStack(4); /* popped 49 */
    assertEquals(95, plateStack.size());
    for (int i = 99; i >= 0; i--) {
      if (i == 9 || i == 19 || i == 29 || i == 39 || i == 49) {
        continue;
      }
      int num = plateStack.pop();
      assertEquals(num, i);
    }
  }
}
