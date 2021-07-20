package _4loop.factory.car;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CarType {

    COMPACT("compact"),
    FAMILY("family"),
    FOUR_X_FOUR("4x4"),
    SPORTS("sports");

    private final String name;

    @Override
    public String toString() {
        return name;
    }

}
