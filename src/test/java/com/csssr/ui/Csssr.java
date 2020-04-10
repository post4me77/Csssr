package com.csssr.ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csssr.BasePageObject;

public class Csssr extends BasePageObject {

	public Csssr(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='info-details']")
	WebElement goodTitle;

	@FindBy(xpath = "//*[@class='graphs-details graph-active']/a")
	WebElement graphsDetails;

	public void waitForElement(WebElement element) throws IOException, InterruptedException {
		waitUntilElementIsLoaded(element);
	}
}
