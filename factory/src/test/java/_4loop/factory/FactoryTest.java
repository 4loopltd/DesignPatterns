package _4loop.factory;

import _4loop.factory.car.Car;
import _4loop.factory.car.CarType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    @Test
    void create_returnsCorrectTypes() {
        Car sports = CarFactory.create(CarType.SPORTS);
        Car family = CarFactory.create(CarType.FAMILY);
        Car compact = CarFactory.create(CarType.COMPACT);
        Car fourByFour = CarFactory.create(CarType.FOUR_X_FOUR);
        assertAll(
                () -> assertNotNull(sports),
                () -> assertNotNull(family),
                () -> assertNotNull(compact),
                () -> assertNotNull(fourByFour)
        );
    }
}
