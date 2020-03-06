Name: Godbless Chille
		Anisha Bhattacharya
CSC 172 Project1
NETID: gchille, abhatta9
NETID no. 31528986, 31564472
email: gchille@u.rochester.edu
		abhatta9@u.rochester.edu
Lab: 6:15-7:30pm

In InfixPostfixEvaluation.java:
We implemented two static stacks, along with one static queue. The opStack is responsible for the operators 
in the ShuntingYard algorithm. The numbers queue was responsible for saving the postfix expression that is
generated from the ShuntingYard method. 
We had isOperator and isNumber methods which were both boolean methods to check for an operator and a number in an infix expression, respectively.
We also have a method that looks for a parentheses in an infix expression. (isParentheses)
Another important method is returnsValue. This method returns the value of any expression that involves binary operators.
for cases of trigonometric functions, we had a method called returnsValueAngle which returns the value of the number passed to the trig function
Lastly, we implemented a method which simply called the ShuntingYard method in the try block and caught any form of exception that come from it.


In Calculator.java;
We only had a main method. Within this main method, we implemented a bufferedReader as well as bufferedWriter using the FileWriter class
We checked for errors in this class by using the try-catch block. 
This program basically reads through each and every string and continually writes the output inside the my_eval.txt file.

Extra credit:
Our program supports sin, cos, tan, modulo as well as exponentiation (as written in the project pdf)
How this works has been explained in the method explanation above.

Our program also checks for all invalid expressions and prints "INVALID EXPRESSION!" or "ERROR CAUGHT!"whenever we have an invalid expression

TESTCASES
Along with this file, we also have an OUTPUT file that contains more than 10 different test cases for the extra operators as well
as the binary operators.
We also have 10 different test cases which have invalid expressions within them, these ones help us show you how invalid expressions look like.

NB: URLinkedList, MyLinkedList, and others, are just files that help in the implementation of the data structures we need.

to RUN:
Run Calculator.java in the terminal and then input "infix_expr_short.txt" and "my_eval.txt" as the txt files.