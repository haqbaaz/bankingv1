package com.bankingv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver ldriver;
    public AddCustomerPage(WebDriver rdriver){
        ldriver =rdriver;
        PageFactory.initElements( rdriver,this);
    }
    @CacheLookup
    @FindBy(how = How.XPATH,using = "//div/ul/li[2]/a")
    WebElement lnkAddnewcustomer;

    @CacheLookup
    @FindBy(how = How.NAME,using = "name")
    WebElement txtname;

    @CacheLookup
    @FindBy(how = How.NAME,using = "rad1")
    WebElement rdgender;

    @CacheLookup
    @FindBy(how = How.ID_OR_NAME,using = "dob")
    WebElement txtdob;

    @CacheLookup
    @FindBy(how = How.NAME,using = "addr")
    WebElement txtaddress;

    @CacheLookup
    @FindBy(how = How.NAME,using = "city")
    WebElement txtcity;

    @CacheLookup
    @FindBy(how = How.NAME,using = "state")
    WebElement txtstate;

    @CacheLookup
    @FindBy(how = How.NAME,using = "pinno")
    WebElement txtpinno;

    @CacheLookup
    @FindBy(how = How.NAME,using = "telephoneno")
    WebElement txttelephoneno;

    @CacheLookup
    @FindBy(how = How.NAME,using = "emailid")
    WebElement txtemailid;

    @CacheLookup
    @FindBy(how = How.NAME,using = "password")
    WebElement txtpassword;

    @CacheLookup
    @FindBy(how = How.NAME,using = "sub")
    WebElement btnSubmit;

    public void clickAddNewCustomer() {
        lnkAddnewcustomer.click();

    }

    public void custName(String cname) {
        txtname.sendKeys(cname);

    }

    public void custgender(String cgender) {
        rdgender.click();
    }

    public void custdob(String mm,String dd,String yy) {
        txtdob.sendKeys(mm);
        txtdob.sendKeys(dd);
        txtdob.sendKeys(yy);

    }

    public void custaddress(String caddress) {
        txtaddress.sendKeys(caddress);
    }

    public void custcity(String ccity) {
        txtcity.sendKeys(ccity);
    }

    public void custstate(String cstate) {
        txtstate.sendKeys(cstate);
    }

    public void custpinno(String cpinno) {
        txtpinno.sendKeys(String.valueOf(cpinno));
    }

    public void custtelephoneno(String ctelephoneno) {
        txttelephoneno.sendKeys(ctelephoneno);
    }

    public void custemailid(String cemailid) {
        txtemailid.sendKeys(cemailid);
    }

    public void custpassword(String cpassword) {
        txtpassword.sendKeys(cpassword);
    }

    public void custsubmit() {
        btnSubmit.click();
    }


}
