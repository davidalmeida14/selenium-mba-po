package com.thiago.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import com.thiago.dto.UsuarioDTO;

public class PageRegisterGuru extends CorePage<PageRegisterGuru>{

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
	private WebElement firstName;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")
	private WebElement lastName;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")
	private WebElement phone;

	@FindBy(xpath = "//*[@id=\"userName\"]")
	private WebElement email;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")
	private WebElement address;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")
	private WebElement city;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")
	private WebElement state;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")
	private WebElement postalCode;
	
	@FindBy(name = "country")
	private WebElement country;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement userName;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")
	private WebElement passWord;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input")
	private WebElement button;
	
	public PageRegisterGuru() {
		this.driver = TLDriverFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}
	/** 
	 * Método para teste de registro no site Guru
	 * @param usuario
	 * @return {@link PagRegisterSuccess}
	 */
	public PagRegisterSuccess registerUserGuru(UsuarioDTO usuario){
		
		// Preenchimento dos campos
		
		preencherCampo(firstName, usuario.getFirstName());
		preencherCampo(lastName, usuario.getLastName());
		preencherCampo(phone, usuario.getPhone());
		preencherCampo(email, usuario.getEmail());
		preencherCampo(address, usuario.getAddress());
		preencherCampo(city, usuario.getCity());
		preencherCampo(state, usuario.getState());
		preencherCampo(postalCode, usuario.getPostalCode());
		selectElementByVisibleValue(country, "BRAZIL");
		preencherCampo(userName, usuario.getUserName());
		preencherCampo(passWord, usuario.getPassWord());
		preencherCampo(confirmPassword, usuario.getConfirmPassword());
		
		// Asserts
		
		assertNotNull(userName.getText(), "Usuário não pode ser nulo.");
		assertEquals(passWord.getText(), confirmPassword.getText());
		assertNotNull(email.getText(), "E-mail está nulo");
		assertTrue(isEmailValido(usuario.getEmail()), "E-mail não é válido");
		
		click(button);
		
		return new PagRegisterSuccess(usuario.getFirstName() + " " + usuario.getLastName(), usuario.getEmail());
		
	}

	private boolean isEmailValido(String email) {
		return email.contains("@");
	}
	
}
