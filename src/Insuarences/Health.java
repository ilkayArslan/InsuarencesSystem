package Insuarences;

import java.util.Date;

public class Health extends Insuarence{

    public Health(String name, Date date) {
        super(name,  date);
    }

    @Override
    public void Calculate() {
        this.setPrice(125.00);
    }
}
