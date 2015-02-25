##Interpreter
This Interpreter takes in a file reads the file line by line and extracts information based on starting string. It initializes values and variables correspondingly and perform calculations based on precedence and displays variables if print is read from the document.

#--------ReadFile-------
This function is added in test files to read a file line by line and store the read lines in a list. 

#--------Interpreter Class---------
Functions :
#------CheckLine------
public void checkLine(ArrayList<String> str) throws Exception
It is the main function it caters all the three conditions :
If first is “let” then it splits string based on spaces, then based on index of the String array returned by split it caters to check if the first part of the expression is a variable or not incase of an Integer it throws an exception. If a new variable is read it adds the value with the key read into the map.
If first is “print” then it splits string based on space if the second part of string is a String it is displayed as it is else if it has a variable that is present in map then it displays the value of the variable.
If the first part is a variable then it splits on basis of  “=” sign the first being the variable if it is not then an exception is thrown such as “x+y = z” throws an exception. If the first part is variable then the string is taken for evaluation. If it has un initialized characters it throws an exception.

#----evaluate------
public int evaluate(String str) throws Exception
It evaluates and expression using stack, if the expression has any brackets or any numeric character it pushes it into the stack by parsing integer as integers, in case of any operator it pops an element from the stack, it first checks the precedence of the popped element and then according to precedence call doOpp function which evaluates the integers according to the operator and returns as int. Lastly the entire expression is evaluated and the result int is returned.

#---checkPrece----
public static boolean checkPrece(char op1, char op2)
This returns a Boolean value after checking precedence by giving multiplication and divison higher precedence to addition and subtraction

#---doOpp-------
public static int doOpp(char op, int b, int a)
It takes an operator and two ints and performs the operation accordingly and returns an int value

#---checkInt----
public boolean checkInt(String num)
Checks if the given string is integer or not and returns true or false accordingly and raises exception in case of it not being an Integer.


Github link : https://github.com/shizaTariq/Interpreter


