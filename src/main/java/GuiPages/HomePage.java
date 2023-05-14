package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    private final By logoHomeLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By signUpAndLoginButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final By loggedInAsNameLocator = By.xpath("//a[contains( . , ' Logged in as ')]");
    private final By deleteAccountButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private final By logOutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");


    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void verifyThatHomePageIsVisibleSuccessfully() {
        driver.assertThat().element(logoHomeLocator).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();

    }

    public SignUpPage clickSignUpAndLoginButtonTOSignUp() {

        driver.element().click(signUpAndLoginButton);
        return new SignUpPage(driver);
    }

    public void verifyThatLoggedInAsIsVisible(String name) {
        driver.assertThat().element(loggedInAsNameLocator).isVisible().
                withCustomReportMessage(" Verify that 'Logged in as username' is visible").perform();
        driver.assertThat().element(loggedInAsNameLocator).text().isEqualTo(name).perform();
    }

    public AccountDeletedPage clickDeleteAccountButton(){
        driver.element().click(deleteAccountButton);
        return new AccountDeletedPage(driver);
    }

    public SignInPage clickSignUpAndLoginButtonToSignIn(){
        driver.element().click(signUpAndLoginButton);
        return new SignInPage(driver);

    }
    public SignInPage clickLogOutButton(){
        driver.element().click(logOutButton);
        return new SignInPage(driver);
    }
}
