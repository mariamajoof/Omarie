package com.tsi.mariama.joof.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TitleNavStep {

    private final String homePageUrl= "http://localhost:3000/";
    private WebDriver driver;

    @Given("The Home page is loaded")
    public void the_home_page_is_loaded() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\joofw\\OneDrive\\Documents\\TSI\\selenium\\chromedriver_win32\\chromedriver.exe");
    // this set the new driver.
    driver = new ChromeDriver();
    driver.get("http://localhost:3000/");
    }
    @When("I click the title navigation button")
    public void i_click_the_title_navigation_button() {
        driver.findElement(By.id("navTitle")).click();
    }
    @Then("Navigate to the title page as expected")
    public void navigate_to_the_title_page_as_expected() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, homePageUrl + "title","Invalid Page");
        driver.quit();
    }
}
