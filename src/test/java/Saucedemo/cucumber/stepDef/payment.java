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

public class payment {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user already login in the website")
    public void userAlreadyLoginInTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click AddToCart button on the product column")
    public void userClickAddToCartButtonOnTheProductColumn() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("user click cart icon on the top right side")
    public void userClickCartIconOnTheTopRightSide() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("click the checkout button")
    public void clickTheCheckoutButton() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("user fill the biodata form")
    public void userFillTheBiodataForm() {
        driver.findElement(By.id("first-name")).sendKeys("Nola");
        driver.findElement(By.id("last-name")).sendKeys("Olala");
        driver.findElement(By.id("postal-code")).sendKeys("1234");

    }

    @And("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("user finish overview shopping list")
    public void userFinishOverviewShoppingList() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user should see checkout complete page")
    public void userShouldSeeCheckoutCompletePage() {
        String finish = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assert.assertEquals(finish,"Thank you for your order!");
        driver.close();
    }

    @And("user click continue button without fill the form")
    public void userClickContinueButtonWithoutFillTheForm() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("user will see error message in form page")
    public void userWillSeeErrorMessageInFormPage() {
        String finish = driver.findElement(By.xpath("//h3[normalize-space()='Error: First Name is required']")).getText();
        Assert.assertEquals(finish,"Error: First Name is required");
        driver.close();
    }
}
