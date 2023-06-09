package GuiTests;

import GuiPages.SignInPage;
import baseURL.BaseURL;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

public class TestSignIn extends BaseURL {
    JSONFileManager jsonFileManager;
    Date date = new Date();
    String current_time = date.getTime() + "";

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/signIn.json");
    }

    @Test

    public void SignUpAsUser(){

        homePage.verifyThatHomePageIsVisibleSuccessfully();


        SignInPage signInPage = homePage.clickSignUpAndLoginButtonToSignIn();

        signInPage.verifyLoginToYourAccountIsVisible();

        signInPage.loginToYourAccount(
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("password")
        );
        signInPage.clickSigInpButton();
    }
}
