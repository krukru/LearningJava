package kru.ctci.chapter3.problem7;

import kru.collections.LinkedList;
import kru.exception.runtimexception.NotImplementedException;

public class AnimaleShelter {

  private LinkedList<ArrivalTimestamp> dogShelter = new LinkedList<>();
  private LinkedList<ArrivalTimestamp> catShelter = new LinkedList<>();
  private int currentTimestamp = 0;

  public <E extends Animal> void enqueue(E animal) {
    ArrivalTimestamp at = new ArrivalTimestamp(animal, currentTimestamp);
    if (animal instanceof Dog) {
      dogShelter.addFirst(at);
    } else if (animal instanceof Cat) {
      catShelter.addFirst(at);
    } else {
      throw new NotImplementedException();
    }
  }

  public Animal dequeueAny() {
    Animal result;
    if (dogShelter.size() == 0) {
      result = dogShelter.getFirst().animal;
      dogShelter.removeFirst();
    } else if (catShelter.size() == 0) {
      result = catShelter.getFirst().animal;
      catShelter.removeFirst();
    } else {
      ArrivalTimestamp dogArrival = dogShelter.getFirst();
      ArrivalTimestamp catArrival = catShelter.getFirst();
      if (dogArrival.timestamp < catArrival.timestamp) {
        result = dogArrival.animal;
        dogShelter.removeFirst();
      } else {
        result = catArrival.animal;
        catShelter.removeFirst();
      }
    }
    return result;
  }

  public <E extends Animal> Animal dequeue(Class<E> animalType) {
    Animal result;
    if (animalType == Dog.class) {
      result = dogShelter.getFirst().animal;
      dogShelter.removeFirst();
    } else if (animalType == Cat.class) {
      result = catShelter.getFirst().animal;
      catShelter.removeFirst();
    } else {
      throw new NotImplementedException();
    }
    return result;
  }

  private class ArrivalTimestamp {
    public Animal animal;
    public int timestamp;

    public ArrivalTimestamp(Animal animal, int timestamp) {
      this.animal = animal;
      this.timestamp = timestamp;
      currentTimestamp += 1;
    }
  }
}
