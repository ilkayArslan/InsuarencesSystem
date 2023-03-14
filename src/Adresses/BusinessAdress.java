package Adresses;

public class BusinessAdress implements IAdress{
    private String business;
    private boolean isHome;

    @Override
    public String gettheadress() {
        return this.business;
    }

    public BusinessAdress(String business) {
        this.business = business;
        this.isHome = false;
    }

    @Override
    public void settheadreses(String adress) {
        this.business = adress;
    }

    @Override
    public boolean isHome() {
        return isHome;
    }
}
