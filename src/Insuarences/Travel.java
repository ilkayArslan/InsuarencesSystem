package Insuarences;

import java.util.Date;

public class Travel extends Insuarence{
    public Travel(String name,  Date date) {
        super(name,  date);
    }

    @Override
    public void Calculate() {
        this.setPrice(75.80);
    }
}
