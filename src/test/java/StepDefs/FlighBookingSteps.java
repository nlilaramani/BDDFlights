/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepDefs;

import com.bdd.sel.test.SeleniumUtils;
import static cucumber.api.HookType.Before;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import java.util.List;
import junit.framework.Assert;
//import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.java.After;
import cucumber.api.java.Before;

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
     @Then("Flight Search Page is displayed")
    public void validateProfilePage(){
        String title=driver.getTitle();
        String expTitle="Find a Flight: Mercury Tours:";
        Assert.assertEquals(expTitle, title);
    }
    @Given("User is logged in")
    public void userIsLoggedIn(){
        navigateToHomePage();
        performLogin();
    }
    @When("User enters following search criteria")
    public void enterSearchCriteria(DataTable dt){
        List<String> data=dt.asList();
        if(data.get(0).equalsIgnoreCase("roundtrip")){
            driver.findElements(By.name("tripType")).get(0).click();
        }else{
            driver.findElements(By.name("tripType")).get(1).click();   
        }
        driver.findElement(By.name("passCount")).sendKeys(data.get(1));
        driver.findElement(By.name("fromPort")).sendKeys(data.get(2));
        driver.findElement(By.name("fromMonth")).sendKeys(data.get(3));
        driver.findElement(By.name("fromDay")).sendKeys(data.get(4));
        driver.findElement(By.name("toPort")).sendKeys(data.get(5));
        driver.findElement(By.name("toMonth")).sendKeys(data.get(6));
        driver.findElement(By.name("toDay")).sendKeys(data.get(7));
        if(data.get(8).equalsIgnoreCase("economy")){
            driver.findElements(By.name("servClass")).get(0).click();
        }else{
            driver.findElements(By.name("servClass")).get(1).click();
        }
        driver.findElement(By.name("findFlights")).click();
    }
    @Then("matching flights are displayed")
    public void verifyFlightResults(){
        Assert.assertEquals("Select a Flight: Mercury Tours", driver.getTitle());
    }
    @When("User selects following flights")
    public void selectFlights(DataTable dt){
        List<String> data=dt.asList();
        driver.findElements(By.name("outFlight")).get(Integer.parseInt(data.get(0))).click();
        driver.findElements(By.name("inFlight")).get(Integer.parseInt(data.get(1))).click();
        driver.findElement(By.name("reserveFlights")).click();
   
    }
    @And("User enters following passenger details")
     public void enterPassengerDetails(DataTable dt){
         List<String> data=dt.asList();
         driver.findElement(By.name("passFirst0")).clear();
         driver.findElement(By.name("passFirst0")).sendKeys(data.get(0));
         driver.findElement(By.name("passLast0")).sendKeys(data.get(1));
         driver.findElement(By.name("creditnumber")).sendKeys(data.get(2));
         driver.findElement(By.name("buyFlights")).click();
         
     }
     @Then("System displays flight confirmation")
     public void verifyConfirmation(){
         Assert.assertEquals("Flight Confirmation: Mercury Tours", driver.getTitle());
     }
     
     // Hooks
     @Before
     public void setUp(Scenario scenario){
        System.out.println(scenario.getName()); 
     }
     @After
     public void tearDown(Scenario scenario){
         
         if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
     }
}
