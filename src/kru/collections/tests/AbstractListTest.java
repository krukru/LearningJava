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
package kru.collections.tests;

import kru.collections.LinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;


public abstract class AbstractListTest {

  protected abstract List<String> createList();

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
    assertTrue(list.equals(new LinkedList<String>(Arrays.asList("G", "B", "F", "D"))));
    assertFalse(list.equals(new LinkedList<String>(Arrays.asList("G", "B", "F", "D", "E"))));
    assertFalse(list.equals(new LinkedList<String>(Arrays.asList("B", "F", "E"))));

    assertEquals(4, list.size());

    ArrayList<String> copy = new ArrayList<>(Arrays.asList("G", "B", "F", "D"));
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
    assertTrue(list.equals(new LinkedList<String>(Arrays.asList("M", "G", "B", "F", "D"))));

    assertEquals(iterator.next(), "M");
    iterator.add("N");
    assertTrue(list.equals(new LinkedList<String>(Arrays.asList("M", "N", "G", "B", "F", "D"))));

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
}
