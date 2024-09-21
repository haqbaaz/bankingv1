package com.bankingv1.testCase;

import com.bankingv1.pageObjects.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {

        logger.info("test has started");
        loginPage lp = new loginPage(driver);
        logger.info("URL is opened");


        lp.setUserName(username);
        logger.info("username entered");
        lp.setPassword(password);
        logger.info("password entered");
        lp.clickSubmit();



        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("login test passed");

        }else{
            captureScreen(driver,"LoginTest");
            Assert.assertTrue(false);
            logger.info("test case failed");

        }


    }


}
