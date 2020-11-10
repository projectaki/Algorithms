package StacksAndQueues;

import java.util.LinkedList;

/**
 * Get the oldest Animal (Cat or dog) from the shelter, or get the oldest of a chosen type
 * COMPLEXITY NOT GOOD HERE, but using only 1 queue
 */
public class AnimalShelter1 {

    private static class Animal {
        private String info;
        private String animalType;
    }

    LinkedList<Animal> listOfAnimals = new LinkedList<>();


    public void enqueue(Animal animal) {
        listOfAnimals.add(animal);
    }

    public Animal dequeueAny() {
        return listOfAnimals.removeLast();
    }

    public void dequeueDog() {
        Animal temp = new Animal();
        for (Animal x : listOfAnimals) {
            if (x.animalType.equals("dog")) {
                temp = x;
            }
        }
        listOfAnimals.remove(temp);
    }

    public void dequeueCat() {
        Animal temp = new Animal();
        for (Animal x : listOfAnimals) {
            if (x.animalType.equals("cat")) {
                temp = x;
            }
        }
        listOfAnimals.remove(temp);
    }

    public static void main(String[] args) {
        AnimalShelter1 program = new AnimalShelter1();
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

        program.enqueue(cat1);
        program.enqueue(dog1);
        program.enqueue(dog2);
        program.enqueue(dog3);
        program.enqueue(cat2);
        for (Animal x : program.listOfAnimals) {
            System.out.print(x.info + ", ");

        }
        System.out.println();
        program.dequeueDog();
        program.dequeueAny();
        program.dequeueDog();
        program.dequeueCat();
        program.dequeueCat();
        for (Animal x : program.listOfAnimals) {
            System.out.print(x.info + ", ");

        }
    }





}
