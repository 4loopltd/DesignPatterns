package uk.co._4loop.abstractfactory.plant;

import java.math.BigDecimal;

public class Shrub implements Plant {

    public static final String TYPE = "Shrub";

    @Override
    public int getHeight() {
        return 20;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("2.50");
    }

}
