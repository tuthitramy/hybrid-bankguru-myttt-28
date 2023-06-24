package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private Locale local = new Locale("en");
    private Faker faker = new Faker(local);

    public static DataHelper getDataHelper() {
        return new DataHelper();
    }

    public String getCustomerName() {
        return faker.name().name();
    }

    public String getEmailAddress() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password(6, 12);
    }


    public String getCityName() {
        return faker.address().cityName();
    }

    public String getState() {
        return faker.address().state();
    }

    public String getPostalCode() {
        return faker.address().zipCode();
    }



    public String getAddress() {
        return faker.address().streetAddressNumber();
    }

    public String getRandomString() {
        return faker.toString();
    }

    public String getRandomCardNumber() {
        return faker.business().creditCardNumber();
    }

}
