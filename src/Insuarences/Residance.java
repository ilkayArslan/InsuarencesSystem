package Insuarences;

import java.util.Date;

public class Residance extends Insuarence{

    public Residance(String name,  Date date) {
        super(name,  date);
    }

    @Override
    public void Calculate() {
        this.setPrice(148.50);
    }
}
