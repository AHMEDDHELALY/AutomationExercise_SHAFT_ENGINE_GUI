package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUsPage {
    SHAFT.GUI.WebDriver driver;

    //Locator
    private final By titleOfPageLocator = By.xpath("//h2[contains( . , 'Get In Touch')]");
    private final By nameInput = By.name("name");
    private final By emailInput = By.name("email");
    private final By subjectInput = By.name("subject");
    private final By messageInput = By.id("message");
    private final By uploadFileButton = By.name("upload_file");
    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");


    //Constructor
    public ContactUsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Verify 'GET IN TOUCH' is visible
     */
    public void verifyGetInTouchIsVisible() {
        driver.assertThat().element(titleOfPageLocator).isVisible().
                withCustomReportMessage("Verify 'GET IN TOUCH' is visible").perform();
    }


    /**
     * Input Contact Us Form Data
     *
     * @param name
     * @param email
     * @param subject
     * @param message
     * @param filePath
     */
    public void inputName_Email_Subject_MessageAndUploadFile(String name, String email, String subject, String message, String filePath) {
        driver.element().type(nameInput, name);
        driver.element().type(emailInput, email);
        driver.element().type(subjectInput, subject);
        driver.element().type(messageInput, message);
        driver.element().typeFileLocationForUpload(uploadFileButton, filePath);
    }


    /**
     * click on Submit Button
     *
     * @return ContactUs Page Success
     */
    public ContactUsPageSuccess clickSubmitButton() {

        driver.element().click(submitButton);
        return new ContactUsPageSuccess(driver);
    }

    /**
     * click on Accept Alert To Complete The Next Step
     */
    public void acceptAlert() {

        driver.alert().acceptAlert();
    }

}
