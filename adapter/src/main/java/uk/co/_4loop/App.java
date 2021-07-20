package uk.co._4loop;

import uk.co._4loop.adapter.Bicycle;
import uk.co._4loop.adapter.Cyclist;
import uk.co._4loop.adapter.MotorbikeAdapter;

public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        var cyclist = new Cyclist(new Bicycle());
        cyclist.peddle();

        var biker = new Cyclist(new MotorbikeAdapter());
        biker.peddle();
    }
}
