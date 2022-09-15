package StepDefinition;

import com.mtnplay.pageObjects.ContactFormPage;
import com.mtnplay.pageObjects.Glob_LoginPage;

import com.mtnplay.pageObjects.MyProfilePage;
import com.mtnplay.pageObjects.MyPlay_FilterContent;
import com.mtnplay.pageObjects.FrontEndPlayer_And_RelatedIntegrationPage;
import com.mtnplay.pageObjects.MyPlaySearchP_PurchasesPage;
import com.mtnplay.pageObjects.SubscribeToWatch_SubscriptionPage;
import com.mtnplay.pageObjects.PurchaseToWatch_OnceOffPage;
import com.mtnplay.pageObjects.MyPlay_Screen_Search_SubscriptionPage;
import com.mtnplay.pageObjects.MyPlay_Screen_Search_PurchasesPage;
import com.mtnplay.pageObjects.Full_SearchFunctionalityPage;
import com.mtnplay.pageObjects.MyPlay_Screen_View_SubscriptionPage;
import com.mtnplay.pageObjects.Unsubscribe_ContentPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.equalTo;


public class Steps {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public Glob_LoginPage glob_loginPage;
    public ContactFormPage contactFormPage;
    public MyProfilePage myprofilePage;
    public MyPlay_FilterContent myPlay_filterContent;
    public FrontEndPlayer_And_RelatedIntegrationPage frontEndPlayer_and_relatedIntegrationPage;
    public MyPlaySearchP_PurchasesPage myPlaySearchP_purchasesPage;
    public SubscribeToWatch_SubscriptionPage subscribeToWatch_subscriptionPage;
    public PurchaseToWatch_OnceOffPage purchaseToWatch_onceOffPage;
    public MyPlay_Screen_Search_SubscriptionPage myPlay_screen_searchSubscriptionPage;
    public MyPlay_Screen_Search_PurchasesPage myPlay_screen_search_purchasesPage;
    public Full_SearchFunctionalityPage full_searchFunctionalityPage;
    public MyPlay_Screen_View_SubscriptionPage myPlay_screen_view_subscriptionPage;
    public Unsubscribe_ContentPage unsubscribe_contentPage;

