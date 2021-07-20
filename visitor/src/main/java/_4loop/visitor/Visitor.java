package _4loop.visitor;

import _4loop.visitor.parts.Body;
import _4loop.visitor.parts.Engine;
import _4loop.visitor.parts.Frame;
import _4loop.visitor.parts.Wheels;

public interface Visitor {
    void visit(Frame frame);

    void visit(Engine engine);

    void visit(Body body);

    void visit(Wheels wheels);
}
