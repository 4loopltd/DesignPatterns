package _4loop.template;

public class FamilyCarBuilder extends CarTemplate {

    @Override
    protected void addFrame() {
        parts.add("Steal frame");
    }

    @Override
    protected void addEngine() {
        parts.add("Economical engine");
    }

    @Override
    protected void addBody() {
        parts.add("Brick shaped body");
    }

    @Override
    protected void addWheels() {
        parts.add("All weather types");
    }
}
