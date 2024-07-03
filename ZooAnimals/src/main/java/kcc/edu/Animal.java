package kcc.edu;

import java.io.*;

//I accidentally deleted this file trying to move it to a new window...
//By putting it on my desktop and deleting it instead of opening a new window lol...
//Silly move by me -10 brain power...
//Also, I added special notes for some of the animals if you are a DC fan you may know who they are :D.
class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;

    private String name;

    private int age;

    private String gender;

    private int weight;

    public Animal(String type, String name, int age, String gender, int weight) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
    }

    public String toString() {
        return "Animal [type=" + type + ", name=" + name + ", age=" + age + ", gender=" + gender + ", weight=" + weight + "]";
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal lion = new Animal("lion","Saint", 2,"male",210);
        Animal Lion = new Animal("lion","Eve",2,"female",200);
        Animal penguin = new Animal("penguin","Happy", 8,"male",13);
        Animal Penguin = new Animal("penguin","Gloria", 9,"female",11);
        Animal chameleon = new Animal("chameleon","Rango", 3,"male",1);
        Animal monkey = new Animal("monkey","penelope", 12,"female",22);
        Animal Monkey = new Animal("monkey","philip", 14,"female",25);
        //These next animals are never meant to be seen by the public please do not disclose these.
        Animal Gorilla = new Animal("gorilla","Grodd", 2,"male",400);//Warning super intelligent been known to use telepathic abilities and mind control watch out!!!!
        Animal Starfish = new Animal("starfish","Starro", 10000,"unknown",2000000);//Warning shoots starfish spores that latch onto people and controls minds do not become one of its hosts!!!
        Animal dog = new Animal("dog","Krypto", 2,"male",62);//After superman's passing we were given Krypto to help protect our secret facility. Also, he's a good boy.




        zoo.serilizeAnimalsToFile("zoo_animals.ser");

        zoo.deserilizeAnimalsFromFile("zoo_animals.ser");

        zoo.addAnimal(lion);
        zoo.addAnimal(Lion);
        zoo.addAnimal(penguin);
        zoo.addAnimal(Penguin);
        zoo.addAnimal(chameleon);
        zoo.addAnimal(monkey);
        zoo.addAnimal(Monkey);
        zoo.addAnimal(Gorilla);
        zoo.addAnimal(Starfish);
        zoo.addAnimal(dog);

        zoo.printAnimals();
    }
}

