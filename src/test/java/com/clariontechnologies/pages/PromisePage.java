package com.clariontechnologies.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromisePage {
	@FindBy(xpath = "//a[contains(text(),'Log Promise')]")
	private WebElement logpromise;
	
	public void clickOnLogPromise()
	{
		logpromise.click();
	}

}
