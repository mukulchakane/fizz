package com.steerlean.fizzbuzz;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Mocked;

import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;

public class RuleConfigeratorTest {
	@Mocked
	private RuleFactory mockedRulefactory;

	@Test
	public void testRuleConfigerator(@Mocked final IRule divisiilityRuleWithDivisor3,
			@Mocked final IRule divisiilityRuleWithDivisor5 , 
			@Mocked final IRule divisiilityRuleWithDivisor6 ,
			@Mocked final IRule divisiilityRuleWithDivisor7) throws Exception {
		
				
		new Expectations(){
			{
				mockedRulefactory.createDivisibilityRule(3, "Fizz");
				returns(divisiilityRuleWithDivisor3);
				mockedRulefactory.createDivisibilityRule(5, "Buzz");
				returns(divisiilityRuleWithDivisor5);
				mockedRulefactory.createSumOfDigitsDivisibility(6, "FiJazz");
				returns(divisiilityRuleWithDivisor6);
				mockedRulefactory.createSumOfDigitsDivisibility(5, "BuJazz");
				returns(divisiilityRuleWithDivisor7);
			}
		};
		
		
		//ACT
		RulesConfigurator rulesConfigurator = new RulesConfigurator(mockedRulefactory);
		List<IRule> actualRuleList =  rulesConfigurator.configure();
		
		//Assert
		
		Assert.assertEquals(4, actualRuleList.size());
		Assert.assertEquals(divisiilityRuleWithDivisor3, actualRuleList.get(0));
		Assert.assertEquals(divisiilityRuleWithDivisor5, actualRuleList.get(1));
		Assert.assertEquals(divisiilityRuleWithDivisor6, actualRuleList.get(2));
		Assert.assertEquals(divisiilityRuleWithDivisor7, actualRuleList.get(3));

		
	}
}