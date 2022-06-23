package com.tsi.mariama.joof.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatNavStepDef {

    private final String homePageUrl= "http://localhost:3000/";
    private WebDriver driver;


    @Given("The welcome page is loaded")
    public void the_welcome_page_is_loaded() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\joofw\\OneDrive\\Documents\\TSI\\selenium\\chromedriver_win32\\chromedriver.exe");
        // this set the new driver.
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");

    }
    @When("I click the category navigation button")
    public void i_click_the_category_navigation_button() {
        driver.findElement(By.id("navCategory")).click();

    }
    @Then("I should be redirected to the category page")
    public void i_should_be_redirected_to_the_category_page() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, homePageUrl + "category","Invalid Page");
        driver.quit();
    }
}
