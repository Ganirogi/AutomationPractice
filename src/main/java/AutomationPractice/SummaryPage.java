package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends BasePage{
    public SummaryPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy (css = "#cart_title") private WebElement summaryTitle;
    @FindBy (css = "#summary_products_quantity") private WebElement numberOfProductsSummary;
    @FindBy (css = ".step_current > span:nth-child(1)") private WebElement checkIfSummary;
    @FindBy (css = "td.cart_description > p:nth-child(1) > a:nth-child(1)") private WebElement summaryBlouse;
    @FindBy (css = "td.cart_description > small:nth-child(3) > a:nth-child(1)") private WebElement colorSizeSummary;
    @FindBy (css = ".label") private WebElement checkIfStockSummary;
    @FindBy (className = "price") private WebElement checkUnitPriceSummary;
    @FindBy (css = "#total_product_price_2_10_0") private WebElement checkTotalSummary;
    @FindBy (css = ".icon-trash") private WebElement deleteIconSummary;
    @FindBy (css = "#total_product") private WebElement checkTotalProductsSummary;
    @FindBy (css = "#total_shipping") private WebElement checkTotalShippingSummary;
    @FindBy (css = "#total_price_without_tax") private WebElement checkTotalPriceSummary;
    @FindBy (css = "#total_tax") private WebElement checkTaxSummary;
    @FindBy (css = "#total_price") private WebElement checkFinalPrice;
    @FindBy (css = ".button-exclusive") private WebElement backToShoppingBtnSummary;
    @FindBy (css = ".standard-checkout") private WebElement proceedToCheckoutSummary;

    public void clickDelete() {
        getDeleteIconSummary().click();
    }
    public CreateOrLogIn clickProccedToCheckoutToLogin(){
        getProceedToCheckoutSummary().click();
        return new CreateOrLogIn(getWebDriver());
    }

    public WebElement getSummaryTitle() {return summaryTitle;}
    public WebElement getDeleteIconSummary() {return deleteIconSummary;}
    public WebElement getNumberOfProductsSummary() {return numberOfProductsSummary;}
    public WebElement getCheckIfSummary() {return checkIfSummary;}
    public WebElement getSummaryBlouse() {return summaryBlouse;}
    public WebElement getColorSizeSummary() {return colorSizeSummary;}
    public WebElement getCheckIfStockSummary() {return checkIfStockSummary;}
    public WebElement getCheckUnitPriceSummary() {return checkUnitPriceSummary;}
    public WebElement getCheckTotalSummary() {return checkTotalSummary;}
    public WebElement getCheckTotalProductsSummary() {return checkTotalProductsSummary;}
    public WebElement getCheckTotalShippingSummary() {return checkTotalShippingSummary;}
    public WebElement getCheckTotalPriceSummary() {return checkTotalPriceSummary;}
    public WebElement getCheckTaxSummary() {return checkTaxSummary;}
    public WebElement getCheckFinalPrice() {return checkFinalPrice;}
    public WebElement getBackToShoppingBtnSummary() {return backToShoppingBtnSummary;}
    public WebElement getProceedToCheckoutSummary() {return proceedToCheckoutSummary;}
}
