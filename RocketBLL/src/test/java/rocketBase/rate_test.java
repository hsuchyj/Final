package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@Test
	public void testGetRate()throws RateException{
		double d = RateBLL.getRate(620);
		assertTrue(d == 7);
	}
	
	@Test(expected = RateException.class)
	public void testRateException()throws RateException{
		RateBLL.getRate(9000);
	}
	
	@Test
	public void testGetPayment()
	{
		double k = RateBLL.getPayment(4,360,300000,0,false);
		assertTrue(k == 1432.25);	
		
		}
}
