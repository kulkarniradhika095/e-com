package com.iris22.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22A.keywords.UIKeyword;

public class MenTshirtPage {
	
	@FindBy(xpath = "//div[@class='sort-sortBy']")
	public WebElement sortByFilter;
	@FindBy(xpath = "(//h4[@class='atsa-title'])[2]")
	public WebElement countryOfOrigin;
	@FindBy(xpath = "//input[@value='popularity']")
	public WebElement popularityFilter;
	@FindBy(xpath = "(//label[@class='sort-label '])[2]")
	public WebElement whatsNewFilter;
	@FindBy(xpath = "(//label[@class='sort-label '])[4]")
	public WebElement betterDiscountFilter;
	
	public MenTshirtPage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}
	
	
	public void clickOnSortByFilter() {
		sortByFilter.click();
	}
	public void selectPopularityFilter() throws InterruptedException {
		UIKeyword.mouseMove(sortByFilter);
		UIKeyword.click(popularityFilter);
	}
	public void selectWhatsNewFilter() {
		
	}
	public void selectBetterDiscountFilter() {

	}
}
