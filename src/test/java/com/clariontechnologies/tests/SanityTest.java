package com.clariontechnologies.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clariontechnologies.kdd.Keyword;
import com.clariontechnologies.model.LoginDetail;
import com.clariontechnologies.pages.LogPromice;
import com.clariontechnologies.pages.LoginPage;
import com.clariontechnologies.pages.PromisePage;
import com.clariontechnologies.pages.PromisesToPage;
import com.clariontechnologies.utils.PropertiesUtils;
import com.clariontechnologies.utils.WebDriverInstance;

public class SanityTest {
	public static final String HOME_URL = PropertiesUtils.getLocator("url");
	public static final String ADD_PROMISE_URL = "http://182.74.238.221/clarion_promise_qa/promise/log_promise.php";
	public static final String PROMISES_LOG_URL = "http://182.74.238.221/clarion_promise_qa/promise/promise_to.php#";
	public static final String DATE = "07-09-2020";
	public static final String ADD_PROMISE_MSG = "Test data for promise on date Sonali Test";

	@Test(dataProvider = "loginDataProvider", description = "Verify the User Login with blankspace and valid credential")
	public void verify_user_login(LoginDetail loginDetail) {
		Keyword.launchUrl(HOME_URL);
		Keyword.maximizeWindow();
		LoginPage loginPage = PageFactory.initElements(WebDriverInstance.INSTANCE.getDriver(), LoginPage.class);
		Keyword.explicitWait(6000);
		loginPage.fillUsernameAndPasswod(loginDetail.getUsername(), loginDetail.getPassword());
		loginPage.clickonloginbutton();
		Keyword.explicitWait(5000);
		String currentUrl = WebDriverInstance.INSTANCE.getDriver().getCurrentUrl();
		boolean result = currentUrl.equalsIgnoreCase(HOME_URL);
		assertEquals(result, loginDetail.isValid());
	}

	@DataProvider
	public Object[] loginDataProvider() {
		LoginDetail invalid = new LoginDetail("", "", false);
		LoginDetail valid = new LoginDetail("sanjeetk@clariontechnologies.co.in", "clarion", true);

		return new Object[] { invalid, valid };
	}

	@Test(description = "Verify Add Promise after click on Log Promise button", dependsOnMethods = {
			"verify_user_login" })
	public void verify_add_promise_after_click_on_log_promise_button() {
		PromisePage promisePage = PageFactory.initElements(WebDriverInstance.INSTANCE.getDriver(), PromisePage.class);
		promisePage.clickOnLogPromise();
		Keyword.explicitWait(5000);
		String currentUrl = WebDriverInstance.INSTANCE.getDriver().getCurrentUrl();
		assertEquals(currentUrl, ADD_PROMISE_URL);
		Keyword.explicitWait(5000);
		LogPromice logpromice = PageFactory.initElements(WebDriverInstance.INSTANCE.getDriver(), LogPromice.class);
		logpromice.selectValue("Sonali test");
		logpromice.promiseText(ADD_PROMISE_MSG);
		logpromice.clickOnLogPromise();
		Keyword.explicitWait(5000);
		String currentUrlPromise = WebDriverInstance.INSTANCE.getDriver().getCurrentUrl();
		assertEquals(currentUrlPromise, PROMISES_LOG_URL);

	}

	@Test(description = "verify Promise is added after click on search button", dependsOnMethods = {
			"verify_add_promise_after_click_on_log_promise_button" })
	public void verify_promise_is_added() {
		PromisesToPage promiseToPage = PageFactory.initElements(WebDriverInstance.INSTANCE.getDriver(),
				PromisesToPage.class);
		Keyword.explicitWait(5000);
		promiseToPage.selectText("Sonali test");
		Keyword.explicitWait(5000);
		promiseToPage.sendDate(DATE);
		Keyword.explicitWait(5000);
		promiseToPage.clickOnSearch();
		String addedPromise = promiseToPage.addPromise();
		assertEquals(addedPromise, ADD_PROMISE_MSG);

	}

	@Test(description = "verify user successfully logout", dependsOnMethods = { "verify_promise_is_added" })
	public void verify_user_logout() {
		Keyword.explicitWait(5000);
		PromisesToPage promiseToPage = PageFactory.initElements(WebDriverInstance.INSTANCE.getDriver(),
				PromisesToPage.class);
		promiseToPage.logout();
	}

	@AfterTest(description = "Close Browser")
	public void closebrowser() {
		WebDriverInstance.INSTANCE.getDriver().close();
	}
}
