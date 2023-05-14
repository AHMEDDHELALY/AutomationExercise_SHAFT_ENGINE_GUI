package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUsPage {
    SHAFT.GUI.WebDriver driver;
    private final By titleOfPageLocator = By.xpath("//h2[contains( . , 'Get In Touch')]");
    private final By nameInput = By.name("name");
    private final By emailInput = By.name("email");
    private final By subjectInput = By.name("subject");
    private final By messageInput = By.id("message");
    private final By uploadFileButton = By.name("upload_file");
    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");

    public ContactUsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyGetInTouchIsVisible(){
        driver.assertThat().element(titleOfPageLocator).isVisible().
                withCustomReportMessage("Verify 'GET IN TOUCH' is visible");
    }

    public void inputName_Email_Subject_MessageAndUploadFile(String name, String email, String subject, String message, String filePath){
        driver.element().type(nameInput, name);
        driver.element().type(emailInput, email);
        driver.element().type(subjectInput, subject);
        driver.element().type(messageInput, message);
        driver.element().typeFileLocationForUpload(uploadFileButton, filePath);
    }

    public ContactUsPageSuccess clickSubmitButton(){

        driver.element().click(submitButton);
        return new ContactUsPageSuccess(driver);
    }

    public void acceptAlert() {

        driver.alert().acceptAlert();
    }

}
