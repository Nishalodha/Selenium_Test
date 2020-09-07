package com.clariontechnologies.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.clariontechnologies.kdd.Keyword;

public class PromisesToPage {
	@FindBy(xpath = "//select[@id='cboEmp']")
	private WebElement promisor;
	
	@FindBy(xpath = "//input[@name='btnSearch']")
	private WebElement search;
	
	@FindBy(css = "#txtStartDate")
	private WebElement date;
	
	@FindBy(xpath=  "//td[contains(text(),'Test data  for  promise on date Sonali Test')]")
	private WebElement addPromise;
	
	@FindBy(xpath="//b[contains(text(),'LOGOUT')]")
	private WebElement logout;
	
	public void logout()
	{
		logout.click();
	}
	
	public String addPromise() {
		return addPromise.getText();
	}
	
	public void sendDate(String dd)
	{
		date.sendKeys(dd);
	}
	
	public void clickOnSearch()
	{
		search.click();
	}

	public void selectText(String value) {
		Keyword.selectdropdown(promisor, value);
	}

}
