package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage extends BasePage{
    public AddressesPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy (css = ".page-heading") private WebElement textTitleAddresses;
    @FindBy (css = ".step_current > span:nth-child(1)") private WebElement textAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(1) > h3:nth-child(1)") private WebElement deliveryTitleAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(2)") private WebElement deliveryNameAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(3)") private WebElement deliveryCompanyAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(4)") private WebElement deliveryAddressAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(5)") private WebElement deliveryNamePostcodeAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(6)") private WebElement deliveryCountryNameAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(7)") private WebElement deliveryPhoneAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(8) > a:nth-child(1) > span:nth-child(1)") private WebElement deliveryUpdateBtnAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(1) > h3:nth-child(1)") private WebElement billingTitleAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(2)") private WebElement billingNameAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(3)") private WebElement billingCompanyAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(4)") private WebElement billingAddressAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(5)") private WebElement billingNamePostcodeAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(6)") private WebElement billingCountryNameAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(7)") private WebElement billingPhoneAddresses;
    @FindBy (css = "#address_invoice > li:nth-child(8) > a:nth-child(1) > span:nth-child(1)") private WebElement billingUpdateBtnAddresses;
    @FindBy (css = ".address_add > a:nth-child(1) > span:nth-child(1)") private WebElement addNewAddressAddresses;
    @FindBy (css = ".button-exclusive") private WebElement continueShoppingBtnAddresses;
    @FindBy (css = "button.button:nth-child(4) > span:nth-child(1)") private WebElement proceedCheckoutBtnAddresses;

    public ShippingPage clickProccedtoCheckoutShipping(){
        getProceedCheckoutBtnAddresses().click();
        return new ShippingPage(getWebDriver());
    }

    public WebElement getTextTitleAddresses() {return textTitleAddresses;}
    public WebElement getTextAddresses() {return textAddresses;}
    public WebElement getDeliveryTitleAddresses() {return deliveryTitleAddresses;}
    public WebElement getDeliveryNameAddresses() {return deliveryNameAddresses;}
    public WebElement getDeliveryCompanyAddresses() {return deliveryCompanyAddresses;}
    public WebElement getDeliveryAddressAddresses() {return deliveryAddressAddresses;}
    public WebElement getDeliveryNamePostcodeAddresses() {return deliveryNamePostcodeAddresses;}
    public WebElement getDeliveryCountryNameAddresses() {return deliveryCountryNameAddresses;}
    public WebElement getDeliveryPhoneAddresses() {return deliveryPhoneAddresses;}
    public WebElement getDeliveryUpdateBtnAddresses() {return deliveryUpdateBtnAddresses;}
    public WebElement getBillingTitleAddresses() {return billingTitleAddresses;}
    public WebElement getBillingNameAddresses() {return billingNameAddresses;}
    public WebElement getBillingCompanyAddresses() {return billingCompanyAddresses;}
    public WebElement getBillingAddressAddresses() {return billingAddressAddresses;}
    public WebElement getBillingNamePostcodeAddresses() {return billingNamePostcodeAddresses;}
    public WebElement getBillingCountryNameAddresses() {return billingCountryNameAddresses;}
    public WebElement getBillingPhoneAddresses() {return billingPhoneAddresses;}
    public WebElement getBillingUpdateBtnAddresses() {return billingUpdateBtnAddresses;}
    public WebElement getAddNewAddressAddresses() {return addNewAddressAddresses;}
    public WebElement getContinueShoppingBtnAddresses() {return continueShoppingBtnAddresses;}
    public WebElement getProceedCheckoutBtnAddresses() {return proceedCheckoutBtnAddresses;}
}
