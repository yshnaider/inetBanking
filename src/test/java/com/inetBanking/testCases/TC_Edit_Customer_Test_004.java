package com.inetBanking.testCases;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Edit_Customer_Test_004 extends BaseClass{

    @Test
    public void editCustomer() throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Passsword is provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        EditCustomerPage eddcust=new EditCustomerPage(driver);

        eddcust.clickAddNewCustomer();

        WebElement fillCusID = driver.findElement(By.xpath("//input[@name='cusid']"));
        fillCusID.sendKeys("27023");
        fillCusID.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        logger.info("edditing customer details....");


        eddcust.custaddress("Germany");
        eddcust.custcity("Hamburg");
        eddcust.custstate("Hamburg");
        eddcust.custpinno("500008");
        eddcust.custtelephoneno("987890092");

        String email=randomestring()+"@gmail.com";
        eddcust.custemailid(email);
        eddcust.custpassword("AnUpedA");
        eddcust.custsubmit();

        Thread.sleep(3000);

        logger.info("validation started....");

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        }
        else
        {
            logger.info("test case failed....");
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }


    }
}
