package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class AdminLoginPage {

    public AdminLoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(),'Invalid')]")
    public WebElement invalidLoginMessage;

    @FindBy(xpath = "//span[contains(text(),'Required')]")
    public WebElement requiredFieldMessage;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    public WebElement dashboardHeader;
}

















