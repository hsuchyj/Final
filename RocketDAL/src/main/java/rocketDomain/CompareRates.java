package rocketDomain;

import java.util.Comparator;

public class CompareRates implements Comparator<RateDomainModel>
{

	public int compare(RateDomainModel r1, RateDomainModel r2) {
		
		return Double.compare(r1.getdInterestRate(), r2.getdInterestRate());
		
	}
	
	
	
}
