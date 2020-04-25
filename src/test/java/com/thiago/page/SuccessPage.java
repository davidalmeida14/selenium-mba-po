package com.thiago.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;

public class SuccessPage extends CorePage<SuccessPage>{
	
	final String TEXT_ESPERADO = "Successfully Logged in...";
	
	public SuccessPage() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[2]/div/div/h3")
	private WebElement sucessoText;

	public void validarSucessoAcesso() {
		assertEquals(sucessoText.getText(), TEXT_ESPERADO);
	}

}
