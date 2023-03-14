package Insuarences;

import java.util.Date;

public class Car extends Insuarence{
    public Car(String name, Date date) {
        super(name, date);
    }

    @Override
    public void Calculate() {
        this.setPrice(225.00);
    }
}
