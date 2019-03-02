/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepDefs;

import com.bdd.sel.test.SeleniumUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Owner
 */
public class FlighBookingSteps {
    WebDriver driver=SeleniumUtils.getChromeDriver();
    @Given("User is on Home Page")
    public void navigateToHomePage(){
        driver.get("http://newtours.demoaut.com");
        
    }
    @When("User Logs in")
    public void performLogin(){
        driver.findElement(By.name("userName")).sendKeys("mercury");
        driver.findElement(By.name("password")).sendKeys("mercury");
        driver.findElement(By.name("login")).click();
    }
     @Then("User Profile Page is Displayed")
    public void validateProfilePage(){
    }
    
}
