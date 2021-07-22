import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    private WebDriver webDriver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    protected void goToLoadingPage() {
        webDriver.get("http://automationpractice.com/index.php");
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    @After
    public void after() {
        webDriver.quit();
    }
}
