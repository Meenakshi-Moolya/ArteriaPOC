package core.tests;

import org.testng.annotations.Test;

public class Scenarios extends SupportTest {

	@Test(enabled = true, priority = 1)
	public void TC_01_creatingTheSalesOrder() throws Exception {

		hp.login().salesOrderFlow().fetchingDetailsFromLog();
	}

}
