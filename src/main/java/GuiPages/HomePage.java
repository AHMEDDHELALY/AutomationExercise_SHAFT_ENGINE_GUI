package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    private final By logoHomeLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By signUpAndLoginButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final By loggedInAsNameLocator = By.xpath("//a[contains( . , ' Logged in as ')]");
    private final By deleteAccountButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private final By logOutButton = By.xpath("//a[contains( . , ' Logout')]");
    private final By contactUsButton = By.xpath("//a[contains( . , ' Contact us')]");
    private final By testCaseButton = By.xpath("//a[contains( . , ' Test Cases')]");

    //Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Verify that home page is visible successfully
    public void verifyThatHomePageIsVisibleSuccessfully() {
        driver.assertThat().element(logoHomeLocator).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();

    }

    /**
     * click in signUpAndLogin button in the home page
     *
     * @return SignUpPage
     */

    public SignUpPage clickSignUpAndLoginButtonTOSignUp() {

        driver.element().click(signUpAndLoginButton);
        return new SignUpPage(driver);
    }

    /**
     * Verify that 'Logged in as username' is visible
     *
     * @param name
     */

    public void verifyThatLoggedInAsIsVisible(String name) {
        driver.assertThat().element(loggedInAsNameLocator).isVisible().
                withCustomReportMessage(" Verify that 'Logged in as username' is visible").perform();
        driver.assertThat().element(loggedInAsNameLocator).text().isEqualTo(name).perform();
    }

    /**
     * click in delete account button in the home page
     *
     * @return Account delete page
     */
    public AccountDeletedPage clickDeleteAccountButton() {
        driver.element().click(deleteAccountButton);
        return new AccountDeletedPage(driver);
    }


    /**
     * click in signUpAndLogin button in the home page
     *
     * @return SignInPage
     */

    public SignInPage clickSignUpAndLoginButtonToSignIn() {
        driver.element().click(signUpAndLoginButton);
        return new SignInPage(driver);
    }

    /**
     * click in logout button in the home page
     *
     * @return SignInPage
     */

    public SignInPage clickLogOutButton() {
        driver.element().click(logOutButton);
        return new SignInPage(driver);
    }


    /**
     * click in Contact Us button in the home page
     *
     * @return Contact Us Page
     */
    public ContactUsPage clickContactUsButton() {
        driver.element().click(contactUsButton);
        return new ContactUsPage(driver);
    }

}
