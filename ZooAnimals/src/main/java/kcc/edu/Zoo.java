package kcc.edu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void serilizeAnimalsToFile(String AnimalsList) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AnimalsList))) {
            oos.writeObject(animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserilizeAnimalsFromFile(String AnimalsList) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(AnimalsList))) {
            animals = (List<Animal>) ois.readObject();

        }  catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void printAnimals() {
        animals.forEach(System.out::println);
    }

    }
