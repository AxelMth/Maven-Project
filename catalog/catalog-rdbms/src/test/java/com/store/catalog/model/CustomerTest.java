package com.store.catalog.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.store.catalog.common.exception.CheckException;

public class CustomerTest {

	private Customer client;
	
	@Before
	public void setUp() {
		client = new Customer();
	}
	
	@After
	public void cleanUp() {
		client = null;
	}
    
	@Test(expected=CheckException.class)
    public void testPasswordIsNull() throws CheckException {
    	client.setPassword(null);
    	if (client.getPassword() == null)
    		throw new CheckException("Password is null");
    }
    
    @Test(expected=CheckException.class)
    public void testPasswordIsEmpty() throws CheckException {
    	client.setPassword("");
    	if (client.getPassword() == "")
    		throw new CheckException("Password is empty");
    }

    @Test(expected=CheckException.class)
    public void testNotMatchingPassword () throws CheckException {
    	String password = "password";
    	client.setPassword(password + "wrong");
    	if (!password.equals(client.getPassword()))
    		throw new CheckException ("Password not matching");
    }
    
    @Test
    public void testAnotherMatchPassword() throws CheckException {
    	client.setPassword("password");
    	if (!client.anotherMatchPassword("password"))
    		throw new CheckException("Method anotherMatchPassword not working");
    }
    
}