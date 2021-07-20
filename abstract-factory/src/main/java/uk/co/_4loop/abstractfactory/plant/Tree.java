package uk.co._4loop.abstractfactory.plant;

import java.math.BigDecimal;

public class Tree implements Plant {

    public static final String TYPE = "Tree";

    @Override
    public int getHeight() {
        return 500;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("5.0");
    }

}
