package com.thiago.teste;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thiago.core.InvokedMethodListener;
import com.thiago.page.DeletePage;

@Listeners(InvokedMethodListener.class)
public class DeletePageTest {
	
	@Test
	public void testar() {
		new DeletePage()
				.openPage(DeletePage.class, "http://demo.guru99.com/test/delete_customer.php")
				.testDeleteCustomer();
		
	}

}
