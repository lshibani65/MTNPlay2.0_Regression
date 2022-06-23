package StepDefinition;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import com.eblocks.PageObjects.OnlineCalculatorPage;
import com.eblocks.PageObjects.Glob_LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.equalTo;
//import sun.font.SunFontManager;


public class Steps {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public Glob_LoginPage glob_loginPage;
    public OnlineCalculatorPage onlineCalculatorPage;


    private String readPropertiesFile() {

        Properties prop = new Properties();
        try {

            InputStream input = new FileInputStream("C:\\Users\\siyan\\Downloads\\Eblocks_Assessment2022-20220623T070755Z-001\\Eblocks_Assessment2022\\application.properties");
            prop.load(input);
            System.out.println(prop.getProperty("CHROME_DRIVER"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty("CHROME_DRIVER");
    }

    @Before
    public void doSomethingBefore(Scenario scenario) {
        if(System.getProperty("env") == null){
            System.setProperty("env", "sit");
        }
        System.out.println("Environment set to: " + System.getProperty("env"));
        System.setProperty("webdriver.chrome.driver", readPropertiesFile());
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        glob_loginPage = new Glob_LoginPage(driver, wait);
        onlineCalculatorPage = new OnlineCalculatorPage(driver, wait);
    }

    @After
    public void doSomethingAfter(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    /*
        THIS IS JUST FOR EXPERIMENTAL PURPOSES
     */

    @Given("I have opened the online calculator app")
    public void i_have_opened_the_app_dev_page() throws Exception{
        glob_loginPage.OpenPage();
    }


    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    //#######################################################MTN_Play 2.0 Feature Definition############################################################

    /*
    User clicks on integer One
    Then user clicks on character Plus sign
    And user clicks on integer Two
    Then user clicks on character Equals to
     */
    @When("User navigates to the online calculator")
    public void user_navigates_to_the_online_calculator() {
        wait.until(ExpectedConditions.visibilityOf(onlineCalculatorPage.intOne));
        onlineCalculatorPage.intOne.click();

        wait.until(ExpectedConditions.visibilityOf(onlineCalculatorPage.charPlusSign));
        onlineCalculatorPage.charPlusSign.click();

        wait.until(ExpectedConditions.visibilityOf(onlineCalculatorPage.intTwo));
        onlineCalculatorPage.intTwo.click();

        wait.until(ExpectedConditions.visibilityOf(onlineCalculatorPage.charEqualSign));
        onlineCalculatorPage.charEqualSign.click();
    }
    /*
        User verifies that the outcome equals to three
     */
    @Then("user verifies calculated outcome")
    public void user_verifies_calculated_outcome() {
        assertThat(onlineCalculatorPage.txtContainsThree.getText(), containsString("3"));
        System.out.println("true");
    }


}
