package Beveragefiles;

import java.util.Objects;

public abstract class Beverage extends Object{
	String bevName;
	Type type;
	Size size;
	private final double BASE_PRICE = 2.0, SIZE_PRICE = 1;
	
	Beverage(String bevName, Type type, Size size){
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	public double getBasePrice() {
	return BASE_PRICE;
}
		
	public String getBevName() {
		return bevName;
	}
	public void setBevName(String bevName) {
		this.bevName = bevName;
	}
	public Type getType() {
		return type;
	}
	public Size getSize() {
		return size;
	}
	
	public double addSizePrice() {
		if(size == Size.LARGE) {
		return (2*SIZE_PRICE);
		}else if(size == Size.MEDIUM) {
			return SIZE_PRICE;
		}else {
			return 0;
		}
	}
	public double calcPrice() {
		return addSizePrice() + BASE_PRICE;
	}
	@Override
	public boolean equals(Object anotherBev) {
	    if (this == anotherBev) return true;
	    if (anotherBev== null || getClass() != anotherBev.getClass()) return false;
	    Beverage other = (Beverage) anotherBev;
	    return Objects.equals(bevName, other.bevName) &&
	           type == other.type &&
	           size == other.size;
	}

	@Override
	public String toString() {
		return bevName + ", " + size;
	}
}
