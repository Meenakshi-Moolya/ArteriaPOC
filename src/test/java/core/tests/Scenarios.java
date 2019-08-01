package core.tests;

import org.testng.annotations.Test;

public class Scenarios extends SupportTest {

	@Test(enabled = true, priority = 1)
	public void TC_01_checkingTheSalesOrder() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Checking for the Sales Order Details"));

		hp.homePage().login().clickOrders().secondarySalesOrderView().selectCustomer().searchSalesOrder();

		logger.debug(this.getTestEndInfoMessage("Sales Order Details flow ended"));
	}

	@Test(enabled = true, priority = 2)
	public void TC_02_creatingTheSalesInvoice() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Creating the Secondary Sales Invoice"));

		hp.homePage().login().clickSales().selectCustomerNoForInvoice().selectDMS_division().searchSalesInvoice()
				.selectOrderNo().enterMaterialNo();

		logger.debug(this.getTestEndInfoMessage("Secondary Sales Invoice has been created"));
	}
}
