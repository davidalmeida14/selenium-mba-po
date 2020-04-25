package com.thiago.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;

public class DemoLoginPage extends CorePage<DemoLoginPage>{
	
	public DemoLoginPage() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(name = "email")
	private WebElement inputTextEmail;
	
	@FindBy(name = "passwd")
	private WebElement inputTextPassword;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/h3")
	private WebElement sucessoText;
	
	@FindBy(name = "SubmitLogin")
	private WebElement btnLogin;
	
	
	public SuccessPage acessarLoginGuru (String login, String senha) {
		preencherCampo(inputTextEmail, "david_almeida_1@hotmail.com"); 
		preencherCampo(inputTextPassword, "teste123");
		click(btnLogin);
		return new SuccessPage();
	}
	

}
