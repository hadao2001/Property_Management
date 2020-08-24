
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestPublic {
	
	ManagementCompany m ; 
	
	@Before
	public void setUp() throws Exception {
		
		m= new ManagementCompany("Alliance", "1235",6);
	 
		m.addProperty("Belmar", "Silver Spring", 1200.45, "John Smith",2,1,2,2);
		m.addProperty("Camden Lakeway", "Rockville", 2450, "Ann Taylor",4,1,2,2);
		m.addProperty("Hamptons", "Rockville", 1250, "Rick Steves",6,1,2,2);
	}

	@After
	public void tearDown() {
		m=null;
	}

 	@Test
	public void testAddPropertyWithPlot() {
 		//should create properties with 8 args
		assertEquals(m.addProperty("Mallory Square", "Wheaton", 1000, "Abbey McDonald",1,4,2,2),3,0); 
	}
 	
 	@Test
	public void testTotalRent() {

		assertEquals(m.totalRent(),4900.45,0);
	}

 }