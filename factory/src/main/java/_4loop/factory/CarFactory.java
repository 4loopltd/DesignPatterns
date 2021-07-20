package _4loop.factory;

import _4loop.factory.car.*;

public class CarFactory {

    public static Car create(CarType model) {
        Car car = null;
        switch (model) {
            case COMPACT:
                car = new CompactCar();
                break;
            case FAMILY:
                car = new FamilyCar();
                break;
            case FOUR_X_FOUR:
                car = new FourXFourCar();
                break;
            case SPORTS:
                car = new SportsCar();
                break;
            default:
                break;
        }
        return car;
    }

}
