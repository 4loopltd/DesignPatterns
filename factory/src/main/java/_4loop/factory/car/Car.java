package _4loop.factory.car;

public abstract class Car {

    private final CarType model;

    protected CarType getModel() {
        return model;
    }

    public Car(CarType model) {
        this.model = model;
    }

    public abstract void build();

}