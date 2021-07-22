package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountInfo extends BasePage{
    public AccountInfo(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(id = "id_gender1")
    private WebElement gender;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement day;

    @FindBy(id = "months")
    private WebElement month;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(id = "alias")
    private WebElement aliasAddress;

    @FindBy(id = "submitAccount")
    private WebElement register;

    public void completeRegisterForm(String firstName, String lastName, String password, String address, String city, String zipCode, String mobilePhone, String aliasAddress) {
        getGender().click();
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getPassword().sendKeys(password);
        Select day = new Select(getDay());
        day.selectByIndex(6);
        Select month = new Select(getMonth());
        month.selectByIndex(3);
        Select year = new Select(getYear());
        year.selectByIndex(28);
        getAddress().sendKeys(address);
        getCity().sendKeys(city);
        Select state = new Select(getState());
        state.selectByIndex(5);
        getPostcode().sendKeys(zipCode);
        getMobilePhone().sendKeys(mobilePhone);
        getAliasAddress().clear();
        getAliasAddress().sendKeys(aliasAddress);
    }

    public YourAccount clickRegister(){
        getRegister().click();
        new WebDriverWait(getWebDriver(),5).until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));
        return new YourAccount(getWebDriver());
    }

    public WebElement getGender(){ return gender; }
    public WebElement getFirstName(){ return firstName; }
    public WebElement getLastName(){ return lastName; }
    public WebElement getPassword(){ return password; }
    public WebElement getDay() { return day; }
    public WebElement getMonth() { return month; }
    public WebElement getYear() { return year; }
    public WebElement getAddress() { return address; }
    public WebElement getCity() { return city; }
    public WebElement getState() { return state; }
    public WebElement getPostcode() { return postcode; }
    public WebElement getMobilePhone() { return mobilePhone; }
    public WebElement getAliasAddress() { return aliasAddress; }
    public WebElement getRegister() { return register; }

}
