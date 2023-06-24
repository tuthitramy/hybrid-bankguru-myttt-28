package pageObject.bankGuru;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.bankGuru.ManagerHomePagePageUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ManagerHomePageObject extends BasePage {
    WebDriver driver;

    public ManagerHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewTabByNameText(String name) {
        waitForElementClickable(driver, ManagerHomePagePageUI.TAB_NAME_BY_TEXT, name);
        clickToElement(driver, ManagerHomePagePageUI.TAB_NAME_BY_TEXT, name);
    }

    public String selectRandomDateOfBirthDay() {
        waitForElementVisible(driver, ManagerHomePagePageUI.DATE_OF_BIRTH_INPUT);
        return sendKeysRandomDate(driver, ManagerHomePagePageUI.DATE_OF_BIRTH_INPUT);
    }

    public void selectRadomGender() {
        selectRandomRadiobutton(driver, ManagerHomePagePageUI.GENDER_RADIO_BUTTON);
    }

    public void inputToAddressTextArea(String address) {
        waitForElementVisible(driver, ManagerHomePagePageUI.ADDRESS_TEXTAREA);
        sendkeysToElement(driver, ManagerHomePagePageUI.ADDRESS_TEXTAREA, address);
    }

    public void clickToCloseButtonAtAdverstisePopup() {
        switchToIframeFrame(driver, ManagerHomePagePageUI.PARENT_ADDVERTISE_IFRAME);
        if (getElementSize(driver, ManagerHomePagePageUI.CHILD_ADDVERTISE_IFRAME) != 0) {
        switchToIframeFrame(driver, ManagerHomePagePageUI.PARENT_ADDVERTISE_IFRAME);
        }
        clickToElement(driver, ManagerHomePagePageUI.CLOSE_BUTTON);
        switchToDefaultContent(driver, "//body//meta[@content='noindex, nofollow']");

    }

    public String getCustomerRegisterSuccessMessage() {
        waitForElementVisible(driver, ManagerHomePagePageUI.REGISTER_SUCCESS_MESSAGE);
        return getTextElement(driver, ManagerHomePagePageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getGenderClickedTo() {
        WebElement elementClickedTo = getWebElement(driver, ManagerHomePagePageUI.CHECKED_GENDER_RADIOBUTTON);
        String genderClickedToText = elementClickedTo.getText();
        return genderClickedToText;
    }

    public String getValueOfEachItemByText(String itemName) {
        waitForElementVisible(driver, ManagerHomePagePageUI.DYNAMIC_VALUE_BY_ITEMNAME_TEXT, itemName);
        return getTextElement(driver, ManagerHomePagePageUI.DYNAMIC_VALUE_BY_ITEMNAME_TEXT, itemName);


    }

    public String getDateOfBirthValue() throws ParseException {
        String dateFormatPattern = "yyyy/MM/dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

        waitForElementVisible(driver, ManagerHomePagePageUI.DYNAMIC_VALUE_BY_ITEMNAME_TEXT, "Birthdate");
        getTextElement(driver, ManagerHomePagePageUI.DYNAMIC_VALUE_BY_ITEMNAME_TEXT, "Birthdate");

        String originalDateString = getTextElement(driver, ManagerHomePagePageUI.DYNAMIC_VALUE_BY_ITEMNAME_TEXT, "Birthdate");
        String originalDateFormatPattern = "dd/MM/yyyy"; // Định dạng ngày tháng ban đầu
        String desiredDateFormatPattern = "yyyy/MM/dddd"; // Định dạng ngày tháng mong muốn

        SimpleDateFormat originalDateFormat = new SimpleDateFormat(originalDateFormatPattern);
        SimpleDateFormat desiredDateFormat = new SimpleDateFormat(desiredDateFormatPattern);

        // Chuyển đổi chuỗi ngày tháng ban đầu sang đối tượng Date
        java.util.Date originalDate = originalDateFormat.parse(originalDateString);

        // Chuyển đổi đối tượng Date sang chuỗi ngày tháng mới với định dạng mong muốn
        String desiredDateString = desiredDateFormat.format(originalDate);

        return desiredDateString;
    }

}
