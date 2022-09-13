package com.stepDefinition;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.List;

import org.testng.Assert;

import com.iris22.pages.HomePage;
import com.iris22.util.Environment;
import com.iris22A.keywords.UIKeyword;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsSteps {
	@Given("क्रोम ब्राउजर ओपन होना चाहिए")
	public void openBrowser() {
		UIKeyword.openBrowser("Chrome");
	}
	@And("myntra पेज ओपन होना चाहिए")
	public void launchMyntra() {
		UIKeyword.launchUrl(Environment.URL);
	}
	
	@When("user searches for polo t shirts")
	public void searchPoloTshirts() throws AWTException {
		HomePage home = new HomePage();
		home.searchProduct("Polo");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
	}
	@Then("all results should be related to polo")
	public void verifyAllResults() {
		HomePage home = new HomePage();
		List<String> productTexts= home.getSearchResultTexts();
		for (String text : productTexts) {
			Assert.assertTrue(text.toLowerCase().contains("Polo"),"Product is mismatch "+text);
		}
	}
}
