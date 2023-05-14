package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountDeletedPage {
    SHAFT.GUI.WebDriver driver;

    //Locator
    private final By continueDeleteButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private final By accountDeletedAsLocator = By.xpath("//b[contains(.,'Account Deleted!')]");

    //Constructor
    public AccountDeletedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    /**
     * click in Continue Delete Button
     *
     * @return Home Page
     */
    public HomePage clickContinueDeleteButton() {
        driver.element().click(continueDeleteButton);
        return new HomePage(driver);
    }


    /**
     * Verify that 'ACCOUNT DELETED!' is visible
     */
    public void VerifyThatAccountDeletedIsVisible() {
        driver.assertThat().element(accountDeletedAsLocator).isVisible().
                withCustomReportMessage("Verify that 'ACCOUNT DELETED!' is visible").perform();
    }

}
