package com.bankguru;

import com.aventstack.extentreports.Status;
import commons.BankGuruPageGeneraterManager;
import commons.BaseTest;
import commons.GlobalConstants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.bankGuru.LoginPageObject;
import pageObject.bankGuru.ManagerHomePageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

import java.lang.reflect.Method;
import java.text.ParseException;

public class Payment extends BaseTest {
    LoginPageObject loginPage;
    ManagerHomePageObject managerHomePage;
    String phoneNumber;
    String customerName = DataHelper.getDataHelper().getCustomerName();
    String cityName = DataHelper.getDataHelper().getCityName();
    String stateName = DataHelper.getDataHelper().getState();
    String email = DataHelper.getDataHelper().getEmailAddress();
    String password = DataHelper.getDataHelper().getPassword();
    String address = DataHelper.getDataHelper().getAddress();
    String PIN = "466250";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        loginPage = BankGuruPageGeneraterManager.getLoginPage(driver);
        loginPage.inputToTextboxByItemName(driver, GlobalConstants.SYSTEM_USER_ID, "UserID");
        loginPage.inputToTextboxByItemName(driver, GlobalConstants.SYSTEM_PASSWORD, "Password");
        loginPage.clickToButtonByValue(driver, "LOGIN");
        managerHomePage = BankGuruPageGeneraterManager.getManagerHomePage(driver);
        phoneNumber = managerHomePage.getRandomPhoneNumber();


    }

    @Test(enabled = true)
    public void Payment_01_Create_New_Customer(Method method) throws ParseException {
        ExtentTestManager.startTest(method.getName(), "Create new customer and check created sucessfully");
        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 01: Open new customer page");
        managerHomePage.clickToNewTabByNameText("New Customer");
        managerHomePage.sleepInSecond(10);
        managerHomePage.clickToCloseButtonAtAdverstisePopup();

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 02: Input Customer name");
        managerHomePage.inputToTextboxByItemName(driver, customerName, "Customer Name");


        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 03: Select gender");
        managerHomePage.selectRadomGender();
        String checkedGender = managerHomePage.getGenderClickedTo();

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 04: Select random Date Of Birth");
        managerHomePage.selectRandomDateOfBirthDay();

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 05: Input full address");
        managerHomePage.inputToAddressTextArea(address);

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 06: Input City");
        managerHomePage.inputToTextboxByItemName(driver, cityName, "City");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 07: Input State");
        managerHomePage.inputToTextboxByItemName(driver, stateName, "State");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 08: Input PIN");
        managerHomePage.inputToTextboxByItemName(driver, PIN, "PIN");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 09: Input Mobile Number");
        managerHomePage.inputToTextboxByItemName(driver, phoneNumber, "Mobile Number");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 10: Input Email");
        managerHomePage.inputToTextboxByItemName(driver, email, "E-mail");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 11: Input Password");
        managerHomePage.inputToTextboxByItemName(driver, password, "Password");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 12: Click to button submite");
        managerHomePage.clickToButtonByValue(driver, "Submit");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 13: Accept popup");
        Assert.assertEquals(managerHomePage.getCustomerRegisterSuccessMessage(), "Customer Registered Successfully!!!");

        ExtentTestManager.getTest().log(Status.INFO, "Create new customer - Step 14: Verify all information is displayed");
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("Customer Name"), customerName);
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("Gender"), checkedGender);
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("Birthdate"), managerHomePage.getDateOfBirthValue());
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("Address"), address);
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("City"), cityName);
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("State"), stateName);
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("Pin"), PIN);
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("Mobile No."), phoneNumber);
        Assert.assertEquals(managerHomePage.getValueOfEachItemByText("Email"), email);


    }

    @AfterClass(alwaysRun = false)
    public void afterClass() {
//		closeBrowserDriver();
    }

}
