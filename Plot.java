/** 
* @author Ha Dao
* This class holds and sets plots
*/

public class Plot {   

       private int x;

       private int y;

       private int width;

       private int depth;

      
       /**
        * 
        * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
        */
       public Plot()

       {

             x=0;

             y=0;

             width=0;

             depth=0;

       }

    /**
   	 * Parameterized Constructor
   	 * @param x horizontal coordinate of upper left corner
   	 * @param y vertical coordinate of upper left corner
   	 * @param width horizontal size
   	 * @param depth vertical size
   	 */

       public Plot(int x, int y,int depth, int width)

       {

             this.x = x;

             this.y = y;

             this.depth = depth;

             this.width = width;

            

       }

    /**
   	 * set the x value
   	 * @param x  the x value to set
   	 */
   	public void setX(int x) {
   		this.x = x;
   	}
   	
   	/**
   	 * set the y value
   	 * @param y the y value to set
   	 */
   	public void setY(int y) {
   		this.y = y;
   	}
   	
   	/**
   	 * set the width value
   	 * @param width the width value to set
   	 */
   	public void setWidth(int width) {
   		this.width = width;
   	}
   	
   	/**
   	 * set the depth value
   	 * @param depth the depth value to set
   	 */
   	public void setDepth(int depth) {
   		this.depth = depth;
   	}
   	
   	/**
   	 * return the x value
   	 * @return the x value
   	 */
   	public int getX() {
   		return x;
   	}
   	
   	/**
   	 * return the y value
   	 * @return the y value
   	 */
   	public int getY() {
   		return y;
   	}
   	
   	/**
   	 * return the width value
   	 * @return the width value
   	 */
   	public int getWidth() {
   		return width;
   	}
   	
   	/**
   	 * return the depth value
   	 * @return  the depth value
   	 */
   	public int getDepth() {
   		return depth;
   	}


    /**
   	 * Copy Constructor, creates a new Plot using the information of the Plot passed to it.
   	 * @param plot a Plot object
   	 */
   	public Plot(Plot plot) {
   		this.x = plot.x;
   		this.y = plot.y;
   		this.width = plot.width;
   		this.depth = plot.depth;
   	}

      

   	/**
	 * Determines if this plot overlaps the parameter
	 * @param plot the plot object
	 * @return Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		boolean overlapsX = true;
		boolean overlapsY = true;
	
		
		if((plot.x + plot.width) <= x || (plot.x >= (x+width))) {
			overlapsX = false;
		}
		
		if((plot.y + plot.depth) <= y || (plot.y >= (y+depth))){
			overlapsY = false;
		}
		
		return (overlapsX && overlapsY);
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * @param plot the plot object
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		boolean inX = false;
		boolean inY = false;
		
		if(plot.x >= x && (plot.x + plot.width) <= (x+width)) {
			inX = true;
		}
		
		if(plot.y >= y && (plot.y + plot.depth) <= (y+depth)) {
			inY = true;
		}
		
		return (inX && inY);
	}


     /**
   	 * Prints out the name, city, owner and rent amount for a property
   	 * @return the string representation of a Plot object in the following format: 
                  Upper left: (1,1); Width: 3 Depth: 3 
   	 */
   	public String toString() {
   		return "Upper left: (" + x + "," + y+"); Width: " + width + " Depth: "+depth;
   	}

}

