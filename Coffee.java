package Beveragefiles;

public class Coffee extends Beverage {
    boolean extraShot, extraSyrup;
    
    public Coffee(String bevName, Size size, boolean extraShot, Boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        price += (extraShot ? 0.5 : 0);
        price += (extraSyrup ? 0.5 : 0);
        return price;
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Coffee coffee = (Coffee) anotherBev;
        return extraShot == coffee.extraShot &&
               extraSyrup == coffee.extraSyrup &&
               size == coffee.size &&
               bevName.equals(coffee.bevName);
    }

    @Override
    public String toString() {
        return bevName + ", " + size + ", " + calcPrice() + ", " + extraShot + ", " + extraSyrup;
    }
}
