class Animal {
    String color;
    float weight;

    void eat(){
        System.out.println("Animal eats food");
    }
}

class Cat extends Animal{
    void eat(){
        System.out.println("Cat eats cat food");
    }
}

class Dog extends Animal{
    void eat(){
        System.out.println("Dog eats dog food");
    }
}

public class AnimalSample{
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.eat();
        dog.eat();
    }
}