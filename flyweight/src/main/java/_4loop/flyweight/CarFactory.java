package _4loop.flyweight;

import _4loop.flyweight.car.*;

import java.util.HashMap;

public class CarFactory {

    private static final HashMap<CarType, Car> cars = new HashMap<>();

    public static Car create(CarType model) {
        Car car = cars.get(model);
        if (car != null) {
            return car;
        }

        switch (model) {
            case COMPACT:
                car = new CompactCar();
                break;
            case FAMILY:
                car = new FamilyCar();
                break;
            case SPORTS:
                car = new SportsCar();
                break;
            default:
                break;
        }

        cars.put(model, car);

        return car;
    }

}
