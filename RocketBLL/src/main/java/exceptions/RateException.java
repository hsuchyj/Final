package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	RateDomainModel r = null;
	
	public RateException()
	{
	
	}
	
	public RateException(RateDomainModel n)
	{
		this.r = n;
	}
	
	public RateDomainModel getRateDomainModel()
	{
		return r;
	}

}
