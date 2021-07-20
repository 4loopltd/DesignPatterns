package _4loop.prototype;

public class Animal implements Prototype {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public Prototype duplicate() {
        return new Animal(name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
