package _4loop.prototype;

public class Mineral implements Prototype {

    private final String name;

    public Mineral(String name) {
        this.name = name;
    }

    @Override
    public Prototype duplicate() {
        return new Mineral(name);
    }

    @Override
    public String toString() {
        return "Mineral{" +
                "name='" + name + '\'' +
                '}';
    }
}
