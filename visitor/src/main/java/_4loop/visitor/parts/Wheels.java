package _4loop.visitor.parts;

import _4loop.visitor.Visitor;

public class Wheels implements Part {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
