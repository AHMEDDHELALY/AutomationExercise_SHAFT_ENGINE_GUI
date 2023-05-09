package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountInformationPage {

    SHAFT.GUI.WebDriver driver;
    private final By titleOfAccountInformationPage = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
    private final By toggleButtonOfTheTitle = By.id("id_gender1");
    private final By passwordInput = By.id("password");
    private final By selectDay = By.id("days");
    private final By selectMonth = By.id("months");
    private final By selectYear = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By optionCheckbox = By.id("optin");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By address1Input = By.id("address1");
    private final By address2Input = By.id("address2");
    private final By selectCountry = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipCodInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");

    public AccountInformationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThatEnterAccountIsVisible() {
        driver.assertThat().element(titleOfAccountInformationPage).
                isVisible().withCustomReportMessage("Verify that 'ENTER ACCOUNT INFORMATION' is visible").perform();
    }

    public void FillAccountDetails(String password, String day, String month, String year, String firstName, String lastName, String company,
                                   String address1, String address2, String country, String state, String city, String zipCod, String mobileNumber) {
        driver.element().click(toggleButtonOfTheTitle);
        driver.element().type(passwordInput, password);
        driver.element().select(selectDay, day);
        driver.element().select(selectMonth, month);
        driver.element().select(selectYear ,year);
        driver.element().click(newsletterCheckbox);
        driver.element().click(optionCheckbox);
        driver.element().type(firstNameInput, firstName);
        driver.element().type(lastNameInput, lastName);
        driver.element().type(companyInput, company);
        driver.element().type(address1Input, address1);
        driver.element().type(address2Input, address2);
        driver.element().select(selectCountry, country);
        driver.element().type(stateInput, state);
        driver.element().type(cityInput, city);
        driver.element().type(zipCodInput, zipCod);
        driver.element().type(mobileNumberInput, mobileNumber);

    }

    public AccountCreatedPage clickCreateAccountButton(){
        driver.element().click(createAccountButton);
        return new  AccountCreatedPage (driver);
    }


}




