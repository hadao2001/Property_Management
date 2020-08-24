
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany h ; 
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		h = new ManagementCompany("Pokemon", "2468",6);
		
		//student add three properties, with plots, to mgmt co
		
		h.addProperty("Braddock", "Springfield", 1400.05, "Taylor Grant",3,1,2,2);
		h.addProperty("Sleepy", "Annadale", 2500, "Anne Taylor",1,1,3,2);
		h.addProperty("Hilton", "Rockville", 1350, "George Watson",4,1,2,2);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		h=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(h.addProperty("Malfoy Gold", "Wheaton", 1000, "Bolten"),3,0);
		//student should add property with 8 args
		assertEquals(h.addProperty("James Madison", "New York", 3000, "Tifany Ha",3,4,2,2),4,0); 
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(h.addProperty("James Madison", "New York", 3000, "Tifany Ha",3,6,2,2),-1,0);
	}
	
 
	@Test
	public void testMaxRentProp() {

		//student should test if maxRentProp contains the maximum rent of properties
        String maxPropRentArray = h.maxRentPropInfo().split("\n")[3];
		
		//System.out.println(Double.parseDouble(maxPropRentArray[3].split(" ")[3]));
		assertTrue(maxPropRentArray.contains("2450.0"));
	}

	@Test
	public void testTotalRent() {
		fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(h.totalRent(),4900.45,0);
	}

 }