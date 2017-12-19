package com.steerlean.fizzbuzz;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.steerlean.fizzbuzz.rule.DivisibilityRule;
import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;
import com.steerlean.fizzbuzz.rule.SumOfDigitsDivisibility;

class RuleFactoryStub extends RuleFactory
{
	public IRule createDivisibilityRule(int divisor, String processedString) {
		return new DivisibilityRule(1, "abc");
	}

	public IRule createSumOfDigitsDivisibility(int divisor, String processedString) {
		return new SumOfDigitsDivisibility(2, "xyz");
	}
}


public class RulesConfiguratorTest1 {
  
	
	
	@Test
	  public void testRuleConfigerator() {
			
		RuleFactory ruleFactoryStub = new RuleFactoryStub();
	//	IRule  ruleFactoryStub.createDivisibilityRule(3, "fizz");
		
		RulesConfigurator rulesConfigurator = new RulesConfigurator(ruleFactoryStub);
		List<IRule> actualRuleList =  rulesConfigurator.configure();
		
		//Assert 
		Assert.assertEquals(4, actualRuleList.size());
		Assert.assertEquals(ruleFactoryStub.createDivisibilityRule(1, "abc"), actualRuleList.get(0));
		Assert.assertEquals(ruleFactoryStub.createSumOfDigitsDivisibility(2, "xyz"), actualRuleList.get(2));
		Assert.assertEquals(ruleFactoryStub.createDivisibilityRule(1, "abc"), actualRuleList.get(1));
		Assert.assertEquals(ruleFactoryStub.createSumOfDigitsDivisibility(2, "xyz"), actualRuleList.get(3));
	  }
}
