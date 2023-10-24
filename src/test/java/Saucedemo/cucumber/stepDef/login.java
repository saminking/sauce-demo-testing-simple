package Saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user open the website")
    public void user_open_the_browser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @When("user input invalid username")
    public void userInputInvalidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_users");
    }

    @And("input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("random123");
    }

    @Then("user should see error message")
    public void userShouldSeeErrorMessage() {
        String pgError = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]")).getText();
        Assert.assertEquals(pgError,"Epic sadface: Username and password do not match any user in this service");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.close();
    }



    @When("user input valid username")
    public void userInputValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input valid password")
    public void inputValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login")
    public void userClickLogin() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("user should see products page")
    public void userShouldSeeProductsPage() {
        String page = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(page,"Products");
        driver.close();
    }
}
