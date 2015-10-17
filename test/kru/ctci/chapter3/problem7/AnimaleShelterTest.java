package kru.ctci.chapter3.problem7;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimaleShelterTest {

  @Test
  public void basicTest() {
    AnimaleShelter shelter = new AnimaleShelter();
    shelter.enqueue(new Dog());
    shelter.enqueue(new Dog());
    shelter.enqueue(new Cat());
    shelter.enqueue(new Cat());
    shelter.enqueue(new Cat());
    assertTrue(shelter.dequeueAny().getClass() == Dog.class);
    assertTrue(shelter.dequeue(Cat.class).getClass() == Cat.class);
    assertTrue(shelter.dequeue(Dog.class).getClass() == Dog.class);
    assertTrue(shelter.dequeueAny().getClass() == Cat.class);
    assertTrue(shelter.dequeueAny().getClass() == Cat.class);
    try {
      shelter.dequeueAny();
      fail();
    } catch (Exception e) {
      /* OK */
    }
    shelter.enqueue(new Cat());
    shelter.enqueue(new Dog());
    assertTrue(shelter.dequeueAny().getClass() == Cat.class);
    assertTrue(shelter.dequeueAny().getClass() == Dog.class);
    shelter.enqueue(new Cat());
    shelter.enqueue(new Cat());
    shelter.enqueue(new Dog());
    shelter.enqueue(new Cat());
    shelter.enqueue(new Cat());
    assertTrue(shelter.dequeue(Cat.class).getClass() == Cat.class);
    assertTrue(shelter.dequeue(Dog.class).getClass() == Dog.class);
  }
}
