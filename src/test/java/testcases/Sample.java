package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sample {
	
	@Test
	public void checkAssertion()
	{
		SoftAssert asst = new SoftAssert();
		asst.assertEquals("1", "2");
		asst.assertAll();
		System.out.println("This is final statement");
	}

}
