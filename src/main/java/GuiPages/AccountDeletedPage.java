package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountDeletedPage {
    SHAFT.GUI.WebDriver driver;


    private final By continueDeleteButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private final By accountDeletedAsLocator =By.xpath("//b[contains(.,'Account Deleted!')]");


    public AccountDeletedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickContinueDeleteButton(){
        driver.element().click(continueDeleteButton);
        return new HomePage(driver);
    }

    public void  VerifyThatAccountDeletedIsVisible(){
        driver.assertThat().element(accountDeletedAsLocator).isVisible().
                withCustomReportMessage("Verify that 'ACCOUNT DELETED!' is visible");
    }

}
