package ReusableMethod;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

    //class created for reusable method
    public class ReusableMethods {
    public WebDriver driver;

    // @Before will run at the start of each @Test class
    @Before


    // method for opening browser
    public void openBrowser() {
        // set driver location
        System.setProperty( "webdriver.chrome.driver", "src/test/java/BrowserDrivers/chromedriver.exe" );
        driver = new ChromeDriver();
        // wait time management
        driver.manage().timeouts().implicitlyWait( 40, TimeUnit.SECONDS );
    }
    // method for adding time stamp
    public String timeStamp() {
        DateFormat dateFormat = new SimpleDateFormat( "ddmmyyhhmmss" );
        Date date = new Date();
        return (dateFormat.format( date ));
    }

    // method to click on element
    public void clickOnElement(By by) {
        driver.findElement( by ).click();
    }

    // method for element to be clickable
    public void waitForClickeble(By by, int time) {
        WebDriverWait wait = new WebDriverWait( driver, time );
        wait.until( ExpectedConditions.elementToBeClickable( by ) );
    }

    // method for element to be visible
    public void waitForVisibility(By by, int time) {
        WebDriverWait wait = new WebDriverWait( driver, time );
        wait.until( ExpectedConditions.visibilityOfElementLocated( by ) );
    }

    // method for waiting to element to be present
    public void waitForElementsToPresent(By by, int time) {
        WebDriverWait wait = new WebDriverWait( driver, time );
        wait.until( ExpectedConditions.presenceOfElementLocated( by ) );
    }

    // method for entering text
    public void enterText(By by, String text) {
        driver.findElement( by ).sendKeys( text );
        waitForClickeble( by, 60 );
    }
    // method to get text from element
    public String getTextFromElement(By by) {
        String text = getTextFromElement( by );
        return text;
    }
    // method for select from drop down manu by value
    public void selectFromDropDownByValue(By by, String text) {
        Select select = new Select( driver.findElement( by ) );
        select.selectByValue( text );
    }

    //Creating method selectFromDropDownByVisibleText
    public void selectFromDropDownByVisibleText(By by, String text) {
        Select select = new Select( driver.findElement( by ) );
        select.selectByValue( text );
    }
    // method for selecting from drop down manu
    public void selectFromDropDownByIndex(By by, int index) {
        Select select = new Select( driver.findElement( by ) );
        select.selectByIndex( index );
    }

    // auto loging for nopCommerce website
    @Test
    public void UserShouldBeRegisterSucssesfully() {
        // expected result
        String expected = "Your registration completed";
        // enter url for nopCommerce
        driver.get( "https://demo.nopcommerce.com/" );
        // program for cliclking on register button
        clickOnElement( By.className( "ico-register" ) );
        // waiting for element to be clickable
        waitForClickeble( By.id( "FirstName" ), 40 );
        // entering first name
        enterText( By.id( "FirstName" ), "prakash" );
        // entering last name
        enterText( By.id( "LastName" ), "Kachhadiya" );
        clickOnElement( By.name( "DateOfBirthDay" ) );
        // enter date of birth
        selectFromDropDownByIndex( By.name( "DateOfBirthDay" ), 2 );
        selectFromDropDownByIndex( By.name( "DateOfBirthMonth" ), 07 );
        selectFromDropDownByValue( By.name( "DateOfBirthYear" ), "1984" );
        // entering email address with timestamp
        enterText( By.id( "Email" ), "pbksoft2019" + timeStamp() + "@gmail.com" );
        // entering password
        enterText( By.id( "Password" ), "Abcd1234" );
        enterText( By.id( "ConfirmPassword" ), "Abcd1234" );
        //click on register button
        clickOnElement( By.id( "register-button" ) );
        //get welcome message
        String actual = getTextFromElement( By.className( "result" ) );
        // compare expected and actual result
        Assert.assertEquals( "Passed", expected, actual );
    }

    @Test
    // auto register for orangeHrm
    public void orangeHrmRegistration() {
        // expecte result
        String expected = "Welcome Admin";
        // enter url in browser
        driver.get( "https://opensource-demo.orangehrmlive.com/" );
        // enter user name
        enterText( By.id( "txtUsername" ), "Admin" );
        // enter password
        enterText( By.id( "txtPassword" ), "admin123" );
        // click on login button
        clickOnElement( By.id( "btnLogin" ) );
        // get text from welcome message
        String actual = getTextFromElement( By.className( "panelTrigger" ) );
        // compare expected and actual
        Assert.assertEquals( expected, actual );
    }

    @Test
    // log in for autoTesting practice website
    public void autoTestPracticeReg() {
        // expected result
        String expected = "Welcome to your account. Here you can manage all of your personal information and orders";
        // entering url in browser
        driver.get( "http://automationpractice.com/index.php" );
        // click on log in button
        clickOnElement( By.className( "login" ) );
        // entering email address with time stamp
        enterText( By.name( "email_create" ), "pbksoft" + timeStamp() + "@gmail.com" );
        // click on submit button
        clickOnElement( By.id( "SubmitCreate" ) );
        // enter first name
        enterText( By.name( "customer_firstname" ), "prakash" );
        // enter last name
        enterText( By.id( "customer_lastname" ), "kachhadiya" );
        // enter password
        enterText( By.name( "passwd" ), "Abcd1234" );
        // enter date of birth
        selectFromDropDownByIndex( By.id( "days" ), 02 );
        selectFromDropDownByIndex( By.name( "months" ), 07 );
        selectFromDropDownByVisibleText( By.id( "years" ), "1984" );
        // enter first name
        enterText( By.id( "firstname" ), "prakash" );
        // enter last name
        enterText( By.id( "lastname" ), "Kachhadiya" );
        // enter address
        enterText( By.name( "address1" ), "295 copperfield" );
        // enter name of city
        enterText( By.id( "city" ), "London" );
        // enter state name from drop down manu
        selectFromDropDownByValue( By.id( "id_state" ), "1" );
        // enter post code
        enterText( By.id( "postcode" ), "12345" );
        // enter country name
        selectFromDropDownByValue( By.name( "id_country" ), "21" );
        // enter phone number
        enterText( By.name( "phone_mobile" ), "01234567890" );
        // enter alias
        enterText( By.id( "alias" ), "PK" );
        // click on submit account
        clickOnElement( By.id( "submitAccount" ) );
        // get text from welcome message
        String actual = getTextFromElement( By.className( "info-account" ) );
        //compare expected and actual
        Assert.assertEquals( expected, actual );
    }

    @Test
    // auto login for mockPlus website registration
    public void mockPlusRegistartion()
    {
        // expected result
        String expected = "Welcome to Mockplus";
        // enter url in browser
        driver.get( "https://www.mockplus.com/" );
        // click on register button
        clickOnElement( By.className( "user-btn" ) );
        // enter email address with time stamp
        enterText( By.id( "email" ), "pbksoft" + timeStamp() + "@gmail.com" );
        // enter password
        enterText( By.id( "password" ), "Abcd123" );
        // enter confirm password
        enterText( By.id( "cofPassword" ), "Abcd123" );
        // click on register button
        clickOnElement( By.className( "iconfont icon_check_tick" ) );
        clickOnElement( By.id( "register" ) );
        // get text from welcome message
        String actual = getTextFromElement( By.className( "title-content" ) );
        // compare expected and actual
        Assert.assertEquals( expected, actual );
    }

    @Test
    // register on ocado website
    public void ocadoReg()
    {
        // expected result
        String expected  ="Thanks for registering";
        // enter url in browser
        driver.get( "https://www.ocado.com/webshop/startWebshop.do" ); // url for ocado
        // wait for element to be clickable
        waitForClickeble( By.className( "button" ),10 );
        // click on register button
        clickOnElement( By.id( "quickReg" ) );
        // select title from drop down menu
        selectFromDropDownByValue( By.id( "title" ),"Mr" );
        // enter first name
        enterText( By.id( "firstName" ),"prakash" );
        // enter last name
        enterText( By.id( "lastName" ),"Kachhadiya" );
        // enter email address with time stamp
        enterText( By.id( "login" ), "pbk"+timeStamp()+"@gmail.com" );
        // enter password
        enterText( By.name( "password" ), "Abcd123" );
        // enter password
        enterText( By.id( "postcode" ), "n1 1qn" );
        // click on register button
        clickOnElement( By.id( "registration-submit-button" ) );
        //get text from element
        String actual = getTextFromElement( By.className( "prp-ico-tick" ) );
        // compare expected and actual
        Assert.assertEquals( expected,actual );
    }
}
