package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("user is on login page")
    public void user_is_on_login_page() throws PendingException {
        System.out.println("Given ->> Hello, User must be on logging page");
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws PendingException {
        System.out.println("When ->> Hello, User must enter his credentials");
        throw new io.cucumber.java.PendingException();
    }
    @And("click on login button")
    public void click_on_login_button() throws PendingException {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user is login successfully")
    public void user_is_login_succesfully() throws PendingException {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
