package com.iris22.pages;


import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22A.keywords.UIKeyword;

public class HomePage{
	private static final Logger log = Logger.getLogger(HomePage.class);
	
	//Pagefactory
	@CacheLookup
	@FindBy(xpath = "//a[@href='/shop/men']")
	public WebElement menMenu; 
	
	@FindBy(xpath = "//a[@class='desktop-categoryName']")
	public WebElement menTshirt; 
	
	@FindBy(xpath = "//a[@href=\"/men-casual-shirts\"]")
	public WebElement casualShirts;
	
	@FindBy(css = "div.desktop-query>input.desktop-searchBar")
	public WebElement searchComponent;
	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTexts;
	
	public HomePage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}
	public void hoverOnMenMenu() {
		UIKeyword.mouseMove(menMenu);
	}
	public void clickOnMenTshirt() {
		UIKeyword.click(menTshirt);
	}
	public void searchProduct(String productName) {
		UIKeyword.enterText(searchComponent, productName);
	}

	public void clickOnCasualShirts() {
		casualShirts.click();
		log.info("Clicked on casual shirts");
	}
	public List<String> getSearchResultTexts() {
		List<String> productTexts = new ArrayList<String>();
		for (WebElement product : this.productTexts) {
			productTexts.add(product.getText());
		}
		return productTexts;
	}
}
