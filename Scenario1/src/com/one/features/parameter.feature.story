Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario:  A scenario for translating number to word. print fizz if disible by 3, buzz if divisible by 5, fizzbuzz if divisible by 5 and 3, otherwise print number 
Given a natural <number>
When the <number> is divisible by <divisor>
Then print <keyword>

Examples:
|number|divisor|keyword|
|6|3|fizz|
|20|5|buzz|
|150|15|fizzbuzz|
|2|3|2|
|2|5|2|
|2|15|2|