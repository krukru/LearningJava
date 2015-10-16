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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.List;

public class QueueTest extends AbstractListTest {

  @Override
  protected List<String> createList() {
    return new Queue<>();
  }

  @Test
  public void testOffer() {
    Queue<Integer> queue = new Queue<>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
    assertEquals(5, queue.size());
    assertEquals(1, queue.get(0).intValue());
    assertEquals(2, queue.get(1).intValue());
    assertEquals(3, queue.get(2).intValue());
    assertEquals(4, queue.get(3).intValue());
    assertEquals(5, queue.get(4).intValue());
  }

  @Test
  public void testPeek() {
    Queue<Integer> queue = new Queue<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    assertEquals(5, queue.size());

    assertEquals(1, queue.peek().intValue());
    assertEquals(5, queue.size());

    assertEquals(1, queue.peek().intValue());
    assertEquals(5, queue.size());
    queue.remove();

    assertEquals(2, queue.peek().intValue());
    assertEquals(4, queue.size());
    queue.clear();
    assertEquals(0, queue.size());
    assertNull(queue.peek());
  }

  @Test
  public void testElement() {
    Queue<Integer> queue = new Queue<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    assertEquals(5, queue.size());

    assertEquals(1, queue.element().intValue());
    assertEquals(5, queue.size());

    assertEquals(1, queue.element().intValue());
    assertEquals(5, queue.size());
    queue.remove();

    assertEquals(2, queue.element().intValue());
    assertEquals(4, queue.size());
    queue.clear();
    assertEquals(0, queue.size());
    try {
      queue.element();
      fail("Fail");
    } catch (Exception e) {
      /* Coright */
    }
  }

  @Test
  public void testPool() {
    Queue<Integer> queue = new Queue<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    assertEquals(5, queue.size());
    queue.poll();
    queue.poll();
    queue.poll();
    assertEquals(4, queue.peek().intValue());
    queue.poll();
    queue.poll();
    assertNull(queue.poll());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void testRemove() {
    Queue<Integer> queue = new Queue<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    assertEquals(5, queue.size());
    queue.remove();
    queue.remove();
    queue.remove();
    assertEquals(4, queue.peek().intValue());
    queue.remove();
    queue.remove();
    assertTrue(queue.isEmpty());
    try {
      queue.remove();
      fail("Fail");
    } catch (Exception e) {
      /* Coright */
    }
    assertNull(queue.poll());
  }
}
