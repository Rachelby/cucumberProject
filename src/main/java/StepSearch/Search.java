package StepSearch;

import static org.junit.Assert.assertTrue;
import static utils.Checks.isElementPresent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search {
	
	private WebDriver driver;
	
	// Research test
	// Set up du test, on ouvre un navigateur qui va sur jobnroll.fr
	@Before
	public void setUp2() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver(new ChromeOptions().addArguments("disable-infobars"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jobnroll.fr/search#body-content");
		 
	}
	
	@Given("^User is on research page$")
	public void user_is_on_research_page() throws Throwable {
		// Etre sur la page de recherche du site
		assertTrue(isElementPresent(driver, By.id("search")));
		Thread.sleep(2000);
	}
	
	@When("^User click on research$")
	public void user_click_on_research() throws Throwable {
		//Click sur le bouton de recherche
		driver.get("https://www.jobnroll.fr/search#body-content");
		Thread.sleep(2000);
	}
	
	@When("^User click on recherche avance$")
	public void user_click_on_recherche_avance() throws Throwable {
		// This  will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,-400)");
		driver.findElement(By.id("custom-search-button")).click();
		Thread.sleep(2000);
	}

	@When("^research with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void research_with_and(String arg1, String arg2) throws Throwable {
		// L'utilisateur tape un critere1
		driver.findElement(By.id("autocomplete_address")).sendKeys(arg1);
	    // L'utilisateur tape un critere2
		driver.findElement(By.id("sector")).sendKeys(arg2);
		Thread.sleep(2000);
	}

	@When("^click on button research$")
	public void click_on_button_research() throws Throwable {
		// Appuyer sur le bouton de recherche
		driver.findElement(By.className("button-search")).click();
		Thread.sleep(2000);
	}

	@Then("^Page result is affiche$")
	public void page_result_is_affiche() throws Throwable {
		// Wait for 5 seconds
		Thread.sleep(5000);
		isElementPresent(driver, By.className("list-adv"));
		
	}
	
	// Après le test, on ferme le navigateur
	@After
	public void tearDown() {
		driver.quit();
	}
	// End Research test


}
