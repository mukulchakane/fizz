package com.steerlean.fizzbuzz;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.steerlean.fizzbuzz.rule.DivisibilityRule;
import com.steerlean.fizzbuzz.rule.IRule;

public class DivisibilityRuleTest {
  
  @Test
  public void testIfNumberDivisible() {
	  //Arrange
	  IRule divisibilityTest = new DivisibilityRule(2, "hello");
	  //act
	  String parseString = divisibilityTest.parse(10);
	  //assert
	  
	  Assert.assertEquals(parseString,"hello");
  }
  @Test(expectedExceptions = ArithmeticException.class)
  public void testIfNumberDivisibleZero() {
	  //Arrange
	  IRule divisibilityTest = new DivisibilityRule(0, "helloZero");
	  //act
	  String parseString = divisibilityTest.parse(10);
	  
	  }
  @Test
  public void testIfNumberIsNotDivisible() {
	  //Arrange
	  IRule divisibilityTest = new DivisibilityRule(3, "Notdivisible");
	  //act
	  String parseString = divisibilityTest.parse(10);
	  //assert
	  
	  Assert.assertEquals(parseString,"");
  }
}
