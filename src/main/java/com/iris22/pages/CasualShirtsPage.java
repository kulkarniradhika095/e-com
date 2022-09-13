package com.iris22.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.iris22A.keywords.UIKeyword;

public class CasualShirtsPage {
	
	public By itemCount = By.xpath("(//span[@class='title-count'])");
	
	public int getItemCount() {
		String itemCount =  UIKeyword.driver.findElement(this.itemCount).getText();
		Pattern p = Pattern.compile("//d");
		Matcher m = p.matcher(itemCount);
		String count = m.group();
		return Integer.parseInt(count);
	}
}
