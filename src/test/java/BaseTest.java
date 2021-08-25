import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BaseTest {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        /*System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        webDriver = new FirefoxDriver();*/
        webDriverWait = new WebDriverWait(getWebDriver(),5);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
    }

    public void goToLandingPage(){ webDriver.get("http://automationpractice.com/index.php");}

    public WebDriver getWebDriver(){ return webDriver; }

    @After
    public void after(){ webDriver.quit();}
}
