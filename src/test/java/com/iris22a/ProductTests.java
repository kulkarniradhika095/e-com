package com.iris22a;
/**
 * @author radhi
 * com.iris22a contains all the functional test cases
 * 
 */
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22.pages.CasualShirtsPage;
import com.iris22.pages.HomePage;
import com.iris22.util.Environment;
import com.iris22.util.PropUtil;
import com.iris22.util.WaitFor;
import com.iris22A.config.TestBase;
import com.iris22A.keywords.UIKeyword;

public class ProductTests extends TestBase {
	private static final Logger log = Logger.getLogger(ProductTests.class);
	
	@Test
	public void verifySearchResultForPoloMen() throws InterruptedException {
		PropUtil repo = new PropUtil();
		UIKeyword.launchUrl(Environment.URL);
		UIKeyword.getTexts(By.xpath(repo.getLocator("search_Products_txtBx")[0]));
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
		List<String> productTitles = UIKeyword.getTexts(By.xpath(repo.getLocator("product_titles_txt")[0]));
		for (String productTitle : productTitles) {
			Assert.assertTrue(productTitle.contains("polo"),"Product title doesn't contains polo: "+productTitle);
		}
		
	}
	@Test
	public void verifyCategoryListForTopWears() {
		List<String> expected = new ArrayList<String>();
		expected.add("Tshirts");
		expected.add("Shirts");
		expected.add("Sweatshirts");
		expected.add("Kurtas");
		expected.add("Jackets");
		expected.add("Sweaters");
		expected.add("Blazers");
		PropUtil repo = new PropUtil();
		UIKeyword.launchUrl(Environment.URL);
		UIKeyword.mouseMove(repo.getLocator("men_menu")[0],repo.getLocator("men_menu")[1]);
		UIKeyword.click(repo.getLocator("menu_topwear")[0],repo.getLocator("menu_topwear")[1]);
		WaitFor.elementToBePresent(repo.getLocator("categories_text")[0],repo.getLocator("categories_text")[1]);
		List<String> ActualCategories = UIKeyword.getTexts(repo.getLocator("categories_text")[0],repo.getLocator("categories_text")[1]);
		for (int i=0; i<ActualCategories.size(); i++) {
			ActualCategories.set(i,ActualCategories.get(i).split("(")[0]);
		}
		Assert.assertTrue(ActualCategories.containsAll(expected),"List didn't match: expected: "+expected+"\n Actual:"+ActualCategories);
		
	}
	
	@Test
	public static void verifyItemCountOfCasualShirts() {
		UIKeyword.launchUrl(Environment.URL);
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
		WaitFor.time(3);
		home.clickOnCasualShirts();
		WaitFor.time(3);
		CasualShirtsPage casual = new CasualShirtsPage();
		int itemCount = casual.getItemCount();
		log.info(itemCount);
		
	}
}
