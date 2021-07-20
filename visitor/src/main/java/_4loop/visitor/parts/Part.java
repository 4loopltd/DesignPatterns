package _4loop.visitor.parts;

import _4loop.visitor.Visitor;

public interface Part {
    void accept(Visitor visitor);
}
