package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.AdminLoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.DriverManager;

public class AdminLoginSteps extends CommonMethods {

    AdminLoginPage adminLoginPage = new AdminLoginPage();


    @Given("the admin is on the HRMS login page")
    public void adminIsOnLoginPage() {
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
        DriverManager.getDriver().manage().window().maximize();
    }

    @When("the admin enters valid username and password")
    public void adminEntersCredentials() {
        sendText(adminLoginPage.usernameField, ConfigReader.getProperty("username"));
        sendText(adminLoginPage.passwordField, ConfigReader.getProperty("password"));
    }

    @When("clicks the login button")
    public void adminClicksLogin() {
        click(adminLoginPage.loginButton);
    }

    @Then("the admin should be successfully logged in")
    public void verifyAdminLogin() {
        String actualText = adminLoginPage.dashboardHeader.getText();
        System.out.println("Dashboard text: " + actualText);
    }


    @When("the admin enters invalid username and password")
    public void adminEntersInvalidCredentials() {
        sendText(adminLoginPage.usernameField, "wrongAdmin");
        sendText(adminLoginPage.passwordField, "wrongPass");
    }

    @Then("an error message should be displayed")
    public void verifyInvalidLoginMessage() {
        String actualError = adminLoginPage.invalidLoginMessage.getText();
        System.out.println("Invalid login message: " + actualError);
    }


    @When("the admin enters correct username and wrong password")
    public void adminEntersCorrectUsernameWrongPassword() {
        sendText(adminLoginPage.usernameField, "admin");
        sendText(adminLoginPage.passwordField, "wrongPass");
    }


    @When("the admin enters wrong username and correct password")
    public void adminEntersWrongUsernameCorrectPassword() {
        sendText(adminLoginPage.usernameField, "wrongAdmin");
        sendText(adminLoginPage.passwordField, "syntax123");
    }


    @When("the admin enters empty username and valid password")
    public void adminEntersEmptyUsername() {
        sendText(adminLoginPage.usernameField, "");
        sendText(adminLoginPage.passwordField, "syntax123");
    }


    @When("the admin enters valid username and empty password")
    public void adminEntersEmptyPassword() {
        sendText(adminLoginPage.usernameField, "admin");
        sendText(adminLoginPage.passwordField, "");
    }


    @When("the admin enters empty username and empty password")
    public void adminEntersBothEmpty() {
        sendText(adminLoginPage.usernameField, "");
        sendText(adminLoginPage.passwordField, "");
    }


    @Then("a required message should be displayed")
    public void verifyRequiredMessage() {
        String requiredText = adminLoginPage.requiredFieldMessage.getText();
        System.out.println("Required message: " + requiredText);
    }
}








