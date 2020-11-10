package StacksAndQueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * ANIMAL SHELTER IMPLEMENTATION
 */
public class AnimalShelter2 {

    /**
     * Class for animal
     */
        private static class Animal {
            private String info;
            private String animalType;
            private int timeId;
        }

    private final LinkedList<Animal> listOfDogs = new LinkedList<>();
    private final LinkedList<Animal> listOfCats = new LinkedList<>();
    private int timeId = 0;

    /**
     * Enqueue, if animal is dog add to dog queue otherwise to cat queue
     * @param animal Animal to add to shelter
     */
    public void enqueue(Animal animal) {
        if (animal.animalType.equals("cat")) {
            animal.timeId = timeId++;
            listOfCats.addFirst(animal);
        }
        else if (animal.animalType.equals("dog")) {
            animal.timeId = timeId++;
            listOfDogs.addFirst(animal);
        }
    }

    /**
     * Return the oldest animal at the shelter
     * @return Returns the oldest animal
     */
    public Animal dequeueAny() {
        if (listOfDogs.isEmpty() && listOfCats.isEmpty()) throw new NoSuchElementException("Empty queue");
        int catTime = listOfCats.peekLast() != null ? listOfCats.peekLast().timeId : Integer.MAX_VALUE;
        int dogTime = listOfDogs.peekLast() != null ? listOfDogs.peekLast().timeId : Integer.MAX_VALUE;
        return catTime < dogTime ? listOfCats.removeLast() : listOfDogs.removeLast();
    }

    /**
     * Returns the oldest dog at the shelter
     * @return Return oldest dog
     */
    public Animal dequeueDog() {
        return listOfDogs.removeLast();
    }

    /**
     * Returns oldest cat at the shelter
     * @return Returns oldest cat
     */
    public Animal dequeueCat() {
        return listOfCats.removeLast();
    }

    public static void main(String[] args) {
        AnimalShelter2 a = new AnimalShelter2();

        Animal cat1 = new Animal();
        cat1.animalType = "cat";
        cat1.info = "cat1";
        Animal cat2 = new Animal();
        cat2.animalType = "cat";
        cat2.info = "cat2";
        Animal dog1 = new Animal();
        dog1.animalType = "dog";
        dog1.info = "dog1";
        Animal dog2 = new Animal();
        dog2.animalType = "dog";
        dog2.info = "dog2";
        Animal dog3 = new Animal();
        dog3.animalType = "dog";
        dog3.info = "dog3";

        a.enqueue(cat1);
        a.enqueue(dog1);
        a.enqueue(dog2);
        a.enqueue(dog3);
        a.enqueue(cat2);
        for (Animal x : a.listOfDogs) {
            System.out.print(x.info + ", ");
        }
        System.out.println();
        for (Animal x : a.listOfCats) {
            System.out.print(x.info + ", ");
        }
        System.out.println();
        a.dequeueAny();
        a.dequeueAny();

        for (Animal x : a.listOfDogs) {
            System.out.print(x.info + ", ");
        }
        System.out.println();
        for (Animal x : a.listOfCats) {
            System.out.print(x.info + ", ");
        }
    }





}
