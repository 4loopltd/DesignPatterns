package _4loop.template;

public class SportsCarBuilder extends CarTemplate {

    @Override
    protected void addFrame() {
        parts.add("Lightweight frame");
    }

    @Override
    protected void addEngine() {
        parts.add("High performance engine");
    }

    @Override
    protected void addBody() {
        parts.add("Aerodynamic body");
    }

    @Override
    protected void addWheels() {
        parts.add("Low profile types");
    }
}
