package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignInPage {
    SHAFT.GUI.WebDriver driver;
    private final By loginToYourAccountText = By.xpath("//div[@class='login-form']/child::h2");
    private final By emailSignInTextFailed = By.xpath("//input[@data-qa='login-email']");
    private final By passwordSignInTextFailed = By.xpath("//input[@data-qa='login-password']");
    private final By signInButton = By.xpath("//button[@data-qa='login-button']");
    private final By wrongMessage = By.xpath("//p[@style='color: red;']");


    public SignInPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginToYourAccountIsVisible(){
        driver.assertThat().element(loginToYourAccountText).isVisible().
                withCustomReportMessage("Verify 'Login to your account' is visible");
    }

    public void loginToYourAccount(String email, String password){
        driver.element().type(emailSignInTextFailed, email);
        driver.element().type(passwordSignInTextFailed, password);
    }

    public HomePage clickSigInpButton(){
        driver.element().click(signInButton);
        return new HomePage(driver);
    }

    public void VerifyYourEmailOrPasswordIsIncorrect(){
        driver.assertThat().element(wrongMessage).isVisible().
                withCustomReportMessage("Verify error 'Your email or password is incorrect!' is visible");
    }
}
