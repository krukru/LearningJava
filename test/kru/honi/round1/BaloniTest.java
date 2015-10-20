package kru.honi.round1;

import kru.collections.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaloniTest {

  Baloni baloni = new Baloni();

  @Test
  public void testExample1() throws Exception {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(2);
    list.add(1);
    list.add(5);
    list.add(4);
    list.add(3);
    assertEquals(2, baloni.solve(list));
  }

  @Test
  public void testExample2() throws Exception {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    assertEquals(5, baloni.solve(list));
  }

  @Test
  public void testExample3() throws Exception {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(5);
    list.add(2);
    list.add(1);
    list.add(4);
    assertEquals(3, baloni.solve(list));
  }
}
