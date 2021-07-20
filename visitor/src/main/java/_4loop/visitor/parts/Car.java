package _4loop.visitor.parts;

import _4loop.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Car implements Part {

    final List<Part> parts = new ArrayList<>();

    public void add(Part part) {
        parts.add(part);
    }

    @Override
    public void accept(Visitor visitor) {
        for (Part part : parts) {
            part.accept(visitor);
        }
    }
}
