package rocketBase;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;


import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	@Test
	public void testGetAllRate(){
		ArrayList<RateDomainModel> list = RateDAL.getAllRates();
		assertTrue(list.size() > 0);
	}
	


}
