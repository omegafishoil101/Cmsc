package property;

public class Property extends Object {
private String propertyName, city, owner;
private double rentAmount;
private Plot plot;

public Property() {
	plot = new Plot();
}

public Property(String propertyName, String city, double rentAmount, String owner) {
	this.propertyName = propertyName;
	this.city = city;
	this.owner = owner;
	this.rentAmount = rentAmount;
	plot = new Plot(0,0,1,1);
}
public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
	this.propertyName = propertyName;
	this.city = city;
	this.owner = owner;
	this.rentAmount = rentAmount;
	plot = new Plot(x,y,width,depth);
}

public Property(Property otherProperty) {
	this.propertyName = otherProperty.propertyName;
	this.city = otherProperty.city;
	this.owner = otherProperty.owner;
	this.rentAmount = otherProperty.rentAmount;
	plot = otherProperty.plot;
}
public String getPropertyName() {
	return propertyName;
}

public String getCity() {
	return city;
}

public String getOwner() {
	return owner;
}

public double getRentAmount() {
	return rentAmount;
}

public Plot getPlot() {
	return plot;
}

@Override
public String toString() {
	return propertyName + "," + city + "," + owner + ","
			+ rentAmount;
}


}
