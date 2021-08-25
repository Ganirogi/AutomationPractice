import AutomationPractice.*;
import org.junit.Assert;
import org.junit.Test;

public class QuickViewTest extends BaseTest{

    @Test
    public void logIn() throws InterruptedException {
        goToLandingPage();

        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn("dinugv94@gmail.com", "P4ssword!");
        YourAccount yourAccount = createOrLogIn.signIn();
        yourAccount.hoverOver();
        CasualDresses casualDresses = yourAccount.clickCasualDresses();
        QuickView quickView = casualDresses.clickQuickView();
        quickView.increaseNrProducts();
        quickView.setChangeSize("2");
        PopUpCart popUpCart = quickView.clickAddCart();
        Cart cart = popUpCart.clickProceedToCheckout();
        Assert.assertEquals("Sku test", "SKU : demo_3" ,cart.getSku().getText());
        Assert.assertEquals("Total price test", cart.getTotalPay(), cart.getTotalPrice().getText());
    }
}