    private String readPropertiesFile() {

        Properties prop = new Properties();
        try {

            InputStream input = new FileInputStream("C:\\Users\\lunga.shibani\\Downloads\\MTNPlay2.0_Regression\\application.properties");
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
        contactFormPage = new ContactFormPage(driver, wait);
        myprofilePage = new MyProfilePage(driver, wait);
        myPlay_filterContent = new MyPlay_FilterContent(driver, wait);
        frontEndPlayer_and_relatedIntegrationPage = new FrontEndPlayer_And_RelatedIntegrationPage(driver, wait);
        myPlaySearchP_purchasesPage = new MyPlaySearchP_PurchasesPage(driver, wait);
        subscribeToWatch_subscriptionPage = new SubscribeToWatch_SubscriptionPage(driver, wait);
        purchaseToWatch_onceOffPage = new PurchaseToWatch_OnceOffPage(driver, wait);
        myPlay_screen_searchSubscriptionPage = new MyPlay_Screen_Search_SubscriptionPage(driver, wait);
        myPlay_screen_search_purchasesPage = new MyPlay_Screen_Search_PurchasesPage(driver, wait);
        full_searchFunctionalityPage = new Full_SearchFunctionalityPage(driver, wait);
        myPlay_screen_view_subscriptionPage = new MyPlay_Screen_View_SubscriptionPage(driver, wait);
        unsubscribe_contentPage = new Unsubscribe_ContentPage(driver, wait);
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

    @Given("I have opened the App.sit page")
    public void i_have_opened_the_app_sit_page() throws Exception{
        glob_loginPage.OpenPage();
    }

    @Given("I have navigated to the SovTech contact us page")
    public void i_have_navigated_to_the_sov_tech_contact_us_page() throws Exception{
        glob_loginPage.OpenPage();
    }


    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    //#######################################################Sovtech Feature Definition############################################################



    /*
        User enters their Name
        Then user enters their Work Email
        And a user enters their Contact Numbers
        Then a user clicks on the Company size drop-down
        When a user select their Company's employee size
        And a user clicks on the Business service drop-down
        When a user select their Business service type
        Then a user sends a message
        And a user clicks on the Legal consent radio button
        Then a user Submits their contact form
     */


    @When("User navigates and fills the contact form")
    public void user_navigates_and_fills_the_contact_form() throws Exception{

        driver.switchTo().frame(contactFormPage.iFrame);

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.nameTextField));
        contactFormPage.nameTextField.sendKeys("Joe");

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.workEmailTextField));
        contactFormPage.workEmailTextField.sendKeys("json@tester.com");

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.contactNumberTextField));
        contactFormPage.contactNumberTextField.sendKeys("0119876543");

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.companySizeDropDown));
        contactFormPage.companySizeDropDown.click();

        Select companySizeNumber = new Select(driver.findElement(By.name("numemployees")));
        companySizeNumber.selectByVisibleText("25-50");

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.businessServiceDropDown));
        contactFormPage.businessServiceDropDown.click();

        Select businessServiceType = new Select(driver.findElement(By.name("what_kind_of_problem_is_your_business_currently_facing_")));
        businessServiceType.selectByVisibleText("Other");

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.messageTextField));
        contactFormPage.messageTextField.sendKeys("I'm looking forward to doing business with you");

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.legalConsentRadioButton));
        contactFormPage.legalConsentRadioButton.click();

        wait.until(ExpectedConditions.visibilityOf(contactFormPage.submitButton));
        contactFormPage.submitButton.click();

        driver.switchTo().defaultContent();
    }

    @When("User navigates to their profile page and updates")
    public void user_navigates_to_their_profile_page_and_updates() {
        wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnManage));
        myprofilePage.btnManage.click();

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnMyProfile));
        myprofilePage.btnMyProfile.click();

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.txtPhoneNumber));
        myprofilePage.txtPhoneNumber.sendKeys("0977832135");

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.txtName));
        myprofilePage.txtName.sendKeys("Tester");

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.txtEmailAddress));
        myprofilePage.txtEmailAddress.sendKeys("tester@gmail.com");

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnBirthday));
        myprofilePage.btnBirthday.sendKeys("20010420");

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnDropDownLocation));
        myprofilePage.btnDropDownLocation.click();

        //wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnDropDownLocation_Item));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[7]/select/option[3]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        //option[contains(text(), 'Ghana')]

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnDropDownLanguage));
        //myprofilePage.btnDropDownLanguage.click();
        wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnDropDownLanguage_Item));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement eleme = driver.findElement(By.id("language"));
        JavascriptExecutor exece = (JavascriptExecutor)driver;
        exece.executeScript("arguments[0].click();", eleme);

        wait.until(ExpectedConditions.visibilityOf(myprofilePage.btnDropDownLanguage_Item));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement elem = driver.findElement(By.xpath("//option[contains(text(), 'Swahili')]"));
        JavascriptExecutor exec = (JavascriptExecutor)driver;
        exec.executeScript("arguments[0].click();", elem);
    }

    @When("User navigates to the My Play Screen and filters content")
    public void user_navigates_to_the_my_play_screen_and_filters_content() {
//        wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.btnMyPlay));
//        myPlay_filterContent.btnMyPlay.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement elem = driver.findElement(By.xpath("//span[contains(text(), 'my play')]"));
        JavascriptExecutor exec = (JavascriptExecutor)driver;
        exec.executeScript("arguments[0].click();", elem);

//        wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.btnPurchases));
        myPlay_filterContent.btnPurchases.click();

//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        WebElement elem = driver.findElement(By.xpath("//div[contains(text(), 'PURCHASES')]"));
//        JavascriptExecutor exec = (JavascriptExecutor)driver;
//        exec.executeScript("arguments[0].click();", elem);

        wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.btnSubscriptions));
        myPlay_filterContent.btnSubscriptions.click();
    }

    @Then("User verifies content is only for subscription")
    public void user_verifies_content_is_only_for_subscription() {
        //wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.txtContainsSubscription));
        assertThat(myPlay_filterContent.txtContainsSubscription.getText(), containsString("SUBSCRIPTIONS"));
        System.out.println("true");
    }

    @When("User navigates to the My Play Screen to and plays content")
    public void user_navigates_to_the_my_play_screen_to_and_plays_content() {

        //wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.btnMyPlay));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement elem = driver.findElement(By.xpath("//span[contains(text(), 'my play')]"));
        JavascriptExecutor exec = (JavascriptExecutor)driver;
        exec.executeScript("arguments[0].click();", elem);
//        myPlay_filterContent.btnMyPlay.click();

        wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.btnPurchases));
        myPlay_filterContent.btnPurchases.click();

        wait.until(ExpectedConditions.visibilityOf(frontEndPlayer_and_relatedIntegrationPage.freeContentType));
        frontEndPlayer_and_relatedIntegrationPage.freeContentType.click();

        wait.until(ExpectedConditions.visibilityOf(frontEndPlayer_and_relatedIntegrationPage.btnWatchForFree));
        frontEndPlayer_and_relatedIntegrationPage.btnWatchForFree.click();

    }

    @When("User navigates to the My Play Screen and searches for content on purchases")
    public void user_navigates_to_the_my_play_screen_and_searches_for_content_on_purchases() {

        wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.btnMyPlay));
        myPlay_filterContent.btnMyPlay.click();

        wait.until(ExpectedConditions.visibilityOf(myPlay_filterContent.btnPurchases));
        myPlay_filterContent.btnPurchases.click();

        wait.until(ExpectedConditions.visibilityOf(myPlaySearchP_purchasesPage.btnSearch));
        myPlaySearchP_purchasesPage.btnSearch.click();

        wait.until(ExpectedConditions.visibilityOf(myPlaySearchP_purchasesPage.searchField));
        myPlaySearchP_purchasesPage.searchField.sendKeys("black Panther");
    }

    /**
     *This method
     */
    @When("User subscribes to content to watch")
    public void user_subscribes_to_content_to_watch() {

//        wait.until(ExpectedConditions.visibilityOf(subscribeToWatch_subscriptionPage.subscriptionItem));
//        subscribeToWatch_subscriptionPage.subscriptionItem.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement elem = driver.findElement(By.xpath("//div[@id='keymight-likeAsake Peace Be Unto You Pbuy']"));
        JavascriptExecutor exec = (JavascriptExecutor)driver;
        exec.executeScript("arguments[0].click();", elem);

//        wait.until(ExpectedConditions.visibilityOf(subscribeToWatch_subscriptionPage.rdBtnChoosePlan));
//        subscribeToWatch_subscriptionPage.rdBtnChoosePlan.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement eleme = driver.findElement(By.xpath("//span[contains(text(), 'Week')]"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].click();", eleme);

//        wait.until(ExpectedConditions.visibilityOf(subscribeToWatch_subscriptionPage.btnSubscribeToWatch));
//        subscribeToWatch_subscriptionPage.btnSubscribeToWatch.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//div[contains(text(), 'Subscribe to watch')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

//        wait.until(ExpectedConditions.visibilityOf(subscribeToWatch_subscriptionPage.rdBtnAirtime));
//        subscribeToWatch_subscriptionPage.rdBtnAirtime.click();
//
        wait.until(ExpectedConditions.visibilityOf(subscribeToWatch_subscriptionPage.btnConfirmPurchase));
        subscribeToWatch_subscriptionPage.btnConfirmPurchase.click();
//
//
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        WebElement ele = driver.findElement(By.xpath("//div[contains(text(), 'confirm')]"));
//        JavascriptExecutor ex = (JavascriptExecutor)driver;
//        ex.executeScript("arguments[0].click();", ele);
//
//        wait.until(ExpectedConditions.visibilityOf(subscribeToWatch_subscriptionPage.btnWatchNow));
//        subscribeToWatch_subscriptionPage.btnWatchNow.click();
    }

    @When("User subscribes to content to watch Once Off content")
    public void user_subscribes_to_content_to_watch_once_off_content() {

//        wait.until(ExpectedConditions.visibilityOf(subscribeToWatch_onceOffPage.subscriptionItem));
//        subscribeToWatch_onceOffPage.subscriptionItem.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[2]/div[6]/div[1]"));
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", ele);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement elem = driver.findElement(By.xpath("//div[contains(text(), 'Purchase for R407')]"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].click();", elem);

        wait.until(ExpectedConditions.visibilityOf(purchaseToWatch_onceOffPage.rdBtnAirtime));
        purchaseToWatch_onceOffPage.rdBtnAirtime.click();

        wait.until(ExpectedConditions.visibilityOf(purchaseToWatch_onceOffPage.btnConfirmPurchase));
        purchaseToWatch_onceOffPage.btnConfirmPurchase.click();

        wait.until(ExpectedConditions.visibilityOf(purchaseToWatch_onceOffPage.btnConfirm));
        purchaseToWatch_onceOffPage.btnConfirm.click();

        wait.until(ExpectedConditions.visibilityOf(purchaseToWatch_onceOffPage.btnWatchNow));
        purchaseToWatch_onceOffPage.btnWatchNow.click();
    }

    @When("User searches for content on my play screen using the search button")
    public void user_searches_for_content_on_my_play_screen_using_the_search_button() {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(), 'my play')]"));
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", ele);

