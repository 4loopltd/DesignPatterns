package uk.co._4loop.adapter;

public class MotorbikeAdapter implements Bike {

    final MotorVehicle motorbike = new Motorbike();

    @Override
    public void peddle() {
        motorbike.drive();
    }

}
