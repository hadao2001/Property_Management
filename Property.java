/** *
* @author Ha Dao
* This class holds and sets property details 
*/


public class Property {

   private String propertyName, city, owner;
   private double rentAmount;
   private  Plot plot;

   
   /**
    * 
    * @param propertyName    name of property
    * @param city            name of city
    * @param owner           name of owner
    * @param rentAmount      rent amount
    */
   public Property(String propertyName, String city, double rentAmount, String owner) {
	   this.propertyName = propertyName; 
	   this.city = city;
	   this.owner = owner; 
	   this.rentAmount = rentAmount;
	   this.plot  = new Plot();
}
   
   /**
	 * No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot
	 */
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.rentAmount = 0;
		this.plot = new Plot();
	}

   

	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param property a Property object
	 */
	public Property(Property property) {
		this.propertyName = property.propertyName;
		this.city = property.city;
		this.rentAmount = property.rentAmount;
		this.owner = property.owner;
		this.plot = new Plot(property.plot);
	}

   /**
	 * Constructor, Parameterized constructor
	 * @param propertyName property name
	 * @param city city where property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth  the vertical size of the property's plot
	 */
	public Property(String propertyName , String city, double rentAmount, String owner, int x, int y,
		 int width, int depth) {
	 	this.propertyName = propertyName;
	 	this.city = city;
	 	this.rentAmount = rentAmount;
	 	this.owner = owner;
	 	this.plot = new Plot(x,y,width,depth);
	}	
   
   /**
    * @return the city
    */
    public String getCity() {
        return city;
    }

    /**
    * @param city
    * the city to set
    */
    public void setCity(String city) {
        this.city = city;
    }

    /**
    * @return the owner
    */
    public String getOwner() {
        return owner;
    }

    /**
    * @param owner
    * the owner to set
    */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    /**
	 * return rent amount
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

    /**
    * @param rentAmount
    * the rentAmount to set
    */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
    

	
	/**
	 * set the property name
	 * @param propertyName the property name to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

    
    /**
	 * return the property's name
	 * @return the property name
	 */
	public String getPropertyName() {
		return propertyName;
	}

	

    /**
	 * Set the plot values 
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth  the vertical size of the property's plot
	 * @return the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x,y,width,depth);
		return plot;
	}
	
	/**
	 * set the plot values by other plot
	 * @param plot the other plot
	 * @return the plot
	 */
	public Plot setPlot(Plot plot) {
		this.plot = new Plot(plot);
		return plot;
	}
	
	/**
	 * return plot
	 * @return the plot
	 */
	public Plot getPlot() {
		return new Plot(plot);
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * @return the string representation of a Property object in the following format: 
              Property Name: propertyName 
               Located in city 
               Belonging to: owner 
               Rent Amount: rentAmount 
          Be sure the last item is the rent amount, preceded by a space.
	 */
	public String toString() {
		return "Property Name: " + propertyName + "\n" +
				"Located in city: " + city + "\n" + 
				"Belonging to: " + owner + "\n" +
				"Rent Amount: " + rentAmount + "\n";
	}


   
}