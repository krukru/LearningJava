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
package kru.collections;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class LinkedListTest extends AbstractListTest {

  @Override
  protected List<String> createList() {
    return new LinkedList<>();
  }

  @Test
  public void testAddFirst() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addFirst(2);
    list.add(3);
    list.addFirst(1);
    assertEquals(3, list.size());
    assertEquals(1, list.get(0).intValue());
    assertEquals(2, list.get(1).intValue());
    assertEquals(3, list.get(2).intValue());
  }

  @Test
  public void testAddLast() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    assertEquals(3, list.size());
    assertEquals(1, list.get(0).intValue());
    assertEquals(2, list.get(1).intValue());
    assertEquals(3, list.get(2).intValue());
  }

  @Test
  public void testRemoveFirst() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(3, list.size());
    list.removeFirst();
    assertEquals(2, list.size());
    assertEquals(2, list.get(0).intValue());
    assertEquals(3, list.get(1).intValue());
    list.removeFirst();
    assertEquals(1, list.size());
    assertEquals(3, list.get(0).intValue());
    list.removeFirst();
    assertEquals(0, list.size());
  }

  @Test
  public void testRemoveLast() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(3, list.size());
    list.removeLast();
    assertEquals(2, list.size());
    assertEquals(1, list.get(0).intValue());
    assertEquals(2, list.get(1).intValue());
    list.removeLast();
    assertEquals(1, list.size());
    assertEquals(1, list.get(0).intValue());
    list.removeLast();
    assertEquals(0, list.size());
  }

  @Test
  public void testGetFirst() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(1, list.getFirst().intValue());
  }

  @Test
  public void testGetLast() {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    assertEquals(3, list.getLast().intValue());
  }
}
