package core.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.Keys;

import agent.IAgent;
import central.Configuration;

public class HomePage extends FullPage {

	public HomePage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
	}

	/**
	 * This method navigates to the HomePage
	 *
	 */
	public HomePage homePage() throws Exception {
		this.driver.manage().window().maximize();
		String text = getControl("verifyhomeTitle").getText();
		if (text.equals("Log On")) {
			logger.info("Home page title verified");
		} else {
			logger.info("Wrong page");
		}
		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method performs Login action
	 *
	 */
	public HomePage login() throws Exception {
		getControl("email").enterText(getTestData().get("username"));
		getControl("password").enterText(getTestData().get("password"));
		getControl("login").waitUntilClickable();
		getControl("login").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method navigates to the Order group and then to Order List
	 *
	 */
	public HomePage clickOrders() throws Exception {
		getControl("orders").waitUntilClickable();
		getControl("orders").click();

		getControl("salesOrderView").waitUntilClickable();
		getControl("salesOrderView").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method navigates to Secondary Sales Order Page and verifies the page
	 *
	 */
	public HomePage secondarySalesOrderView() throws Exception {
		String text = getControl("verifySecondarySalesOrderListPage").getText();
		if (text.equals("Secondary Sales Order List")) {
			logger.info("Secondary Sales Order List Page verified");
		} else {
			logger.info("Wrong page");
		}

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method selects the customer
	 *
	 */
	public HomePage selectCustomer() throws Exception {
		getControl("customerNoDropdownList").waitUntilClickable();
		getControl("customerNoDropdownList").click();

		getControl("selectCustomer").waitUntilClickable();
		getControl("selectCustomer").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method selects the Order time
	 *
	 */
	public HomePage selectOrderTime() throws Exception {
		getControl("orderDateDropdownList").waitUntilClickable();
		getControl("orderDateDropdownList").click();

		getControl("selectOrderDate").waitUntilClickable();
		getControl("selectOrderDate").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	public String fetchOrderNo() throws FileNotFoundException {
		String data = null;

		File file = new File("C:/Users/Kshitiz/Desktop/ArteriaData.txt");
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine())
			data = sc.nextLine();

		System.out.println(data);
		return data;
	}

	/**
	 * This method fetches the Order No in List Order Page
	 *
	 */
	public HomePage searchOrderNo() throws Exception {
		getControl("selectOrderNoInListOrder").waitUntilClickable();
		getControl("selectOrderNoInListOrder").click();

		getControl("selectOrderTextBox").waitUntilClickable();
		getControl("selectOrderTextBox").click();

		getControl("selectOrderTextBox").enterText(fetchOrderNo());

		getControl("orderSelectGoBtn").waitUntilClickable();
		getControl("orderSelectGoBtn").click();

		getControl("selectingOrderNo").waitUntilClickable();
		getControl("selectingOrderNo").click();

		/*
		 * try { getControl("confirmOrderSelection").click(); } catch (Exception e) {
		 * getControl("closeTheErrorPopUp").click(); }
		 */

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method fetches the Order No in Sales Invoice Create Page
	 *
	 */
	public HomePage selectOrderNo() throws Exception {

		getControl("selectOrderNoTab").waitUntilClickable();
		getControl("selectOrderNoTab").click();

		getControl("selectOrderTextBox").waitUntilClickable();
		getControl("selectOrderTextBox").click();

		getControl("selectOrderTextBox").enterText(fetchOrderNo());

		getControl("orderSelectGoBtn").waitUntilClickable();
		getControl("orderSelectGoBtn").click();

		getControl("selectingOrderNo").waitUntilClickable();
		getControl("selectingOrderNo").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	static String soldToParty;
	static String customer;

	/**
	 * This method search for the Order details
	 *
	 */
	public HomePage searchSalesOrder() throws Exception {

		searchSalesInvoice();

		getControl("CPNoOKButton").waitUntilClickable();
		getControl("CPNoOKButton").click();

		searchOrderNo();

		getControl("CPNoOKButton").waitUntilClickable();
		getControl("CPNoOKButton").click();

		getControl("buttonGo").waitUntilClickable();
		getControl("buttonGo").click();

		getControl("clickOrderNo").waitUntilClickable();
		getControl("clickOrderNo").click();

		soldToParty = getControl("getSoldToParty").getText();
		logger.info(soldToParty);

		customer = getControl("getCustomer").getText();
		logger.info(customer);

		customer = customer.replaceAll("Customer:", "");
		logger.info("The Customer for which the Order is created is " + customer);

		customer = customer.replaceAll("\\(.*?\\)", "");
		soldToParty = soldToParty.replaceAll("\\(.*?\\)", "");
		logger.info("The Sold to Party for the Order Created is " + soldToParty);

		String orderCreatedDate = getControl("getOrderCreatedDate").getText();
		logger.info("Order has been created on " + orderCreatedDate);

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This navigates to Home Page
	 *
	 */
	public HomePage goHome() throws Exception {
		getControl("goHome").waitUntilClickable();
		getControl("goHome").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method navigates to the Sales Group and then to Sales Invoice page
	 *
	 */
	public HomePage clickSales() throws Exception {

		getControl("sales").waitUntilClickable();
		getControl("sales").click();

		getControl("secondarySalesInvoiceCreate").waitUntilClickable();
		getControl("secondarySalesInvoiceCreate").click();
		Thread.sleep(35000);

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method verifies the secondary sales invoice page
	 *
	 */
	public HomePage secondarySalesInvoice() throws Exception {
		String text = getControl("verifySecondarySalesInvoice").getText();
		if (text.equals("Create Secondary Sales Invoice")) {
			logger.info("Create Secondary Sales Invoice Page verified");
		} else {
			logger.info("Wrong page");
		}

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method verifies the secondary sales invoice page
	 *
	 */
	public HomePage selectCustomerNoForInvoice() throws Exception {
		getControl("customerNoDropdownListInvoice").waitUntilClickable();
		getControl("customerNoDropdownListInvoice").click();

		getControl("selectCustomerInvoice").waitUntilClickable();
		getControl("selectCustomerInvoice").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method navigates to DMS Division
	 *
	 */
	public HomePage selectDMS_division() throws Exception {
		getControl("DMSdivisionDropdownList").waitUntilClickable();
		getControl("DMSdivisionDropdownList").click();

		getControl("selectDMSdivision").waitUntilClickable();
		getControl("selectDMSdivision").click();
		Thread.sleep(12000);

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method navigates to DMS Division
	 *
	 */
	public HomePage searchSalesInvoice() throws Exception {
		getControl("selectSoldToParty").waitUntilClickable();
		getControl("selectSoldToParty").click();

		getControl("enterCPName").waitUntilClickable();
		getControl("enterCPName").click();

		getControl("enterCPName").enterText("Anirban Stores");

		getControl("CPNoButtonGo").waitUntilClickable();
		getControl("CPNoButtonGo").click();

		getControl("selectCPNo").waitUntilClickable();
		getControl("selectCPNo").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method inputs the materials and the qty
	 *
	 */
	public HomePage enterMaterialNo() throws Exception {
		getControl("itemsMenu").waitUntilClickable();
		getControl("itemsMenu").click();

		getControl("selectQuantity").waitUntilClickable();
		getControl("selectQuantity").click();

		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText(Keys.DELETE);
		getControl("selectQuantity").enterText("1");

		getControl("clickOnUnitPriceTab").waitUntilClickable();
		getControl("clickOnUnitPriceTab").click();

		try {
			getControl("clickHeaderDetails").waitUntilClickable();
			getControl("clickHeaderDetails").click();

		} catch (Exception e) {
			scrollUp();
		}

		getControl("buttonReview").waitUntilClickable();
		getControl("buttonReview").click();

		getControl("buttonSave").waitUntilClickable();
		getControl("buttonSave").click();

		String invoice = getControl("invoiceCreationMessage").getText();
		logger.info(invoice);

		return new HomePage(getConfig(), getAgent(), getTestData());
	}
}
