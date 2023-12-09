package Beveragefiles;

public class Smoothie extends Beverage {
    private boolean addProtein;
    private int numOfFruits;
    
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    public boolean getAddProtein() {
        return addProtein;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        price += (addProtein ? 1.5 : 0);
        price += numOfFruits * 0.5;
        return price;
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Smoothie smoothie = (Smoothie) anotherBev;
        return addProtein == smoothie.addProtein &&
               numOfFruits == smoothie.numOfFruits &&
               size == smoothie.size &&
               bevName.equals(smoothie.bevName);
    }

    @Override
    public String toString() {
        return bevName + ", " + size + ", " + calcPrice() + ", " + numOfFruits + ", " + addProtein;
    }
}
