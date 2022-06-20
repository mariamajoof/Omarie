package com.tsi.mariama.joof.program;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SeleniumTest {
    private WebDriver driver;
    //private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        // this set the driver pad
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\joofw\\OneDrive\\Documents\\TSI\\selenium\\chromedriver_win32\\chromedriver.exe");
    // this set the new driver.
        driver = new ChromeDriver();
        //JavascriptExecutor is a medium that enables the WebDriver to interact with HTML elements within the browser
        js = (JavascriptExecutor) driver;
       // vars = new HashMap<String, Object>();
    }

    //After the test is run, it will call this method to quit the driver
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testAllActor() {
        //Get this url
        driver.get("http://localhost:3000/actorname");
        //set the screen size to this size
        driver.manage().window().setSize(new Dimension(640, 672));
        //Find the element in the screen and click on it
        driver.findElement(By.id("clickToDisplay")).click();
    }
}

