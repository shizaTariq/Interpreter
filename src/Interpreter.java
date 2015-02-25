
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Interpreter {
	//static String variable;
	//static Integer value;
	java.util.HashMap<String, Integer > mapInt = new java.util.HashMap<String, Integer>();
	Stack<Integer> values = new Stack<Integer>();
    Stack<Character> operations = new Stack<Character>();
	String input;


	public void checkLine(ArrayList<String> str) throws Exception{

		for(String eachLine: str){
			//System.out.print(eachLine+ "\n");
			if(eachLine.startsWith("let")){
              
				String[] tok = eachLine.split(" ");
				if(this.checkInt(tok[1])){
					 throw new Exception("wrong format");
	            	   
	               }
				if(eachLine.contains("=")){
					 
					mapInt.put(tok[1], Integer.parseInt(tok[3]));

				}
				else{
					mapInt.put(tok[1], 0);

				}
				
				

			}
			else if (eachLine.startsWith("print")){
				String[] tok = eachLine.split(" ");
				if(eachLine.contains("\"")){
				 System.out.print(tok[1]+ "\n");
					
				}
				else{
						if(mapInt.containsKey(tok[1])){
							int val = mapInt.get(tok[1]);
							//System.out.print(val);
							System.out.print(tok[1] + "=" + mapInt.get(tok[1])+"\n");
							
						}
						else
							throw new Exception("uninitialized");
						
				
				
				
				}
				
			}
			
			else {
				String[] tok = eachLine.split("=");
				//System.out.print(tok[0]+"\n");
				if(tok[0].contains("+")||tok[0].contains("-")||tok[0].contains("*")||tok[0].contains("/")){
					throw new Exception("Syntax error");
				}
				else{
					for(String ke :mapInt.keySet()){
						if(tok[1].contains(ke)){
							tok[1]=tok[1].replace(ke, (CharSequence) mapInt.get(ke).toString());
							System.out.print(tok[1]+ "\n");
						}
						
						
					}
					
					//System.out.print(evaluate(tok[1])+"\n");
					tok[0]=tok[0].trim();
					mapInt.put(tok[0], evaluate(tok[1]));
					int val = mapInt.get(tok[0]);
					//System.out.print("value is" + val);
					
				}
				
				
			}

		}


	}
	
	public int evaluate(String str) throws Exception {
        char[] tok = str.toCharArray();
 
        for (int i = 0; i < tok.length; i++)
        {
             
            if (tok[i] == ' ')
                continue;
 
            if (tok[i] == '(')
                operations.push(tok[i]);
            
            
            else if (tok[i] >= '0' && tok[i] <= '9')
            {
                StringBuffer buff = new StringBuffer();
                
                while (i < tok.length && tok[i] >= '0' && tok[i] <= '9')
                    buff.append(tok[i++]);
                values.push(Integer.parseInt(buff.toString()));
            }
 
            
            else if (tok[i] == ')')
            {
                while (operations.peek() != '(')
                  values.push(doOpp(operations.pop(), values.pop(), values.pop()));
                operations.pop();
            }
 
           
            else if (tok[i] == '+' || tok[i] == '-' ||tok[i] == '*' || tok[i] == '/')
            {
               
                while (!operations.empty() && checkPrece(tok[i], operations.peek()))
                  values.push(doOpp(operations.pop(), values.pop(), values.pop()));
 
               
                operations.push(tok[i]);
            }
            
            else {
            	throw new Exception("uninitialized variable");
            	
            }
            	
          	
            	
            	
        }
 
        
        while (!operations.empty())
            values.push(doOpp(operations.pop(), values.pop(), values.pop()));
 
        
        return values.pop();
    }
 
    
    public static boolean checkPrece(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
   
    public static int doOpp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
	
	public String displayVal(String val){
		Integer value = mapInt.get(val);
		System.out.print(val+ "=" +value+"\n");
		return null;
	}
	
	public boolean checkInt(String num){
		try{
			  int c  = Integer.parseInt(num);
			  return true;
			} 
		catch (NumberFormatException e) {
			  return false;
			}
		
		
	}

	public static void main(String[] args) {


	}

}
