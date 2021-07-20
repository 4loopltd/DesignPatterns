package _4loop.prototype;

public class Vegetable implements Prototype {

    private final String name;

    public Vegetable(String name) {
        this.name = name;
    }

    @Override
    public Prototype duplicate() {
        return new Vegetable(name);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name + '\'' +
                '}';
    }
}