//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        WebElement elem = driver.findElement(By.xpath("//input[@class='search-input']"));
//        JavascriptExecutor exe = (JavascriptExecutor)driver;
//        exe.executeScript("arguments[0].click();", elem);

        wait.until(ExpectedConditions.visibilityOf(myPlay_screen_searchSubscriptionPage.btnSearch));
        myPlay_screen_searchSubscriptionPage.btnSearch.click();

        wait.until(ExpectedConditions.visibilityOf(myPlay_screen_searchSubscriptionPage.txtSearchInputField));
        myPlay_screen_searchSubscriptionPage.txtSearchInputField.sendKeys("Cyan");
    }

    @When("User searches for purchases content on my play screen using the search button")
    public void user_searches_for_purchases_content_on_my_play_screen_using_the_search_button() {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(), 'my play')]"));
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", ele);

//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        WebElement elem = driver.findElement(By.xpath("//input[@class='search-input']"));
//        JavascriptExecutor exe = (JavascriptExecutor)driver;
//        exe.executeScript("arguments[0].click();", elem);

        wait.until(ExpectedConditions.visibilityOf(myPlay_screen_search_purchasesPage.btnPurchases));
        myPlay_screen_search_purchasesPage.btnPurchases.click();

        wait.until(ExpectedConditions.visibilityOf(myPlay_screen_searchSubscriptionPage.btnSearch));
        myPlay_screen_searchSubscriptionPage.btnSearch.click();

        wait.until(ExpectedConditions.visibilityOf(myPlay_screen_searchSubscriptionPage.txtSearchInputField));
        myPlay_screen_searchSubscriptionPage.txtSearchInputField.sendKeys("We");
    }
    //full_searchFunctionalityPage
    @When("User searches full Search functionality from home screen")
    public void user_searches_full_search_functionality_from_home_screen() {

        wait.until(ExpectedConditions.visibilityOf(myPlay_screen_searchSubscriptionPage.btnSearch));
        myPlay_screen_searchSubscriptionPage.btnSearch.click();

        wait.until(ExpectedConditions.visibilityOf(myPlay_screen_searchSubscriptionPage.txtSearchInputField));
        myPlay_screen_searchSubscriptionPage.txtSearchInputField.sendKeys("Asake");
    }
    //mtnPlay_screen_view_subscriptionPage
    @When("User view subscribed content on My Play screen")
    public void user_view_subscribed_content_on_my_play_screen() {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement ele = driver.findElement(By.xpath("//span[contains(text(), 'my play')]"));
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", ele);
    }

    @When("User unsubscribes content through My Profile screen")
    public void user_unsubscribes_content_through_my_profile_screen() {

        wait.until(ExpectedConditions.visibilityOf(unsubscribe_contentPage.btnManage));
        unsubscribe_contentPage.btnManage.click();

        wait.until(ExpectedConditions.visibilityOf(unsubscribe_contentPage.lnkSubscription));
        unsubscribe_contentPage.lnkSubscription.click();

        wait.until(ExpectedConditions.visibilityOf(unsubscribe_contentPage.getLnkSubscriptionContent));
        unsubscribe_contentPage.getLnkSubscriptionContent.click();

        wait.until(ExpectedConditions.visibilityOf(unsubscribe_contentPage.btnUnsubscribe));
        unsubscribe_contentPage.btnUnsubscribe.click();

        wait.until(ExpectedConditions.visibilityOf(unsubscribe_contentPage.btnConfirm));
        unsubscribe_contentPage.btnConfirm.click();
    }

}
