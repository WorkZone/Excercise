package com.one.steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import com.one.app.FizzBuzz;

import junit.framework.Assert;

public class FizzBuzzParamSteps extends Steps {


		int number;
		
		FizzBuzz d;
		boolean flag = false;
		String response;
		
		@Given("a natural $number")
		public void aPattern (@Named("number") int number){
			d = new FizzBuzz();
			this.number = number;
		}
		
		@When("the $number is divisible by $divisor")
		public void whenDivisibleBy3and5(@Named("number") int number , @Named("divisor") int divisor ){
				//this.number = number;
			response = 	d.displayValue(number);
		}
		
		@SuppressWarnings("deprecation")
		@Then("print $keyword")
		public void print(@Named("keyword") String keyword){			
				Assert.assertEquals(keyword , response );			
		}	
		
	}

