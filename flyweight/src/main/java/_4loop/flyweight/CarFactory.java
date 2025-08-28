package _4loop.flyweight;

import _4loop.flyweight.car.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarFactory {

    private static final Map<CarType, Car> cars = new ConcurrentHashMap<>();

    public static Car create(CarType model) {
        // Use computeIfAbsent for a thread-safe, atomic "get-or-create" operation.
        // The lambda (k -> ...) is only executed if the key is not already present.
        return cars.computeIfAbsent(model, k -> {
            switch (k) {
                case COMPACT:
                    return new CompactCar();
                case FAMILY:
                    return new FamilyCar();
                case SPORTS:
                    return new SportsCar();
                default:
                    throw new IllegalArgumentException("Unknown car type: " + k);
            }
        });
    }
}
