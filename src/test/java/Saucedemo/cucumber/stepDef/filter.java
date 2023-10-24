package Saucedemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class filter {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("user is on product page")
    public void userIsOnProductPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("user click filter box on the the right side and user click name a till z")
    public void userClickFilterBoxOnTheTheRightSideAndUserClickNameATillZ() {
        WebElement btnClick = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select filter = new Select(btnClick);
        filter.selectByVisibleText("Name (A to Z)");
    }

    @Then("user see the product already sorted by A-Z")
    public void userSeeTheProductAlreadySortedByAZ() {
        String barang = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(barang,"Sauce Labs Backpack");
        driver.close();
    }

    @When("user click filter box on the the right side and user click name Z till A")
    public void userClickFilterBoxOnTheTheRightSideAndUserClickNameZTillA() {
        WebElement btnClick = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select filter = new Select(btnClick);
        filter.selectByVisibleText("Name (Z to A)");
    }

    @Then("user see the product already sorted by Z-A")
    public void userSeeTheProductAlreadySortedByZA() {
        String barang2 = driver.findElement(By.xpath("//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']")).getText();
        Assert.assertEquals(barang2,"Test.allTheThings() T-Shirt (Red)");
        driver.close();
    }

    @When("user click filter box on the the right side and user click price low to high")
    public void userClickFilterBoxOnTheTheRightSideAndUserClickPriceLowToHigh() {
        WebElement btnClick = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select filter = new Select(btnClick);
        filter.selectByVisibleText("Price (low to high)");
    }

    @Then("user see the product already sorted Low-High")
    public void userSeeTheProductAlreadySortedLowHigh() {
        String barang3 = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Onesie']")).getText();
        Assert.assertEquals(barang3,"Sauce Labs Onesie");
        driver.close();
    }

    @When("user click filter box on the the right side and user click price high to low")
    public void userClickFilterBoxOnTheTheRightSideAndUserClickPriceHighToLow() {
        WebElement btnClick = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select filter = new Select(btnClick);
        filter.selectByVisibleText("Price (high to low)");
    }

    @Then("user see the product already sorted High-Low")
    public void userSeeTheProductAlreadySortedHighLow() {
        String barang4 = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']")).getText();
        Assert.assertEquals(barang4,"Sauce Labs Fleece Jacket");
        driver.close();
    }
}
