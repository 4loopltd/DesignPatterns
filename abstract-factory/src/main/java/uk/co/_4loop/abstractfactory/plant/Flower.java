package uk.co._4loop.abstractfactory.plant;

import java.math.BigDecimal;

public class Flower implements Plant {

    public static final String TYPE = "Flower";

    @Override
    public int getHeight() {
        return 10;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("1.25");
    }

}
