package com.my;

public class TimeIntermission {

	private static final int period = 3000;
	//private static final long maxPeriod = 5000*10000;
	private static final long maxPeriod = 20*1000;
	private TimeIntermission(){}
	
	public static long getByCount(int count) {
		long result = (long) (period * Math.pow(1.5, count - 1));
		if( result > maxPeriod){
			System.out.println(" time exceed. ");
			throw new RuntimeException();			
		}else{
			return result;
		}
	}
}
