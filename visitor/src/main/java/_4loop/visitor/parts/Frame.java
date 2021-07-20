package _4loop.visitor.parts;

import _4loop.visitor.Visitor;

public class Frame implements Part {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
