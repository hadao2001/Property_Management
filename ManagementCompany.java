/** 
*
* @author Ha Dao
* This class holds list of properties in array structure and contains different methods 
*/

public class ManagementCompany {
	private String propertyName;    //store property name
	private String companyName;     //store company name
	private String taxID;   //stores tax ID
	private double mgmFee;   //stores management fee
	private final int MAX_PROPERTY = 5;   //stores maximum number of properties allowed
	private Property[] p;    //array to store property details
	private final int MGMT_WIDTH = 10 ;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int count = 0;

	
   /**
    * Constructor Creates a ManagementCompany object using the passed informations. "properties" array is initialized here as well.
	* @param companyName  company name
	* @param Id tax ID 
	* *@param mgmFee management fee 
	*/		
	public ManagementCompany(String companyName, String taxID, double mgmFee) {
		this.companyName = companyName;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.p =  new Property[MAX_PROPERTY];
	}

	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty strings and a default Plot.
	 *  "properties" array is initialized here as well.
	 */
	public ManagementCompany() {
		this.companyName = "";
		this.taxID = "";
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.p = new Property[MAX_PROPERTY];
	}
	
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed informations. "properties" array is initialized here as well.
	 * @param companyName the name of company	
	 * @param taxID the taxID
	 * @param mgmFee the management fee	
	 * @param x the x-value of the area company owns
	 * @param y the y-value of the area company owns
	 * @param width the width value of the area company owns
	 * @param depth the depth value of the area company owns
	 */
	public ManagementCompany(String companyName, String taxID, double mgmFee, int x, int y,
			int width, int depth) {
		this.companyName = companyName;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x,y,MGMT_WIDTH,MGMT_DEPTH);
		this.p = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. 
	 * "properties" array is initialized here as well.
	 * @param otherCompany another management company
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.companyName = otherCompany.companyName;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.p = new Property[MAX_PROPERTY];
		this.plot = new Plot(otherCompany.plot);
	}
	
	/**
	 * Return the max number of properties 
	 * @return the MAX_PROPERTY
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}

	/**
	 * return the default plot of the company
	 * @return the plot
	 */
	public Plot getPlot() 
	{

		return plot;
	}

	/**
	 * Return the name of the company
	 * @return the name of company
	 */
	public String getName() 
	{		
		return propertyName;
	}

	
	/**
	 * Adds the property object to the "properties" array.
	 * @param property a property object
	 * @return Returns either -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {
		int reValue;
		boolean ifOverlap = false;
		
		for(int i=0;i<MAX_PROPERTY;i++) {
			if(property != null && p[i] !=null) {
				if(p[i].getPlot().overlaps(property.getPlot())) {
					ifOverlap = true;
				}
			}
		}
		
		if(p[MAX_PROPERTY-1] != null) {
			reValue = -1;
		}
		
		else if(property == null) {
			reValue = -2;
		}
		
		else if(!plot.encompasses(property.getPlot())) {
			reValue = -3;
		}
		
		else if(ifOverlap) {
			reValue = -4;
		}
		else {
			p[count] = new Property(property);
			reValue = count;
			count++;
		}
		
		return reValue;
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param propertyName the property name
	 * @param city the location of property
	 * @param rent monthly rent
	 * @param owner the owner of property
	 * @return Returns either -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(String propertyName, String city,double rent, String owner) {
		int reValue;
		boolean ifOverlap = false;
		
		Property property = new Property(propertyName, city, rent, owner);
		property.setPlot(new Plot());
		
		for(int i=0;i<MAX_PROPERTY;i++) {
			if(property != null && p[i] !=null) {
				if(p[i].getPlot().overlaps(property.getPlot())) {
					ifOverlap = true;
				}
			}
		}
		
		if(p[MAX_PROPERTY-1] != null) {
			reValue = -1;
		}
		
		else if(!plot.encompasses(property.getPlot())) {
			reValue = -3;
		}
		
		else if(ifOverlap) {
			reValue = -4;
		}
		else {
			p[count] = new Property(property);
			reValue = count;
			count++;
		}
		
		
		return reValue;
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param propertyName the property name
	 * @param city the location of the property
	 * @param rent monthly rent
	 * @param owner owner of property
	 * @param x x location of upper left corner of property's plot
	 * @param y y location of upper left corner of property's plot
	 * @param width width of the property's plot
	 * @param depth depth of the property's plot
	 * @return Returns either -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(String propertyName, String city, double rent, String owner, int x, int y,
			int width, int depth) {
		int reValue;
		boolean ifOverlap = false;
		
		Property property = new Property(propertyName,city,rent,owner,x,y,width,depth);
		
		
		for(int i=0;i<MAX_PROPERTY;i++) {
			if(property != null && p[i] !=null) {
				if(p[i].getPlot().overlaps(property.getPlot())) {
					ifOverlap = true;
				}
			}
		}
		
		if(p[MAX_PROPERTY-1] != null) {
			reValue = -1;
		}
		
		else if(!plot.encompasses(property.getPlot())) {
			reValue = -3;
		}
		
		else if(ifOverlap) {
			reValue = -4;
		}
		else {
			p[count] = new Property(property);
			reValue = count;
			count++;
		}
		
		return reValue;
	}

	

	/**
	 * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
	 * @return total rent
	 */
	public double totalRent() {
		double totalRent = 0;
		for(int i=0;i<MAX_PROPERTY;i++) {
			if(p[i] != null) {
				totalRent += p[i].getRentAmount(); 
			}
		}
		return totalRent;
	}

/**
 * This method finds the property with the maximum rent amount. 
 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
 * @return the string displays information of the property has highest rent amount
 */
public String maxRentPropInfo() {
	int i=0;
	for(int h=1;h<MAX_PROPERTY;h++) {
		if(p[h] != null) {
			if(p[h].getRentAmount() > p[i].getRentAmount()) {
				i=h;
			}
		}
	}
	return displayPropertyAtIndex(i);
}

/**
 * Displays the information of the property at index i
 * @param i The index of the property within the array "properties"
 * @return  information of the property at index i
 */
public String displayPropertyAtIndex(int i) {
	String result="";
	if(p[i] != null) {
		result = p[i].toString();
	}

	return result;
}

/**
 * This method calculate the total management fee
 * @return fee
 */

private double calculateTotalFee()

{

    double fee=0;

    for(int n=0;n<MAX_PROPERTY;n++)

    {

        fee+=mgmFee*p[n].getRentAmount()/100;

    }

    return fee;

}

/**
 * Displays the information of all the properties in the "properties" array.tP
 * @return The format is as following example:
List of the properties for Alliance, taxID: 1235
______________________________________________________
Property Name: Belmar
  Located in Silver Spring
  Belonging to: John Smith
  Rent Amount: 1200.0
Property Name: Camden Lakeway
  Located in Rockville
  Belonging to: Ann Taylor
  Rent Amount: 5000.0
Property Name: Hamptons
  Located in Rockville
  Belonging to: Rick Steves
  Rent Amount: 1250.0
______________________________________________________
total management Fee: 687.0
 */

public String toString() {
	System.out.println("----------------------------------------------------------");
	String showList="List of properties for " + companyName+ ", taxID " + taxID + ", " + mgmFee + "\n" ; 
	
	for(int n=0;n<MAX_PROPERTY;n++) {
		if(p[n] != null) {
			showList += p[n].toString();
		}
		
	}
	System.out.println("----------------------------------------------------------");
	System.out.println("Total management fee collected is " +calculateTotalFee()+"\n");
	return showList;
    }
}

