package com.steerlean.fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Assert;
import org.testng.annotations.Test;

public class NumberProcessorTest {
	
	@Mocked
	private RuleEngine mockedRuleEngine;

	@Test
	public void testProcessRange() throws Exception {
		//Arrange
		final List<String> expectedProcessedNumbers = Arrays.asList("abc", "pqr");
		
		new Expectations() {{
			mockedRuleEngine.run(1); returns("abc");
			mockedRuleEngine.run(2); returns("pqr");
		}};
		
		//ACT
		NumberProcessor numberProcessor = new NumberProcessor(mockedRuleEngine);
		List<String> actualProcessNumbers = new ArrayList<String>();
		numberProcessor.processRange(1 , 2, actualProcessNumbers);
		
		
		//Assert
		Assert.assertEquals(2, actualProcessNumbers.size());
		Assert.assertEquals(expectedProcessedNumbers, actualProcessNumbers);
//		Assert.assertEquals(expectedProcessedNumbers.get(1), actualProcessNumbers);
	}
}
