import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BaseTest {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(getWebDriver(), 5);
    }

    protected void goToLandingPage(){ webDriver.get("http://automationpractice.com/index.php");}

    protected WebDriver getWebDriver(){ return webDriver; }

    @After
    public void after(){ webDriver.quit();}
}
