package com.store.catalog.service.creditcard.impl;
//package ser/main/java/com.store.catalog.model.VerifyCCResult

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.store.catalog.common.exception.CheckException;
import com.store.catalog.model.CreditCardDTO;

import com.store.catalog.model.VerifCCResult;

import static org.junit.Assert.*;

/**
 * Created by zouheir on 02/12/2016.
 */
public class CreditCardServiceImplTest {

	private CreditCardDTO creditCardDTO;
	private CreditCardServiceImpl creditCardService;

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
    	assertEquals(VerifCCResult.OK,creditCardService.verifyCreditCard(creditCardDTO));
    	
	}
	
	@Test
    public void testVerifyCreditCard1() throws CheckException {
    	
    	creditCardDTO.setCreditCardNumber("0");
    	assertEquals(VerifCCResult.OK,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
	
	@Test
    public void testVerifyCreditCard2() throws CheckException {
    	
    	creditCardDTO.setCreditCardNumber("34");
    	assertEquals(VerifCCResult.OK,creditCardService.verifyCreditCard(creditCardDTO));

    }
    
    @Test
    public void testVerifyCreditCard3() throws CheckException {
    	
    	creditCardDTO.setCreditCardNumber("042");
    	assertEquals(VerifCCResult.KO,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
    
    @Test
    public void testVerifyCreditCard4() throws CheckException {

    	creditCardDTO.setCreditCardNumber("982487086");
    	assertEquals(VerifCCResult.OK,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
    
    @Test
    public void testVerifyCreditCard5() throws CheckException {

    	creditCardDTO.setCreditCardNumber("982487087");
    	assertEquals(VerifCCResult.KO,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
    
    @Test
    public void testVerifyCreditCard6() throws CheckException {

    	creditCardDTO.setCreditCardNumber("4975050002071221");
    	assertEquals(VerifCCResult.OK,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
    
    @Test
    public void testVerifyCreditCard7() throws CheckException {

    	creditCardDTO.setCreditCardNumber("4975050102071221");
    	assertEquals(VerifCCResult.KO,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
    
    @Test
    public void testVerifyCreditCard8() throws CheckException {

    	creditCardDTO.setCreditCardNumber("49750501020712 21");
    	assertEquals(VerifCCResult.KO,creditCardService.verifyCreditCard(creditCardDTO));
    	
    }
}
