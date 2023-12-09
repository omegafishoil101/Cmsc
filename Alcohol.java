package Beveragefiles;

public class Alcohol extends Beverage {
    private boolean isWeekend;
    
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        price += (isWeekend ? 0.6 : 0);
        return price;
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Alcohol alcohol = (Alcohol) anotherBev;
        return isWeekend == alcohol.isWeekend &&
               size == alcohol.size &&
               bevName.equals(alcohol.bevName);
    }

    @Override
    public String toString() {
        return bevName + ", " + size + ", " + calcPrice() + ", " + isWeekend;
    }
}
