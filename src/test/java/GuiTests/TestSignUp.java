package GuiTests;

import GuiPages.*;
import baseURL.BaseURL;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;


public class TestSignUp extends BaseURL {

    JSONFileManager jsonFileManager;
    Date date = new Date();
    String current_time = date.getTime() + "";

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/signUp.json");
    }


    @Test

    public void SignUpAsUser() {
        String email = jsonFileManager.getTestData("email") + current_time.substring(6) + "@helaly.com";

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        System.out.println(email);

        SignUpPage signUpPage = homePage.clickSignUpAndLoginButtonTOSignUp();
        signUpPage.verifyNewUserSignUpIsVisible();
        signUpPage.newUserSignUp(
                jsonFileManager.getTestData("name"),
                email
        );

        AccountInformationPage accountInformationPage = signUpPage.clickSignUpButton();

        accountInformationPage.verifyThatEnterAccountIsVisible();

        accountInformationPage.FillAccountDetails(
                jsonFileManager.getTestData("password"),
                jsonFileManager.getTestData("day"),
                jsonFileManager.getTestData("month"),
                jsonFileManager.getTestData("year"),
                jsonFileManager.getTestData("firstName"),
                jsonFileManager.getTestData("lastName"),
                jsonFileManager.getTestData("company"),
                jsonFileManager.getTestData("address1"),
                jsonFileManager.getTestData("address2"),
                jsonFileManager.getTestData("country"),
                jsonFileManager.getTestData("state"),
                jsonFileManager.getTestData("city"),
                jsonFileManager.getTestData("zipCod"),
                jsonFileManager.getTestData("mobileNumber")
        );

        AccountCreatedPage accountCreatedPage = accountInformationPage.clickCreateAccountButton();

        accountCreatedPage.verifyThatAccountCreatedIsVisible();
        homePage = accountCreatedPage.clickContinueButton();
        homePage.verifyThatLoggedInAsIsVisible(
                jsonFileManager.getTestData("loginName")
        );

        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountButton();
        accountDeletedPage.clickContinueDeleteButton();
        accountDeletedPage.VerifyThatAccountDeletedIsVisible();
    }

}


