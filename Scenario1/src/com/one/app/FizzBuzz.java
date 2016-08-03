package com.one.app;


/**
* 
* The FizzBuzz program implements an application that prints out the following for a contiguous range of numbers:
*  the number
* 'fizz' for numbers divisible by 3
* 'buzz' for numbers divisible by 5
* 'fizzbuzz' for numbers divisible by both 3 and 5
*
* @author  Kishore Saraswathula
*/

public class FizzBuzz {

	public static final String FIZZBUZZ ="fizzbuzz"; 
	public static final String FIZZ ="fizz";
	public static final String BUZZ ="buzz";
		

	   
	/**
	 * This method is used to find whether a given number is divisible by 3 and 5.
	 * @param number - the input
	 * @return - true if divisible by 3 and 5, else false
	 */
	public boolean isDivisibleByThreeAndFive(int number) {	
		if(isDivisibleByThree(number) && isDivisibleByFive(number)){			
			return true;
		}else{			
			return false;
		}		
	}
	
	/**
	 * This method is used to find whether a given number is divisible by 3.
	 * @param number - the input
	 * @return - true if divisible by 3, else false
	 */
	public boolean isDivisibleByThree(int number) {	
		if(number % 3 ==0){			
			return true;
		}else{			
			return false;
		}
	}
	
	/**
	 * This method is used to find whether a given number is divisible by 5.
	 * @param number - the input
	 * @return - true if divisible by 5, else false
	 */
	public boolean isDivisibleByFive(int number) {
		if(number % 5 ==0){			
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * This method is used to find whether a given number is divisible by only 3.
	 * @param number - the input
	 * @return - true if divisible by only 3, else false
	 */
	public boolean isDivisibleByThreeOnly(int number) {	
		if(isDivisibleByThree(number) && !isDivisibleByFive(number)){			
			return true;
		}else{			
			return false;
		}
	}
	
	
	/**
	 * This method is used to find whether a given number is divisible by only 5.
	 * @param number - the input
	 * @return - true if divisible by only 5, else false
	 */
	public boolean isDivisibleByFiveOnly(int number) {	
		if( isDivisibleByFive(number) && !isDivisibleByThree(number) ){			
			return true;
		}else{			
			return false;
		}
	}
	

	/**
	 * This method is used to find the appropriate translation for a given number.
	 * @param number - the input
	 * @return - a String
	 */
	public String displayValue(int number) {
		
		if(isDivisibleByThreeAndFive(number)){
			return FIZZBUZZ;			
		}else if(isDivisibleByThreeOnly(number)){
			return FIZZ;			
		}else if(isDivisibleByFiveOnly(number)){
			return BUZZ;
		}else{
			return String.valueOf(number);
		}		
	}	
	
	/**
	 * This method is used to accept start and an end, and returns the appropriate translation for the contiguous range.
	 * @param start - the start or range
	 * @param end - the ending of range
	 * @return - a concatenated String of values
	 */
	public String displayRange(int start, int end) {
		String result="";
		for(int i = start ; i <= end ; i++){
			result = result + " " +displayValue(i);
		}
			
		return result.trim();		
	}
}
