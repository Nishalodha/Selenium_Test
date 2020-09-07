package com.clariontechnologies.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//input[@name='txtUsername']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='txtPassword']")
    private WebElement password;

    @FindBy (xpath = "//input[@name='submit1']")
    private WebElement loginbutton;
    

    public void fillUsernameAndPasswod(String username, String password) {
    	this.username.sendKeys(username);
    	this.password.sendKeys(password);
    }


	public void clickonloginbutton() {
    	loginbutton.click();		
	}
    
   

}
