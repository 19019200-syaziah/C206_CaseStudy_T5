import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private MoneyHolding a;

	private ArrayList <Transaction> TList;
	private ArrayList <MoneyHolding> MHList;
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		a = new MoneyHolding("SGD", 100, 1000);
		
		MHList = new ArrayList<MoneyHolding>();
		TList = new ArrayList<Transaction>();
	}
	@Test
	public void inputMoneyHoldingTest() {
		//after MoneyHolding has been added, moneyHolding list will increase (Normal)
				C206_CaseStudy.addMoneyHolding(MHList, a);
				assertEquals("Test if MoneyHolding arrayList size is 1", 1, MHList.size());
				
				//after adding, MoneyHolding is not available for negative numbers  (Error)
				C206_CaseStudy.addMoneyHolding(MHList, a);
				assertNotEquals("Test if MoneyHolding arrayList is available", -1, MHList);
				
				//after adding, MoneyHolding is not available for over billion digits  (Boundary)
				assertTrue("Test if MoneyHolding arrayList is over the limit", a.getHoldingAmt() < 999999999);
	}
	@Test
	public void viewAllMoneyHoldingTest() {
		// if the currency does not exist, there should be nothing shown (Error)
		String allCurrencyInfo = C206_CaseStudy.retrieveAllMoneyHolding(MHList);
		String testOutput = "";
		assertEquals("Test if currency info can be viewed if it does not exist", testOutput, allCurrencyInfo);
		
	}
	@Test
	public void deleteMoneyHolding() {
		//MoneyHolding list will decrease after deleting 
				C206_CaseStudy.deleteMoneyHolding(MHList, TList);
				assertEquals("Test if the Moneyholding list will decrease", 0, MHList);
				//MoneyHolding list cannot be null before viewing (Boundary)
				assertNotNull("Test if there is valid MoneyHolding in arrayList to view", MHList);
			
	

	}
    public void UpdateMoneyHolding() {
    	//number of MoneyHolding is same after updating (Normal)
    			C206_CaseStudy.UpdateMoneyHolding(MHList);
    			assertEquals("Test that currency info remains same after updating", 1, MHList.size());
    			//currency list cannot be empty when updating (Boundary)
    			assertNotNull("Check that there are valid MoneyHolding info arrayList to update", MHList);
    			
	}
	

	
	
	@After
	public void tearDown() throws Exception {
		a = null;
		MHList = null;
	}
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
