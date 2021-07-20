package _4loop.visitor;

import _4loop.visitor.parts.Body;
import _4loop.visitor.parts.Engine;
import _4loop.visitor.parts.Frame;
import _4loop.visitor.parts.Wheels;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintVisitor implements Visitor {
    @Override
    public void visit(Frame frame) {
        log.info("Frame");
    }

    @Override
    public void visit(Engine engine) {
        log.info("Engine");
    }

    @Override
    public void visit(Body body) {
        log.info("Body");
    }

    @Override
    public void visit(Wheels wheels) {
        log.info("Wheels");
    }
}
