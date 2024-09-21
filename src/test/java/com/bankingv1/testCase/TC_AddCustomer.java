package com.bankingv1.testCase;

import com.bankingv1.pageObjects.AddCustomerPage;
import com.bankingv1.pageObjects.loginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomer extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {

        loginPage lp = new loginPage(driver);
        lp.setUserName(username);
        logger.info("user name provided");
        lp.setPassword(password);
        logger.info("password provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust = new AddCustomerPage(driver);

        addcust.clickAddNewCustomer();
        logger.info("providing customer details");
        addcust.custName("sailaja");
        addcust.custgender("male");
        addcust.custdob("4","15","1947");
        Thread.sleep(3000);
        addcust.custaddress("india");
        addcust.custcity("hyderabad");
        addcust.custstate("telangana");
        addcust.custpinno("500089");
        addcust.custtelephoneno("9985656562");

        String email = randomString()+"@gmail.com";
        addcust.custemailid(email);
        addcust.custpassword("abcdef");
        addcust.custsubmit();
        Thread.sleep(3000);

        logger.info("validation started");
        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if (res == true){
            Assert.assertTrue(true);
            logger.info("test passed !!...");
        }else {
            logger.info("testcase failed !!....");
            captureScreen(driver,"addnewcustomer");
            Assert.assertTrue(false);

        }

    }





}
