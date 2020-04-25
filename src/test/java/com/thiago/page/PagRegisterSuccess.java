package com.thiago.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;

public class PagRegisterSuccess extends CorePage<PageRegisterGuru> {
	
	String NOME_ESPERADO = "";
	String EMAIL_ESPERADO = "";
	
	public PagRegisterSuccess() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	public PagRegisterSuccess(String firstName, String email2) {
		this.NOME_ESPERADO = firstName;
		this.EMAIL_ESPERADO = email2;
	}

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")
	private WebElement nameRegister;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b")
	private WebElement email;
	
	public void sucessoRegistro() {
		
		String nomeElemento = nameRegister.getText().replace(",","");
		String emailElemento = email.getText();
		assertEquals(nomeElemento, "Dear " + NOME_ESPERADO);
		assertTrue(emailElemento.contains(EMAIL_ESPERADO), "E-mail de retorno incorreto");
	}
	
}
