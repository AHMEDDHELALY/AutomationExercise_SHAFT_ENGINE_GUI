package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUsPageSuccess {
    SHAFT.GUI.WebDriver driver;

    private final By successMessageLocator = By.xpath("//div[@class='status alert alert-success']");
    private final By clickHomePage = By.xpath("//*[@class='btn btn-success']");

    public ContactUsPageSuccess(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void  verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfully(){
        driver.assertThat().element(successMessageLocator).isVisible().
                withCustomReportMessage("Verify success message 'Success! Your details have been submitted successfully.' is visible");
    }

    public HomePage clickOnHomePage(){
        driver.element().click(clickHomePage);
        return new HomePage(driver);
    }
}
