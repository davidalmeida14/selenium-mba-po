package com.thiago.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;

public class DeletePage extends CorePage<DeletePage> {

	public DeletePage() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "submit")
	WebElement submit;
	
	public void testDeleteCustomer() {
		
		preencherCampo(customerId, "445485");
		click(submit);
		Alert alert = this.driver.switchTo().alert();
		alert.accept();
		Alert alertSuccess = this.driver.switchTo().alert();
		assertNotNull(alert.getText(), "Alerta nulo");
		assertEquals("Customer Successfully Delete!", alertSuccess.getText());
		
	}
}
