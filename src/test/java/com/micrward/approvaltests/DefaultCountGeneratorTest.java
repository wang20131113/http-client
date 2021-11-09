package com.micrward.approvaltests;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.micrward.assist.DefaultCountGenerator;

public class DefaultCountGeneratorTest {

	@Test
	public void testGetByCount(){
		CombinationApprovals.verifyAllCombinations(
				this::assist,new Integer[]{-1,0,1,10,11,99,100,101});
		
		
		Assertions.assertEquals(Float.valueOf(200), new Float(200) );
	}
	
	private Long assist(int param){
		DefaultCountGenerator defaultCountGenerator = new DefaultCountGenerator();
		return defaultCountGenerator.getByCount(param);		
	}
}
