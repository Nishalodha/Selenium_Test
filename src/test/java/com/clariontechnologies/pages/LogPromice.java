package com.clariontechnologies.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.clariontechnologies.kdd.Keyword;

public class LogPromice {
	@FindBy(xpath = "//select[@name='cboEmp']")
	private WebElement promisefrom;
	
	@FindBy(css="#txtPromise")
	private WebElement promisetext;
	
	@FindBy(css="#btnSubmit")
	private WebElement logPromise;
	
	public void selectValue(String value)
	{
		Keyword.selectdropdown(promisefrom,value);
	}
	
	public void promiseText(String addtext) {
		promisetext.sendKeys(addtext);
	}

	public void clickOnLogPromise()
	{
		logPromise.click();
	}
}
