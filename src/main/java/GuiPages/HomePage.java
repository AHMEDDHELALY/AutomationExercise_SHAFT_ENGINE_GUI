package GuiPages;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    private final By logoHomeLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By signUpAndLoginLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void verifyThatHomePageIsVisibleSuccessfully(){
        driver.assertThat().element(logoHomeLocator).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();

    }

    public SignUpAndLoginPage clickSignUpAndLoginButton(){

        driver.element().click(signUpAndLoginLocator);
        return new SignUpAndLoginPage(driver);
    }



}
