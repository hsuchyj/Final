package rocketBase;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;

import rocketDomain.CompareRates;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	
	
	
	
	
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		ArrayList<RateDomainModel> list = RateDAL.getAllRates();
		Collections.sort(list, new CompareRates());
		

		
		if(GivenCreditScore >= 600 && GivenCreditScore < 650 )
		{
			dInterestRate = list.get(4).getdInterestRate();//7
		}
		
		if(GivenCreditScore >= 650 && GivenCreditScore < 700 )
		{
			dInterestRate = list.get(3).getdInterestRate();//6.5
		}
		
		if(GivenCreditScore >= 700 && GivenCreditScore < 750 )
		{
			dInterestRate = list.get(2).getdInterestRate();
		}
		
		if(GivenCreditScore >= 750 && GivenCreditScore < 800 )
		{
			dInterestRate = list.get(1).getdInterestRate();
		}
		if(GivenCreditScore == 800)
		{
			dInterestRate = list.get(0).getdInterestRate();
		}
		if(GivenCreditScore < 600 || GivenCreditScore > 800)
		{
			throw new RateException();
		}
		
		
		return dInterestRate;
		
		
	}
	
	
	
	
	
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		double w = (r/12)/100;
		double x = Math.abs(FinanceLib.pmt(w, n, p, f, t));
		double fin = Math.round(x*100)/100D;
		
		return fin;
	}
}
