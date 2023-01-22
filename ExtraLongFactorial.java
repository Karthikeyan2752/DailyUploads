/*
 * 
 */

package com.leetcodes1;

import java.math.BigDecimal;

public class ExtraLongFactorial {
	public static BigDecimal fact(BigDecimal input) {
		if (input.equals(new BigDecimal("0"))) {
			return new BigDecimal("1");
		}

		return input.multiply(fact(input.subtract(new BigDecimal("1"))));
	}
	public static void main(String[] args) {

	}

}
