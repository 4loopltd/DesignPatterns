package uk.co._4loop.abstractfactory.layout;

import java.math.BigDecimal;

public class Rock implements Layout {

    public static final String TYPE = "Rock";

    @Override
    public int getLength() {
        return 5;
    }

    @Override
    public int getWidth() {
        return 5;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("200.0");
    }
}
