package GuiTests;

import GuiPages.TestCasesPage;
import baseURL.BaseURL;
import org.testng.annotations.Test;

public class TestCase extends BaseURL {


    @Test
    public void verifyTestCasesPage(){

        TestCasesPage testCasesPage = homePage.clickTestCasePage();

        testCasesPage.verifyUserIsNavigatedToTestCasesPageSuccessfully();
    }

}
