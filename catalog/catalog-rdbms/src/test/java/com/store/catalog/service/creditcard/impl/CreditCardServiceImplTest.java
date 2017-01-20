package com.store.catalog.service.creditcard.impl;
//package ser/main/java/com.store.catalog.model.VerifyCCResult

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.store.catalog.common.exception.CheckException;
import com.store.catalog.model.CreditCardDTO;

import static org.junit.Assert.*;

/**
 * Created by zouheir on 02/12/2016.
 */
public class CreditCardServiceImplTest {

	private CreditCardDTO creditCardDTO;
	private CreditCardServiceImpl creditCardService;
	
	public enum VerifCCResult {

	    OK, KO
	}

	@Before
	public void setUp(){
		creditCardDTO = new CreditCardDTO();
		creditCardService = new CreditCardServiceImpl();
	}
	
	@After
	public void tearDown(){
		creditCardDTO = null;
		creditCardService = null;
	}
	
	@Test(expected=NumberFormatException.class)
	public void testCard() throws NumberFormatException {
		
		creditCardDTO.setCreditCardNumber("AAADE");
		creditCardService.verifyCreditCard(creditCardDTO);
		
	}
	
	@Test
    public void testVerifyCreditCard() throws CheckException {
    
		creditCardDTO.setCreditCardNumber("4563960122001999");
    	assertEquals(true,creditCardService.verifyCreditCard(creditCardDTO));
    	
	}
	
	@Test
    public void testVerifyCreditCard1() throws CheckException {
    	
    	creditCardDTO.setCreditCardNumber("0");
    	assertEquals(true,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
	
	@Test
    public void testVerifyCreditCard2() throws CheckException {
    	
    	creditCardDTO.setCreditCardNumber("34");
    	assertEquals(true,creditCardService.verifyCreditCard(creditCardDTO));

    }
    
    @Test
    public void testVerifyCreditCard3() throws CheckException {
    	
    	creditCardDTO.setCreditCardNumber("042");
    	assertEquals(true,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
    
    @Test
    public void testVerifyCreditCard4() throws CheckException {

    	creditCardDTO.setCreditCardNumber("972487086");
    	assertEquals(true,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
    
    @Test
    public void testVerifyCreditCard5() throws CheckException {

    	creditCardDTO.setCreditCardNumber("972487087");
    	assertEquals(false,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
}
