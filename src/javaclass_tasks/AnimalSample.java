package javaclass_tasks;

abstract class Animal {
    private String color;
    private float weight;

    Animal(String color, float weight){
        this.color = color;
        this.weight = weight;
    }

    abstract void eat();
}

class Cat extends Animal{
    Cat(String color, float weight) {
        super(color, weight);
    }

    void eat(){
        System.out.println("javaclass_tasks.Cat eats cat food");
    }
}

class Dog extends Animal{
    Dog(String color, float weight) {
        super(color, weight);
    }

    void eat(){
        System.out.println("javaclass_tasks.Dog eats dog food");
    }
}

public class AnimalSample{
    public static void main(String[] args) {
        Animal cat = new Cat("orange", 5.5f);
        Animal dog = new Dog("brown", 30f);

        cat.eat();
        dog.eat();
    }
}