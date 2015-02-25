import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class testFour{
	ArrayList<String> st = new ArrayList<String>();
	Interpreter I = new Interpreter();
	@Before
	public void setUp() throws Exception {
		String filename = "testFour";
		 st = ReadFile(filename);
		 
	}

	@Test
	public void test() {
		try {
			I.checkLine(st);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<String> ReadFile(String filename){
		ArrayList<String> lst = new ArrayList<String>();
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
		
			while ((line = bufferedReader.readLine()) != null) {
				 if ( line.trim().length() == 0 ) {
					    continue;  // Skip blank lines
					  }
				lst.add(line);
				//System.out.print(line);
			}
			fileReader.close();
			//System.out.println("Contents of file:");
			//System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lst;
		
		
	}
}
