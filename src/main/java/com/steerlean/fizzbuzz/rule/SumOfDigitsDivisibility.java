package com.steerlean.fizzbuzz.rule;

public class SumOfDigitsDivisibility implements IRule {
	Integer divisor;
	String processedString;

	public SumOfDigitsDivisibility(Integer divisor, String processedString) {
		this.divisor = divisor;
		this.processedString = processedString;
	}

	public String parse(Integer number) {
		Integer sumOfDigits = calculateSumOfDigits(number);

		if (sumOfDigits % divisor == 0)
			return processedString;
		return "";
	}

	private Integer calculateSumOfDigits(Integer number) {
		Integer sumOfDigits = 0;

		while (number != 0) {
			sumOfDigits += number % 10;
			number /= 10;
		}

		return sumOfDigits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divisor == null) ? 0 : divisor.hashCode());
		result = prime * result
				+ ((processedString == null) ? 0 : processedString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SumOfDigitsDivisibility other = (SumOfDigitsDivisibility) obj;
		if (divisor == null) {
			if (other.divisor != null)
				return false;
		} else if (!divisor.equals(other.divisor))
			return false;
		if (processedString == null) {
			if (other.processedString != null)
				return false;
		} else if (!processedString.equals(other.processedString))
			return false;
		return true;
	}
}
