package com.bankingv1.testCase;

import com.bankingv1.pageObjects.loginPage;
import com.bankingv1.utilites.Xlutils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		loginPage lp = new loginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		if (isAlertPresent()==true){
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent(){

		try {
			driver.switchTo().alert();
			return true;
		}catch (NoAlertPresentException e){
			return false;
		}
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException {
		String path =System.getProperty("user.dir")+"/src/test/java/com/bankingv1/testdata/LoginData.xlsx";

		int rownum = Xlutils.getRowCount(path,"Sheet1");
		int colcount = Xlutils.getCellCount(path,"Sheet1",1);

		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i<=rownum;i++){
			for (int j = 0; j<colcount; j++){
				logindata[i-1][j]=Xlutils.getCellData(path,"Sheet1",i,j);
			}
		}
	return logindata;
	}

}
