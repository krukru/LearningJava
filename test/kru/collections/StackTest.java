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

public class StackTest extends AbstractListTest {

  @Override
  protected List<String> createList() {
    return new Stack<>();
  }

  @Test
  public void testPush() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.push(2);
    stack.add(3);
    stack.push(4);
    stack.push(5);
    assertEquals(5, stack.size());
    assertEquals(1, stack.get(0).intValue());
    assertEquals(2, stack.get(1).intValue());
    assertEquals(3, stack.get(2).intValue());
    assertEquals(4, stack.get(3).intValue());
    assertEquals(5, stack.get(4).intValue());
  }

  @Test
  public void testPop() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    stack.add(5);
    assertEquals(5, stack.size());
    assertEquals(5, stack.pop().intValue());
    assertEquals(4, stack.size());
    assertEquals(4, stack.pop().intValue());
    assertEquals(3, stack.size());
    assertEquals(3, stack.pop().intValue());
    assertEquals(2, stack.size());
    assertEquals(2, stack.pop().intValue());
    assertEquals(1, stack.size());
    assertEquals(1, stack.pop().intValue());
    assertEquals(0, stack.size());
  }

  @Test
  public void testPeek() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    stack.add(5);
    assertEquals(5, stack.size());

    assertEquals(5, stack.peek().intValue());
    assertEquals(5, stack.size());

    assertEquals(5, stack.peek().intValue());
    assertEquals(5, stack.size());
    stack.pop();

    assertEquals(4, stack.peek().intValue());
    assertEquals(4, stack.size());
  }
}
