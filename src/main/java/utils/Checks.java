package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Checks {
	
	protected Checks() {
		
	}
	
	static public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	static public boolean isElementDisplayed(WebDriver driver, By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	static public boolean isElementEnabled(WebDriver driver, By by) {
		try {
			return driver.findElement(by).isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
