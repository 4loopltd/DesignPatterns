package _4loop.facade;

import _4loop.facade.engine.AirIntake;
import _4loop.facade.engine.FuelInjector;
import _4loop.facade.engine.Ignition;
import _4loop.facade.engine.Starter;

public class EngineFacade {

    private final Ignition ignition = new Ignition();
    private final Starter starter = new Starter();
    private final AirIntake airIntake = new AirIntake();
    private final FuelInjector fuelInjector = new FuelInjector();

    public void start() {
        ignition.accessory();
        ignition.on();
        airIntake.open();
        fuelInjector.open();
        ignition.start();
        starter.turnOver();
    }

    public void stop() {
        ignition.off();
        fuelInjector.close();
        airIntake.close();
        ignition.lock();
    }
}
