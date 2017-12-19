package com.steerlean.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import mockit.Mocked;
import mockit.Verifications;

import org.testng.annotations.Test;

public class AppTest {

	@Mocked
	private NumberProcessor processor;

	@Test
	public void stertTest() {

		// Arrange
		App app = new App(processor);
		List<String> expectedProcessedRange = app.start();

		// assert
		Assert.assertNotNull(expectedProcessedRange);
		new Verifications() {
			{
				processor.processRange(1, 100, new ArrayList<String>());
				times = 1;
			}
		};
	}
}