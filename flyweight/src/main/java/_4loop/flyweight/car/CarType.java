package _4loop.flyweight.car;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CarType {

    COMPACT("compact"),
    FAMILY("family"),
    SPORTS("sports");

    private final String name;

    @Override
    public String toString() {
        return name;
    }

}
