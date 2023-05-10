package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountCreatedPage {
    SHAFT.GUI.WebDriver driver;
    private final By accountCreatedLocator =  By.xpath("//b[contains(.,'Account Created')]");
    private final By continueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");



    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThatAccountCreatedIsVisible() {

        driver.assertThat().element(accountCreatedLocator).isVisible().
                withCustomReportMessage("Verify that 'ACCOUNT CREATED!' is visible").perform();
    }


    public HomePage clickContinueButton(){
        driver.element().click(continueButton);
        return new HomePage(driver);
    }
}


