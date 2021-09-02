package com.micrward.assist;

public class DefaultCountGenerator implements CountGenerator{

	private static final int period = 3000;
	private static final long maxPeriod = 20*1000;
		
	public long getByCount(int count) {
		long result = (long) (period * Math.pow(1.5, count - 1));
		if( result > maxPeriod){
			throw new RuntimeException("time exceed. ");			
		}else{
			return result;
		}
	}
}
