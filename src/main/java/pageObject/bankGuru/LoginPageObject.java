package pageObject.bankGuru;

import commons.BankGuruPageGeneraterManager;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.bankGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver =driver;
    }

}
