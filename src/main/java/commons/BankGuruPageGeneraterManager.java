package commons;

import org.openqa.selenium.WebDriver;
import pageObject.bankGuru.LoginPageObject;
import pageObject.bankGuru.ManagerHomePageObject;

public class BankGuruPageGeneraterManager {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static ManagerHomePageObject getManagerHomePage(WebDriver driver) {
        return new ManagerHomePageObject(driver);
    }


}
