package com.thiago.teste;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.DemoLoginPage;

@Listeners(InvokedMethodListener.class)
public class DemoLoginTest {
	
	final String URL = "http://demo.guru99.com/test/login.html";
	final String LOGIN = "david@hotmail.com";
	final String SENHA = "teste123";
	
    @Test
    public void testLoginPage() {
    	
    	new DemoLoginPage()
    			.openPage(DemoLoginPage.class, URL)
    			.acessarLoginGuru(LOGIN, SENHA)
    			.validarSucessoAcesso();
    	
    }
    
}
