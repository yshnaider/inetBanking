package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private String username = "mngr354328";
    private String password = "AnUpedA";

    @FindBy(name="uid")
    @CacheLookup
    private WebElement txtUserName;

    @FindBy(name="password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(name="btnLogin")
    @CacheLookup
    private WebElement btnLogin;

    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement lnkLogout;

    private WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public void setUserName(String uname)
    {
        txtUserName.sendKeys(uname);
    }

    public void setPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }


    public void clickSubmit()
    {
        btnLogin.click();
    }

    public void clickLogout()
    {
        lnkLogout.click();
    }
}
