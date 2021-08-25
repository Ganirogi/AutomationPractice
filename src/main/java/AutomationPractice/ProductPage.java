package AutomationPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(css = ".pb-center-column > h1:nth-child(1)")    private WebElement nameBlouse;

    @FindBy (css = "#quantity_wanted")    private WebElement quantityAmmount;

    @FindBy (css = "a.btn:nth-child(3)")    private WebElement quantityBtnMinus;

    @FindBy (css = "a.btn:nth-child(4)")    private WebElement quantityBtnPlus;

    @FindBy (css = "#group_1")    private WebElement dropdownSize;

    @FindBy (css = "#color_11")    private WebElement selectBlack;

    @FindBy (css = "#color_8") private WebElement selectWhite;

    @FindBy (css = "button.exclusive")    private WebElement clickAddCart;

    @FindBy (css = "#our_price_display")    private WebElement nrSecond;

    @FindBy (css = "#color_to_pick_list") private WebElement colorPick;

    Actions act = new Actions(getWebDriver());

    public void makeMinusQuantity(){
        getQuantityBtnMinus().click();
    }
    public void makePlusQuantity(){
        getQuantityBtnPlus().click();
    }
    public void selectSize(){
        Select s = new Select(getDropdownSize());
        s.selectByIndex(2);
    }

    public void selectSizeOfProduct(Integer x){
        Select s = new Select(getDropdownSize());
        s.selectByIndex(x);
    }

    public void pickColorBlack(){
        getSelectBlack().click();
    }

    public void pickColorWhite(){
        getSelectWhite().click();
    }

    public void pickColor(String color) {

    }
    public FrameProduct clickAddToCard(){
        getClickAddCart().click();
        return new FrameProduct(getWebDriver());
    }

    public void selectTheQuantity(String quantity){
        act.doubleClick(getQuantityAmmount()).perform();
        act.sendKeys(quantity);
    }

    public void untilOne(){
        getQuantityAmmount().sendKeys(Keys.BACK_SPACE);
        getQuantityAmmount().sendKeys("1");
    }

    public WebElement getNameBlouse(){return nameBlouse;}
    public WebElement getQuantityAmmount(){return quantityAmmount;}
    public WebElement getQuantityBtnMinus() {return quantityBtnMinus;}
    public WebElement getQuantityBtnPlus() {return quantityBtnPlus;}
    public WebElement getDropdownSize() {return dropdownSize;}
    public WebElement getSelectBlack() {return selectBlack;}
    public WebElement getSelectWhite() {return selectWhite;}
    public WebElement getClickAddCart() {return clickAddCart;}
    public WebElement getNrSecond() {return nrSecond;}
    public WebElement getColorPick() {return colorPick;}
}
