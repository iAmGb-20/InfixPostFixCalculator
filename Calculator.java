/*
 * Anisha Bhattacharya
 * Godbless Chille
 * Project1
 */

import java.io.*;

public class Calculator {
	static InfixPostfixEvaluation pE;

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader reader;
		
	
		try {
			File file = new File(args[1]);


			FileWriter fileReader = new FileWriter(file); // A stream that connects to the text file
			BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // Connect the FileWriter to the
																			// BufferedWriter

			reader = new BufferedReader(new FileReader(args[0]));
			//reader = new BufferedReader(new FileReader("/Users/godblesschille/Desktop/infix_expr_short.txt"));
			String input = reader.readLine();
			
			while (input != null) {
				//as long as there is a line following the current line we are at...then do the following
				pE = new InfixPostfixEvaluation(input);
				InfixPostfixEvaluation.ShuntingAlgoException();
				String line = InfixPostfixEvaluation.output;
				bufferedWriter.write(line+ "\n");
				input = reader.readLine();
				
			}
			//after we are done looping through the lines, we close the reader so that it does not read any value
			reader.close();
			//we close the writer as well so that it does not write any blank spaces
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not working...");
		}



	}

}