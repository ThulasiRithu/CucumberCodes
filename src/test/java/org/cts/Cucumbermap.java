package org.cts;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Cucumbermap {
	static WebDriver driver;

@Given("User want to launch the browser")
public void user_want_to_launch_the_browser() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\USER\\Xpath\\driv\\chromedriver.exe");
	driver = new ChromeDriver();
	System.out.println("Given");
	driver.get("http://demo.guru99.com/telecom/");
    driver.findElement(By.xpath("(//a[text()='Add Customer']) [1]")).click();
    driver.findElement(By.xpath("//label[text()='Done']")).click();
}
@When("User click add the customer")
public void user_click_add_the_customer(DataTable custdetails) {
Map<String, String> custData = custdetails.asMap(String.class, String.class);
driver.findElement(By.id("fname")).sendKeys(custData.get("fname"));
driver.findElement(By.id("lname")).sendKeys(custData.get("lname"));
driver.findElement(By.id("email")).sendKeys(custData.get("email"));
driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(custData.get("address"));
driver.findElement(By.id("telephoneno")).sendKeys(custData.get("phno"));
driver.findElement(By.xpath("//input[@type='submit']")).click();
}

@When("User click the add tariff")
public void user_click_the_add_tariff(DataTable TarrifDetails) {
	Map<String, String> Tarrif = TarrifDetails.asMap(String.class, String.class);
    System.out.println("Enter the customer id");
    WebElement txt = driver.findElement(By.tagName("h3"));
	String customerID = txt.getText();
	driver.findElement(By.xpath("//a[@class='button']")).click();
	driver.findElement(By.xpath("(//a[text()='Add Tariff Plan to Customer'])[1]")).click();	
	WebElement custId = driver.findElement(By.xpath("//input[@id='customer_id']"));
	custId.sendKeys(customerID);
	driver.findElement(By.xpath("//input[@class='fit']")).click();
	}
@Then("User validate the CustID")
public void user_validate_the_CustID() {
	Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
	System.out.println("Welcome to add customer tarrif plan");
   
}
}