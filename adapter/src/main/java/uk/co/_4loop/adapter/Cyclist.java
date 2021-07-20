package uk.co._4loop.adapter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {

    private Bike bike;

    public void peddle() {
        bike.peddle();
    }
}
