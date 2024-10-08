package test.nz.ac.massey.cs.sdc.taxcalculator;

import nz.ac.massey.cs.sdc.taxcalculator.IncomeTaxCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IncomeTaxCalculatorTest {

	private IncomeTaxCalculator calculator = null;

	@Before
	public void setup() {
		calculator = new IncomeTaxCalculator();
	}
	@After
	public void tearDown() {
		calculator = null;
	}

	@Test
	public void test1() {
		double tax = calculator.calculateIncomeTax(65238);
		assertEquals(11791.9,tax,0.01);

	}

	@Test
	public void test2() {
		double tax = calculator.calculateIncomeTax(45000);
		assertEquals(6783.0,tax,0.01);
	}

	// boundary tests
	@Test
	public void testZero() {
		double tax = calculator.calculateIncomeTax(0);
		assertEquals(0,tax,0.01);
	}

	@Test
	public void testSmallIncome() {
		double tax = calculator.calculateIncomeTax(10);
		assertEquals(1.05,tax,0.01);
	}

	@Test
	public void testLargeIncome() {
		double tax = calculator.calculateIncomeTax(Integer.MAX_VALUE);
		// should be very close to the max tax rate
		assertEquals(0.39*Integer.MAX_VALUE,tax,Integer.MAX_VALUE*0.001);
	}

	@Test
	public void testNegativeIncome1() {
		try {
			@SuppressWarnings("unused")
			double tax = calculator.calculateIncomeTax(-42);
			assertTrue(false);
		}
		catch (IllegalArgumentException x) {
			assertTrue(true);
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNegativeIncome2() {
		calculator.calculateIncomeTax(-42);
	}

	// @Test(timeout=100)
	// public void test1InclPerformance() {
	// 	double tax = calculator.calculateIncomeTax(65239);
	// 	assertEquals(12591.40,tax,0.01);
	// }

	@Test(timeout=100)
	public void test2InclPerformance() {
		double tax = calculator.calculateIncomeTax(45000);
		assertEquals(6783.0,tax,0.01);
	}

}
