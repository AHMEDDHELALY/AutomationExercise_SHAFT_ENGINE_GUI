package GuiTests;

import GuiPages.ContactUsPage;
import GuiPages.ContactUsPageSuccess;
import baseURL.BaseURL;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

    public class TestContactUs extends BaseURL {
        JSONFileManager jsonFileManager;
        Date date = new Date();
        String current_time = date.getTime() + "";

        @BeforeClass
        public void beforeClass() {

            jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/contactUs.json");
        }

        @Test
        public void ContactUsForm(){
            homePage.verifyThatHomePageIsVisibleSuccessfully();

            ContactUsPage contactUsPage = homePage.clickContactUsButton();
            contactUsPage.verifyGetInTouchIsVisible();
            contactUsPage.inputName_Email_Subject_MessageAndUploadFile(
                    jsonFileManager.getTestData("name"),
                    jsonFileManager.getTestData("email"),
                    jsonFileManager.getTestData("subject"),
                    jsonFileManager.getTestData("message"),
                    "src/test/resources/Utilities/testPhoto.webp"
            );

            ContactUsPageSuccess contactUsPageSuccess = contactUsPage.clickSubmitButton();


            contactUsPage.acceptAlert();

            contactUsPageSuccess.verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfully();

            contactUsPageSuccess.clickOnHomePage();

            homePage.verifyThatHomePageIsVisibleSuccessfully();

        }
    }

