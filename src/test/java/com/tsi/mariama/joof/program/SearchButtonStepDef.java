package com.tsi.mariama.joof.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchButtonStepDef {

    private final String homePageUrl= "http://localhost:3000/";
    private WebDriver driver;

    @Given("That the search button is display")
    public void that_the_search_button_is_display() {

    // This set the driver pad
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\joofw\\OneDrive\\Documents\\TSI\\selenium\\chromedriver_win32\\chromedriver.exe");
    // This set the new driver.
    driver = new ChromeDriver();
    driver.get("http://localhost:3000/title");

    }
    @When("I click the search button")
    public void i_click_the_search_button() {
        driver.findElement(By.id("keySearchTitle")).click();

    }
    @Then("Display the requested data")
    public void display_the_requested_data() {
    // Write code here that turns the phrase above into concrete actions

    }
}
