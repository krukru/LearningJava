package kru.ctci.chapter3.problem6;

import kru.collections.Stack;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StackSorterTest {

  @Test
  public void testSort2() {
    Stack<Integer> stack = new Stack<>();
    Random rnd = new Random();
    for (int i = 0; i < 100; i++) {
      stack.add(rnd.nextInt(10000));
    }
    StackSorter ss = new StackSorter();
    ss.sort(stack);
    int minimalElement = stack.peek();
    while (stack.isEmpty() == false) {
      int nextElement = stack.pop();
      if (nextElement < minimalElement) {
        fail();
      }
      minimalElement = nextElement;
    }
  }
}
