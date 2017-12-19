package com.steerlean.fizzbuzz;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.steerlean.fizzbuzz.rule.DivisibilityRule;
import com.steerlean.fizzbuzz.rule.IRule;
import com.steerlean.fizzbuzz.rule.RuleFactory;

public class RuleFactoryTest {
  @Test
  public void testCreateDivisibilityRule() {
	  
	  IRule obj1 = new DivisibilityRule(2,"hello");
	 
	  RuleFactory ruleFactory = new RuleFactory();
	  IRule obj = ruleFactory.createDivisibilityRule(2, "hello");
	  
	  
	  Assert.assertTrue(obj.equals(obj1));
	  Assert.assertEquals(obj.hashCode(), obj1.hashCode());
	 
	  }
	  
  }
