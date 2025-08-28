package _4loop.visitor;

import _4loop.visitor.parts.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitorTest {

    static class CountingVisitor implements Visitor {
        AtomicInteger count = new AtomicInteger();
        public void visit(Frame frame) { count.incrementAndGet(); }
        public void visit(Engine engine) { count.incrementAndGet(); }
        public void visit(Body body) { count.incrementAndGet(); }
        public void visit(Wheels wheels) { count.incrementAndGet(); }
    }

    @Test
    void car_acceptsVisitorForAllParts() {
        Car car = new Car();
        car.add(new Frame());
        car.add(new Engine());
        car.add(new Body());
        car.add(new Wheels());

        CountingVisitor visitor = new CountingVisitor();
        car.accept(visitor);

        assertEquals(4, visitor.count.get());
    }
}
