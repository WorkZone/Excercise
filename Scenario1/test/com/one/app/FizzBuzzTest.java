package com.one.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Kishore
 *
 */
public class FizzBuzzTest {

	FizzBuzz simpleFizzBuzz = null;
	
	@Before
	public void start(){
		simpleFizzBuzz = new FizzBuzz();
	}
	
	@Test
	public void test_printingBuzz() {
		String actual = simpleFizzBuzz.displayValue(5);
		assertEquals(simpleFizzBuzz.BUZZ, actual);
	}

	@Test
	public void test_printingFizz() {
		String actual = simpleFizzBuzz.displayValue(3);
		assertEquals(simpleFizzBuzz.FIZZ, actual);
	}
	
	@Test
	public void test_printingFizzBuzz() {
		String actual = simpleFizzBuzz.displayValue(15);
		assertEquals(simpleFizzBuzz.FIZZBUZZ, actual);
	}
	
	@Test
	public void test_printingNumber() {
		String actual = simpleFizzBuzz.displayValue(4);
		assertEquals("4", actual);
	}
	
	@Test
	public void test_printingSequence() {
		String expected="1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
		String actual = simpleFizzBuzz.displayRange(1, 20);
		//for(int i =1 ; i <= 20 ; i++){
		//	actual = actual+ simpleFizzBuzz.displayValue(i);
		//}
		
		//String actual = simpleFizzBuzz.displayValue(4);
		assertEquals(expected, actual);
	}
}
