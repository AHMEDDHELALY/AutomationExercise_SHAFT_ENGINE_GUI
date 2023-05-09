package test;

import GuiPages.AccountCreatedPage;
import GuiPages.AccountInformationPage;
import GuiPages.HomePage;
import GuiPages.SignUpAndLoginPage;
import baseURL.BaseURL;
import com.shaft.driver.SHAFT;
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

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/register.json");
    }


    @Test

    public void RegisterUser(){
        String email = jsonFileManager.getTestData("email") + current_time.substring(6) + "@helaly.com";

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        System.out.println(email);

        SignUpAndLoginPage signUpAndLoginPage = homePage.clickSignUpAndLoginButton();
        signUpAndLoginPage.verifyNewUserSignUpIsVisible();
        signUpAndLoginPage.newUserSignUp(
                jsonFileManager.getTestData("name"),
                email
        );

        AccountInformationPage accountInformationPage = signUpAndLoginPage.clickSignUpButton();

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

        homePage.clickSignUpAndLoginButton();





    }
}


