package com.tsi.mariama.joof.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActorNavStepDef {
    private final String homePageUrl= "http://localhost:3000/";
    private WebDriver driver;


    @Given("The landing page is loaded")
    public void the_landing_page_is_loaded() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\joofw\\OneDrive\\Documents\\TSI\\selenium\\chromedriver_win32\\chromedriver.exe");
        // this set the new driver.
        driver = new ChromeDriver();

        driver.get("http://localhost:3000/");
   }
    @When("I click the Actor name navigation button")
    public void i_click_the_actor_name_navigation_button() {

        driver.findElement(By.id("navActorName")).click();
    }
    @Then("I should be navigated to the actor name page")
    public void i_should_be_navigated_to_the_actor_name_page() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, homePageUrl + "actorname","Invalid Page");
        driver.quit();
    }
}
