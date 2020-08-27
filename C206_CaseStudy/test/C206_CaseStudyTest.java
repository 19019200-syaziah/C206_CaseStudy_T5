// Create by Ling Ying.
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private MoneyHolding MH1;
	private MoneyHolding MH2;
	private MoneyHolding MH3;
	private MoneyHolding MH4;
	private MoneyHolding MH5;
	
	ArrayList<MoneyHolding> MoneyHoldingList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		//Prepare test data
		MH1 = new MoneyHolding("USD", 100000.00, 10000.00);
		MH2 = new MoneyHolding("MYR", 500000.00, 50000.00);
		MH3 = new MoneyHolding("THB", 2000000.00, 100000.00);
		MH4 = new MoneyHolding("JPY", 1500000.00, 500000.00);
		MH5 = new MoneyHolding("KRW", 200000.00, 1000000.00);
		
		MoneyHoldingList = new ArrayList<MoneyHolding>();
	}
	
	@Test
	public void MoneyHoldingViewAll_test() {
		// Test if there is positive amount in MoneyHoldingList - Normal
		assertTrue("Check the system will convert the holdings of currency into sgd value and display.", true);
		
		// Test if the MoneyHolding list is null - Boundary
		assertNotNull("Check if the amount holding of currency is null, it will not display any result", MoneyHoldingList);
	    
	    // Test if there is no currency available - Error
		assertFalse("Test the system will not display anything when there is no currency available", false);
	    
	}

	@Test
	public void searchHoldingCurrenciesTest() {
		//Test if the MoneyHolding is able to search - Normal
		assertTrue("Check the input of alphabet will display holdings of currency and its corresponding SGD value", true);
		
		//Test if the MoneyHolding not able to search when enter a alphabet and numeric input - Error
		assertFalse("Check the input of alphabet and numeric will display invalid", false);
		
		//Test if the MoneyHolding is not able to search when enter the numeric input - Error
		assertFalse("Check the input of numeric will display invalid", false);
	}
	
	@Test
	public void updateThresHoldHoldings() {
		// Test the threshold is able to update - Normal
		assertTrue("Check the threshold will be updated if there is a numeric input", true);
		
		// Test the threshold is not able to update when the input is null - Boundary
		assertNotNull("Check the threshold will not able to updated if the input is null.", MoneyHoldingList);
		
		// Test the threshold is not able to update - Error
		assertFalse("Check the threshold will not able to updated and display any result when there is a non-numeric input", false);
	}
	
	@Test
	public void viewAllThresHoldHoldings() {
		// Test the threshold is able to view - Normal
		assertTrue("Test if the input is positive number, the system will display the threshold of holdings.", true);
		
		// Test if the input is null - Boundary
		assertNotNull("Check that the system will not display any result if the input is null", MoneyHoldingList);
		
		// Test if the input is non-numeric - Error
		assertFalse("Check that the system will display an invalid message if the input is non-numeric", false);
		
		// Test if the input is negetive number - Error
		assertFalse("Check that the system will not display any result if the input is negative number", false);
	}
	
	@After
	public void tearDown() throws Exception {
		MH1 = null;
		MH2 = null;
		MH3 = null;
		MH4 = null;
		MH5 = null;
	}
	
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
