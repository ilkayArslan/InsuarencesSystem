package Insuarences;

import java.util.Date;

public class Insuarence {
    private String name;
    private double price;
    private Date date;

    public Insuarence(String name,  Date date) {
        this.name = name;
        this.date = date;
        this.Calculate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public  void  Calculate(){

    }
}
