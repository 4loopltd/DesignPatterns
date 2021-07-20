package uk.co._4loop.abstractfactory.layout;

import java.math.BigDecimal;

public class Rose implements Layout {

    public static final String TYPE = "Rose";

    @Override
    public int getLength() {
        return 20;
    }

    @Override
    public int getWidth() {
        return 20;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("100.0");
    }
}
