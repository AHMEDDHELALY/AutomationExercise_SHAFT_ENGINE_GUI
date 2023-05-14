package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TestCasesPage {

    SHAFT.GUI.WebDriver driver;
    //Locator

    private final By titleOfTestCasesPage = By.id("//*[@id=\"form\"]/div/div[1]/div/h2/b");

    //Constructor
    public TestCasesPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Verify user is navigated to test cases page successfully
     */
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully(){
        driver.assertThat().element(titleOfTestCasesPage).isVisible().
                withCustomReportMessage("Verify user is navigated to test cases page successfully");
    }
}
