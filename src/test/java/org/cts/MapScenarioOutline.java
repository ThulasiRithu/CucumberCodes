package org.cts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MapScenarioOutline {
	static WebDriver driver;
	@Given("User launch the broser")
	public void user_launch_the_broser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USER\\Xpath\\driv\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Given");
		driver.get("http://demo.guru99.com/telecom/");
	    driver.findElement(By.xpath("(//a[text()='Add Customer']) [1]")).click();
	    driver.findElement(By.xpath("//label[text()='Done']")).click();

	    }

	@When("User add the cust details{string},{string},{string},{string},{string}")
	public void user_add_the_cust_details(String S1, String S2, String S3, String S4, String S5) {
		driver.findElement(By.id("fname")).sendKeys(S1);
		driver.findElement(By.id("lname")).sendKeys(S2);
		driver.findElement(By.id("email")).sendKeys(S3);
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(S4);
		driver.findElement(By.id("telephoneno")).sendKeys(S5);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		}

	@When("User tarrif details")
	public void user_tarrif_details() {
	    System.out.println("Enter the customer id");
	    WebElement txt = driver.findElement(By.tagName("h3"));
		String customerID = txt.getText();
		driver.findElement(By.xpath("//a[@class='button']")).click();
		driver.findElement(By.xpath("(//a[text()='Add Tariff Plan to Customer'])[1]")).click();	
		WebElement custId = driver.findElement(By.xpath("//input[@id='customer_id']"));
		custId.sendKeys(customerID);
		driver.findElement(By.xpath("//input[@class='fit']")).click();
		 }

	@Then("User validate outcomes")
	public void user_validate_outcomes() {
		Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
		System.out.println("Welcome to add customer tarrif plan");
	      }
}
