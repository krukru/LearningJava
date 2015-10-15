/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kru.collections.testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public abstract class AbstractListTest {

  protected abstract List<String> createList();

  private List<String> createList(List<String> strings) {
    List<String> result = this.createList();
    result.addAll(strings);
    return result;
  }

  @Test
  public void basicTest() {
    List<String> list = this.createList();
    list.add(0, "B");
    list.add(1, "C");
    list.add(2, "D");
    list.add(0, "A");

    assertEquals(list.indexOf("A"), 0);

    list.remove(0);
    assertEquals(list.get(0), "B");
    assertEquals(list.size(), 3);
    assertEquals(list.indexOf("C"), 1);

    String removed = list.remove(1);
    assertNotNull(removed);
    assertTrue(removed.equals("C"));

    list.add(1, "E");
    assertEquals(list.size(), 3);
    assertNotNull(list.get(1));
    assertTrue(list.get(1).equals("E"));

    list.set(1, "F");
    assertNotNull(list.get(1));
    assertTrue(list.get(1).equals("F"));

    list.add(0, "G");

    assertTrue(list.equals(this.createList(Arrays.asList("G", "B", "F", "D"))));
    assertFalse(list.equals(this.createList(Arrays.asList("G", "B", "F", "D", "E"))));
    assertFalse(list.equals(this.createList(Arrays.asList("B", "F", "E"))));

    assertEquals(4, list.size());

    List<String> copy = this.createList(Arrays.asList("G", "B", "F", "D"));
    int i = 0;
    for (String item : list) {
      assertEquals(item, copy.get(i++));
    }

    int j = 0;
    ListIterator<String> iterator = list.listIterator();
    while (j < list.size()) {
      iterator.next();
      j++;
    }

    while (iterator.hasPrevious()) {
      String s = iterator.previous();
      assertEquals(s, copy.get(--j));
    }

    iterator = list.listIterator();
    assertEquals(iterator.next(), "G");
    assertEquals(iterator.next(), "B");
    assertEquals(iterator.previous(), "B");
    assertEquals(iterator.previous(), "G");
    assertEquals(iterator.next(), "G");

    iterator = list.listIterator();
    iterator.add("M");
    assertTrue(list.equals(this.createList(Arrays.asList("M", "G", "B", "F", "D"))));

    assertEquals(iterator.next(), "M");
    iterator.add("N");
    assertTrue(list.equals(this.createList(Arrays.asList("M", "N", "G", "B", "F", "D"))));

    iterator = list.listIterator();
    while (iterator.hasNext()) {
      iterator.next();
    }
    assertEquals(iterator.previous(), "D");

    while (iterator.hasPrevious()) {
      iterator.previous();
    }
    assertEquals(iterator.next(), "M");
  }


  @Test
  public void iteratorTest() {
    List<String> list = this.createList();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.add("F");
    list.add("G");
    list.add("H");
    List<String> subList = list.subList(1, 4);
    assertEquals(3, subList.size());
    assertEquals("B", subList.get(0));
    assertEquals("C", subList.get(1));
    assertEquals("D", subList.get(2));
  }

  @Test
  public void testContains() {
    List<String> list = this.createList();
    list.add("A");
    list.add("B");
    assertTrue(list.contains("A"));
    assertTrue(list.contains("B"));
    assertFalse(list.contains("C"));

    java.util.ArrayList<String> collection = new java.util.ArrayList<>();
    collection.add("1");
    collection.add("2");
    collection.add("3");
    list.addAll(collection);
    assertTrue(list.contains("1"));
    assertTrue(list.contains("2"));
    assertTrue(list.contains("3"));
    assertFalse(list.contains("4"));
    assertFalse(list.contains("12"));
    assertEquals(5, list.size());
  }

  @Test
  public void testToArray() {
    List<String> list = this.createList();
    assertArrayEquals(new String[]{}, list.toArray());
    list.add("A");
    list.add("B");
    String[] expectedArray = new String[]{"A", "B"};
    assertArrayEquals(expectedArray, list.toArray());
  }

  @Test
  public void testRemove() {
    List<String> list = this.createList();
    String input = "A";
    list.add(input);
    list.remove(input);
    assertEquals(0, list.size());
    assertFalse(list.contains(input));
    list.add(input);
    assertTrue(list.contains(input));
    assertEquals(1, list.size());
    list.remove(input);
    assertEquals(0, list.size());
    assertFalse(list.contains(input));
  }

  @Test
  public void testClearAndLastIndexOf() {
    /* Yea, two tests in one. I'm terribly sorry. */
    List<String> list = this.createList();
    for (int i = 0; i < 100; i++) {
      list.add("A");
    }
    assertEquals(100, list.size());
    assertEquals(99, list.lastIndexOf("A"));
    assertEquals(-1, list.lastIndexOf("B"));
    list.clear();
    assertEquals(0, list.size());
    assertEquals(-1, list.lastIndexOf("A"));
  }

  @Test
  public void testIteratorWithStartingIndex() {
    List<String> list = this.createList();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    ListIterator<String> iterator = list.listIterator(1);
    assertTrue(iterator.hasPrevious());
    assertTrue(iterator.previous().equals("A"));
    assertFalse(iterator.hasPrevious());
    iterator.next();
    assertTrue(iterator.next().equals("B"));
    assertTrue(iterator.next().equals("C"));
    assertTrue(iterator.next().equals("D"));
    assertTrue(iterator.next().equals("E"));
    assertTrue(iterator.previous().equals("E"));
    iterator.next();
    assertFalse(iterator.hasNext());
  }

}
