package com.iris22a;


import org.testng.annotations.Test;

import com.iris22.pages.HomePage;
import com.iris22.pages.MenTshirtPage;
import com.iris22.util.Environment;
import com.iris22.util.WaitFor;
import com.iris22A.config.TestBase;
import com.iris22A.keywords.UIKeyword;

public class MenTshirtsTests extends TestBase {
	
	@Test
	public void verifySearchByPopularityYeildsProperResults() throws InterruptedException {
		UIKeyword.launchUrl(Environment.URL);
		
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
		WaitFor.elementToBeClickable(home.menTshirt);
		home.clickOnMenTshirt();
		
		MenTshirtPage menTShirt = new MenTshirtPage();
		WaitFor.elementToBeClickable(menTShirt.sortByFilter);
		menTShirt.selectPopularityFilter();
	}
	
}
