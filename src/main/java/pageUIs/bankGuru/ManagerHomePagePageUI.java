package pageUIs.bankGuru;

public class ManagerHomePagePageUI {
    public static final String TAB_NAME_BY_TEXT = "xpath=//a[text()='%s']";
    public static final String DATE_OF_BIRTH_INPUT = "xpath=//input[@name='dob']";
    public static final String GENDER_RADIO_BUTTON = "xpath=//td//input[@type='radio']";

    public static final String ADDRESS_TEXTAREA = "xpath=//textarea[@name='addr']";
    public static final String PARENT_ADDVERTISE_IFRAME = "xpath=//iframe[@title='3rd party ad content']";

    public static final String CHILD_ADDVERTISE_IFRAME = "xpath=//iframe[@id='ad_iframe']";

    public static final String CLOSE_BUTTON = "xpath=//div[@id='card']//div[@id='dismiss-button']";
    public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//p[@class='heading3']";

    public static final String CHECKED_GENDER_RADIOBUTTON = "xpath=//input[@type='radio' and @checked]";

    public static final String DYNAMIC_VALUE_BY_ITEMNAME_TEXT = "xpath=//table[@id='customer']//tr//td[text()='%s']/following-sibling::td";


}
