package core.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;

public class HomePage extends FullPage {

	public HomePage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
	}

	/**
	 * This method performs the Sign-Up action
	 *
	 */
	public void signUp() throws Exception {

		getControl("usernameSignUp").enterText(getTestData().get("username"));

		getControl("passwordSignUp").waitUntilClickable();
		getControl("passwordSignUp").click();

		getControl("passwordSignUp").enterText(getTestData().get("password"));
		getControl("registerBtn").click();

		getControl("doneBtnSignUp").waitUntilVisible();
		getControl("doneBtnSignUp").click();

	}

	/**
	 * This method performs the Login action
	 *
	 */
	public HomePage login() throws Exception {

		try {
			getControl("passwordSignIn").waitUntilVisible();
			getControl("passwordSignIn").click();

			getControl("passwordSignIn").enterText("Krishna@2");

			getControl("logInBtn").waitUntilVisible();
			getControl("logInBtn").click();
		} catch (Exception e) {
			signUp();
		}
		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method Starts the Day
	 *
	 */
	public HomePage startDay() throws Exception {

		if (getControl("startDayText").getText().contains("Start")) {
			getControl("startDayPlayBtn").click();

			getControl("reasonForDayStart").waitUntilVisible();
			getControl("reasonForDayStart").click();

			getControl("attendanceSaveBtn").waitUntilVisible();
			getControl("attendanceSaveBtn").click();

		} else {
			endTheDay();
		}
		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method ends the Day
	 *
	 */
	public HomePage endTheVisit() throws Exception {

		Assert.assertEquals(getControl("endDayText").getText(), "End Day");

		getControl("endTheDayPlayBtn").waitUntilVisible();
		getControl("endTheDayPlayBtn").click();

		getControl("dayEndPopUp").waitUntilVisible();
		getControl("dayEndPopUp").click();

		getControl("clickOnReason").waitUntilVisible();
		getControl("clickOnReason").click();

		getControl("reasonVisitEnd").waitUntilVisible();
		getControl("reasonVisitEnd").click();// Visit end reason

		getControl("remarksVisitEnd").enterText("Hi");

		getControl("saveRemark").waitUntilVisible();
		getControl("saveRemark").click(); // SAve

		getControl("visitEndPopUp").waitUntilVisible();
		getControl("visitEndPopUp").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method syncs the Data to the server
	 *
	 */
	public HomePage syncData() throws Exception {

		getControl("hamburgerMenu").waitUntilVisible();
		getControl("hamburgerMenu").click();

		getControl("syncBtn").waitUntilVisible();
		getControl("syncBtn").click();

		getControl("uploadBtn").waitUntilVisible();
		getControl("uploadBtn").click();

		getControl("synchroPopUp").waitUntilVisible();
		getControl("synchroPopUp").click();

		getControl("navigateBackBtn").waitUntilVisible();
		getControl("navigateBackBtn").click();

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method fetches the Order no
	 *
	 */
	public void fetchingOrderNo() throws Exception {

		getControl("hamburgerMenu").waitUntilVisible();
		getControl("hamburgerMenu").click();

		getControl("selectRetailer").waitUntilVisible();
		getControl("selectRetailer").click();// Selecting the Retailers tab

		getControl("clickOnRetailer").waitUntilVisible();
		getControl("clickOnRetailer").click(); // click on retailer

		Integer orderNo = Integer.parseInt(getControl("fetchOrderNo").getText()); // fetching Order no.

		System.out.println(orderNo);
	}

	/**
	 * This method navigates to back page
	 *
	 */
	public void backNavigation() throws Exception {
		getControl("navigateBackBtn").waitUntilVisible();
		getControl("navigateBackBtn").click();

	}

	/**
	 * This method end the day
	 *
	 */
	public void endTheDay() throws Exception {

		if (getControl("endDayText").getText().contains("End Day")) {

			logger.info("The day has already started");

		} else {
			logger.info("The day cannot be ended");
		}
	}

	/**
	 * This method completes the day
	 *
	 */
	public void completeTheDay() throws Exception {

		Assert.assertEquals(getControl("completeTheDayText").getText(), "Day Completed");

		getControl("resetTheDay").waitUntilVisible();
		getControl("resetTheDay").click();

		getControl("dayEndResetConfrm").waitUntilVisible();
		getControl("dayEndResetConfrm").click();
	}

	/**
	 * This method creates the sales order flow
	 *
	 */
	public HomePage creatingTheSalesOrderFlow() throws Exception {

		getControl("hamburgerMenu").waitUntilVisible();
		getControl("hamburgerMenu").click();

		getControl("beatPlan").waitUntilVisible();
		getControl("beatPlan").click();

		getControl("clickOnDropDown").waitUntilVisible();
		getControl("clickOnDropDown").click();

		getControl("selectDropDown").waitUntilVisible();
		getControl("selectDropDown").click();

		getControl("selectingRetailer").waitUntilVisible();
		getControl("selectingRetailer").click();

		getControl("startTheVisit").waitUntilVisible();
		getControl("startTheVisit").click(); // Start the visit

		getControl("startVisitPopUp").waitUntilVisible();
		getControl("startVisitPopUp").click(); // Pop-up, Yes / NO

		getControl("startVisitPopUpConfrm").waitUntilVisible();
		getControl("startVisitPopUpConfrm").click(); // Pop-up, OK

		getControl("salesOrderCreation").waitUntilVisible();
		getControl("salesOrderCreation").click(); // SO creation

		swipeLeft();

		getControl("qtyInSalesOrder").waitUntilVisible();
		getControl("qtyInSalesOrder").click(); // clicking on the quantity

		getControl("qtyInSalesOrder").waitUntilVisible();
		getControl("qtyInSalesOrder").enterText("1");

		getControl("reviewBtnAfterCreation").waitUntilVisible();
		getControl("reviewBtnAfterCreation").click();

		getControl("saveBtnAfterOrderCreation").waitUntilVisible();
		getControl("saveBtnAfterOrderCreation").click();

		getControl("saveOrderCreationPopUpConfrm").waitUntilVisible();
		getControl("saveOrderCreationPopUpConfrm").click(); // Pop-up, OK

		getControl("salesOrderCreatedPopUpConfrm").waitUntilVisible();
		getControl("salesOrderCreatedPopUpConfrm").click(); // Pop-up, OK

		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method creates the sales order
	 *
	 */
	public HomePage salesOrderFlow() throws Exception {

		try {
			creatingTheSalesOrderFlow();
			backNavigation();
			getControl("visitEndPopUp").waitUntilVisible();
			getControl("visitEndPopUp").click();

			getControl("visitEndConfirmPopUp").waitUntilVisible();
			getControl("visitEndConfirmPopUp").click();

			backNavigation();

			syncData();
		} catch (Exception e) {
			logger.info("There is some issue in creating the Sales Order");
		}
		return new HomePage(getConfig(), getAgent(), getTestData());
	}

	/**
	 * This method extract order no
	 *
	 */
	public String extractOrderNo(String str) {

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(m.group());
			break;
		}
		return m.group().replaceAll("^0+", "");
	}

	/**
	 * This method fetches Details from log
	 *
	 */
	public HomePage fetchingDetailsFromLog() throws Exception {

		getControl("hamburgerMenu").waitUntilVisible();
		getControl("hamburgerMenu").click();

		swipeDown();

		getControl("supportLink").waitUntilVisible();
		getControl("supportLink").click();

		getControl("logView").waitUntilVisible();
		getControl("logView").click();

		System.out.println(getControls("listOfLogs").size());

		String[] dateAndTimeOfOrder = null;
		for (int i = 0; i < getControls("listOfLogs").size(); i++) {

			String extractingOrderNo = getControls("listOfLogs").get(i).getText();
			if (extractingOrderNo.contains(": SO # 00000")) {
				logger.info(extractingOrderNo);
				dateAndTimeOfOrder = extractingOrderNo.split(" : ");
				System.out.println("The latest Order that has been created is " + dateAndTimeOfOrder[1]);
				System.out.println("Time of the Order created is " + dateAndTimeOfOrder[0]);
				break;
			}
		}

		try {
			FileWriter writer = new FileWriter("C:/Users/Kshitiz/Desktop/ArteriaData.txt", true);

			writer.write(extractOrderNo(dateAndTimeOfOrder[1]));
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new HomePage(getConfig(), getAgent(), getTestData());

	}

}
