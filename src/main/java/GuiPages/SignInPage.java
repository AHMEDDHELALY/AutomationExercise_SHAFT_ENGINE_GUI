package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignInPage {
    SHAFT.GUI.WebDriver driver;

    //Locator
    private final By loginToYourAccountText = By.xpath("//div[@class='login-form']/child::h2");
    private final By emailSignInTextFailed = By.xpath("//input[@data-qa='login-email']");
    private final By passwordSignInTextFailed = By.xpath("//input[@data-qa='login-password']");
    private final By signInButton = By.xpath("//button[@data-qa='login-button']");
    private final By emailOrPasswordIncorrectMessageLocator = By.xpath("//p[@style='color: red;']");


    //Constructor
    public SignInPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Verify 'Login to your account' is visible
     */
    public void verifyLoginToYourAccountIsVisible() {
        driver.assertThat().element(loginToYourAccountText).isVisible().
                withCustomReportMessage("Verify 'Login to your account' is visible").perform();
    }


    /**
     * login To Your Account
     *
     * @param email
     * @param password
     */
    public void loginToYourAccount(String email, String password) {
        driver.element().type(emailSignInTextFailed, email);
        driver.element().type(passwordSignInTextFailed, password);
    }

    /**
     * click SigIn Button
     *
     * @return Home Page
     */
    public HomePage clickSigInButton() {
        driver.element().click(signInButton);
        return new HomePage(driver);
    }

    /**
     * Verify error 'Your email or password is incorrect!' is visible
     */
    public void VerifyYourEmailOrPasswordIsIncorrect() {
        driver.assertThat().element(emailOrPasswordIncorrectMessageLocator).isVisible().
                withCustomReportMessage("Verify error 'Your email or password is incorrect!' is visible").perform();
    }
}
