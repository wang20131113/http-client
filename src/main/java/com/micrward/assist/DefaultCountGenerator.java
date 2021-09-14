package com.micrward.assist;

public class DefaultCountGenerator implements CountGenerator{

	private static final int DELAY = 3000;
	private static final long MAX_DELAY = 20*1000;
		
	public long getByCount(int count) {
		if(count == 1){
			return 0l;
		}
		long result = (long) (DELAY * Math.pow(1.1, count));
		if( result > MAX_DELAY){
			throw new RuntimeException("time exceed. ");			
		}else{
			return result;
		}
	}
}
