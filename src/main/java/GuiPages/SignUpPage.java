package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpPage {
    SHAFT.GUI.WebDriver driver;

    //Locator
    private final By newUserSignupText = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private final By nameSignUpTextFailed = By.xpath("//input[@name='name']");
    private final By emailSignUpTextFailed = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private final By emailAlreadyExistMessageLocator = By.xpath("//p[@style='color: red;']");


    //Constructor
    public SignUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Verify 'New User Signup!' is visible
     */
    public void verifyNewUserSignUpIsVisible() {
        driver.assertThat().element(newUserSignupText).isVisible().
                withCustomReportMessage("Verify 'New User Signup!' is visible").perform();
    }

    /**
     * New User Signup
     *
     * @param name
     * @param email
     */
    public void newUserSignUp(String name, String email) {
        driver.element().type(nameSignUpTextFailed, name);
        driver.element().type(emailSignUpTextFailed, email);
    }

    /**
     * click Sig Up Button
     *
     * @return Account Information Page
     */
    public AccountInformationPage clickSignUpButton() {
        driver.element().click(signUpButton);
        return new AccountInformationPage(driver);
    }


    /**
     * Verify error 'Email Address already exist!' is visible
     */
    public void verifyErrorEmailAddressAlreadyExistIsVisible() {
        driver.assertThat().element(emailAlreadyExistMessageLocator).isVisible().
                withCustomReportMessage("Verify error 'Email Address already exist!' is visible").perform();
    }


}
