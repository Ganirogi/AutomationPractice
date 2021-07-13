import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver webDriver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public void goToLandingPage(){ webDriver.get("http://automationpractice.com/index.php");}

    public WebDriver getWebDriver(){ return webDriver; }

    @After
    public void after(){ webDriver.quit();}
}
