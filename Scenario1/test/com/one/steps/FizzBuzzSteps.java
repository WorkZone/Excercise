package com.one.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import com.one.app.FizzBuzz;

import junit.framework.Assert;


/**
 * FizzBuzzSteps.java
 * @author Kishore
 *
 */
public class FizzBuzzSteps extends Steps {


	int number;
	
	FizzBuzz d;
	boolean flag = false;
	
	
	@Given("a $start and $finish for contiguous range of numbers")
	public void aPattern (){
		d = new FizzBuzz();

	}
	
	@When("the $number is divisible by 3 and 5")
	public void whenDivisibleBy3and5(@Named("number") int number ){
			this.number = number;
			flag = 	d.isDivisibleByThreeAndFive(number);
	}
	
	@SuppressWarnings("deprecation")
	@Then("print fizzbuzz")
	public void printFizzBuzz(){
	
		String expected = d.displayValue(number);
		if(flag){
			Assert.assertEquals(d.FIZZBUZZ , expected );
		}else{
			Assert.assertNotSame(d.FIZZBUZZ , expected );
		}		;
	}
	
	@When("the $number is divisible by 3 only")
	public void whenDivisibleBy3(@Named("number") int number ){		flag = 	d.isDivisibleByThreeOnly(number);
	}
	
	@SuppressWarnings("deprecation")
	@Then("print fizz")
	public void printFizz(){					String expected = d.displayValue(number);
		if(flag){
			Assert.assertEquals(d.FIZZ , expected );
		}else{
			Assert.assertNotSame(d.FIZZ , expected );
		}
	;
	}
	
	@When("the $number is divisible by 5 only")
	public void whenDivisibleBy5(@Named("number") int number ){		
		flag = 	d.isDivisibleByFiveOnly(number);		
	}
	
	@SuppressWarnings("deprecation")
	@Then("print buzz")
	public void printBuzz(){					String expected = d.displayValue(number);
		if(flag){
			Assert.assertEquals(d.BUZZ , expected );
		}else{
			Assert.assertNotSame(d.BUZZ , expected );
		}
	}
		
	
	@When("the $number is not divisible by 3 or 5")
	public void whenNotDivisibleBy3and5(@Named("number") int number ){		flag = !(d.isDivisibleByThree(number) || d.isDivisibleByFive(number));
	}
	
	@SuppressWarnings("deprecation")
	@Then("print the $number")
	public void display(@Named("number") int number){				String expected = d.displayValue(number);
		if(flag){
			Assert.assertEquals(String.valueOf(number) , expected );
		}else{
			Assert.assertNotSame(String.valueOf(number) , expected );
		}		
	}
	
}
