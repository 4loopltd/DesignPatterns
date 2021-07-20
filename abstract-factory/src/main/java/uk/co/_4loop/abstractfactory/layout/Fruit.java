package uk.co._4loop.abstractfactory.layout;

import java.math.BigDecimal;

public class Fruit implements Layout {

    public static final String TYPE = "Fruit";

    @Override
    public int getLength() {
        return 50;
    }

    @Override
    public int getWidth() {
        return 25;
    }


    @Override
    public BigDecimal getCost() {
        return new BigDecimal("400.0");
    }

}
