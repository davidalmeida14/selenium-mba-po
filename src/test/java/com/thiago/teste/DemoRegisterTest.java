package com.thiago.teste;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thiago.core.InvokedMethodListener;
import com.thiago.dto.UsuarioDTO;
import com.thiago.page.PageRegisterGuru;

@Listeners(InvokedMethodListener.class)
public class DemoRegisterTest {

	
	final String URL = "http://demo.guru99.com/test/newtours/register.php";
	
	@Test
	public void teste() {

		UsuarioDTO usuario = new UsuarioDTO();
    	usuario.setFirstName("David");
    	usuario.setLastName("Almeida");
    	usuario.setEmail("david@conductor.com.br");
    	usuario.setAddress("Rua");
    	usuario.setCity("Joao");
    	usuario.setUserName(usuario.getEmail());
    	usuario.setPassWord("123");
    	usuario.setConfirmPassword("123");
    	usuario.setCountry("BB");
    	usuario.setPhone("83999946583");
    	usuario.setPostalCode("58084441");
    	usuario.setState("SA");
    	
    	new PageRegisterGuru().openPage(PageRegisterGuru.class,
    									URL)
    						  .registerUserGuru(usuario)
    						  .sucessoRegistro();
    	
    	
	}
	
	
}
