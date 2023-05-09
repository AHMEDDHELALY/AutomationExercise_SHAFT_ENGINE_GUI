package GuiPages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class SignUpAndLoginPage {
    SHAFT.GUI.WebDriver driver;

    private final By newUserSignupText = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private final By nameSignUpTextFailed = By.xpath("//input[@name='name']");
    private final By emailSignUpTextFailed = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    public SignUpAndLoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyNewUserSignUpIsVisible() {
        driver.assertThat().element(newUserSignupText).isVisible().
                withCustomReportMessage("Verify 'New User Signup!' is visible").perform();
    }

    public void newUserSignUp(String name, String email) {
        driver.element().type(nameSignUpTextFailed, name);
        driver.element().type(emailSignUpTextFailed, email);
    }

    public AccountInformationPage clickSignUpButton(){
        driver.element().click(signUpButton);
        return new AccountInformationPage(driver);
    }


}
