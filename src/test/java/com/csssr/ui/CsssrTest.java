
package com.csssr.ui;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.csssr.DriverFactory;
import com.csssr.ReadPropertyFile;

public class CsssrTest {
	DriverFactory objDriver = new DriverFactory();
	ReadPropertyFile readPropertyFile = new ReadPropertyFile();
	Csssr csssr;
	String BASEURL = "http://csssr.github.io/qa-engineer/";

	@Before
	public void setUp() throws IOException, InterruptedException {
		csssr = new Csssr(objDriver.getDriver());
		csssr.setWindowsSize(ReadPropertyFile.getVallueWithComma("size").get(0),
				ReadPropertyFile.getVallueWithComma("size").get(1));
		objDriver.getDriver().navigate().to(BASEURL);
	}

	@After
	public void tearDown() {
		objDriver.quitDriver();
	}

	@Test
	public void mySimpleEqualsTest() throws InterruptedException, IOException {
		csssr.waitForElement(csssr.goodTitle);
		// Field must be displayed.
		Assert.assertTrue(csssr.goodTitle.isDisplayed());
		// Сlick on an already selected item.
		csssr.graphsDetails.click();
		// Waiting for animation.
		Thread.sleep(1000);
		// Field must be displayed.
		Assert.assertTrue(csssr.goodTitle.isDisplayed());
	}
}
