package property;

import java.util.Arrays;

public class ManagementCompany extends Object{
	
	static final int MAX_PROPERTY = 5,MGMT_DEPTH = 10,MGMT_WIDTH = 10;

	private String name, taxID;
	private double mgmFee;
	private Plot plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
	private Property[] properties = new Property[5];
	private int propNum =0;
	
	

	public ManagementCompany() {
		plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
			
		}

	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(x,y, width, depth);
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
	 this.name = otherCompany.getName();
	 this.taxID = otherCompany.getTaxID();
	 this.mgmFee = otherCompany.getMgmFeePer();
	 this.plot = otherCompany.getPlot();
	 this.properties = otherCompany.getProperties();
	 
	}
	public Property[] getProperties() {
		return properties;
	}

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public double getMgmFeePer() {
		return mgmFee;
	}

	public Plot getPlot() {
		return plot;
	}
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name,city,rent,owner);
		  Plot proPlot = property.getPlot();
		    
		    if (isPropertiesFull()) {
		        return -1; 
		    } else if (!plot.encompasses(proPlot)) {
		        return -3; 
		    } else {
		        for (Property i : properties) {
		            if (i != null) {
		                Plot otherPlot = i.getPlot();
		                if (proPlot.overlaps(otherPlot)) {
		                    return -4; 
		                }
		            }
		        }
		        for (int i=0; i< properties.length; i++) {
		            if (properties[i]== null) {
		                properties[i] = property;
		        propNum = i;
		       
		                }
		            } 
		        System.out.print(propNum);
		        return this.propNum;
		        }
		        
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name,city,rent,owner, x,y,width, depth);
		 Plot proPlot = property.getPlot();
		    
		    if (isPropertiesFull()) {
		        return -1; 
		    } else if (!plot.encompasses(proPlot)) {
		        return -3; 
		    } else {
		        for (Property i : properties) {
		            if (i != null) {
		                Plot otherPlot = i.getPlot();
		                if (proPlot.overlaps(otherPlot)) {
		                    return -4; 
		                }
		            }
		        }
		        for (int i=0; i< properties.length; i++) {
		            if (properties[i]== null) {
		                properties[i] = property;
		        propNum = i;
		       
		                }
		            } 
		        return propNum;
		        }
	}
	
	public int addProperty(Property property) {
	    if (property == null) {
	        return -2; 
	    }
	    
	    Plot proPlot = property.getPlot();
	    
	    if (isPropertiesFull()) {
	        return -1; 
	    } else if (!plot.encompasses(proPlot)) {
	        return -3; 
	    } else {
	        for (Property i : properties) {
	            if (i != null) {
	                Plot otherPlot = i.getPlot();
	                if (proPlot.overlaps(otherPlot)) {
	                    return -4; 
	                }
	            }
	        }
	        for (int i=0; i< properties.length; i++) {
	            if (properties[i]== null) {
	                properties[i] = property;
	        propNum = i;
	       
	                }
	            } 
	        return propNum;
	        }
	        
	    }
	

	
	public void removeLastProperty() {
		if(propNum >= 1) {
		properties[propNum] = null;
		propNum--;
		}
	}
	public boolean isPropertiesFull() {
		if (propNum >= MAX_PROPERTY) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getPropertiesCount() {
			return propNum;
		}
	public double getTotalRent() {
		double totalRent=0;
		for (Property i: properties){
			totalRent += i.getRentAmount();
		}
		return totalRent;
	}
	public Property getHighestRentPropperty() {
		double highestRent=0;
		Property highestProp = new Property();
		for (Property i: properties){
			if(i.getRentAmount() > highestRent) {
				highestProp = i;
			}
			
		}
		return highestProp;
	}
	public boolean isMangementFeeValid() {
		
		return (mgmFee >= 0 && mgmFee <= 100)? true: false;
	}

	@Override
	public String toString() {
		return "\"List of the properties for " +  name + ", taxID: " + taxID +
				"\n______________________________________________________\n" + 
					Arrays.toString(properties) +"\n"
			   +"\n______________________________________________________\n"
			   + " total management Fee: " + mgmFee;
	}
}
	/*"List of the properties for Railey, taxID: 555555555\n"
	+ "______________________________________________________\n"
	+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
	+ "______________________________________________________\n"
	+"\n"
	+ " total management Fee: 156.78";
	}
*/
	
	

