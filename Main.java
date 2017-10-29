/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 2
bneupane@u.rochester.edu
*/

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		ShuntingYardAlgorithm infix = new ShuntingYardAlgorithm(); // infix to postfix
		Answer postfix = new Answer(); // postfix to answer
		BufferedReader i = new BufferedReader(new FileReader("infix_expr_short.txt"));
		BufferedWriter o = new BufferedWriter(new FileWriter("postfix_eval_short.txt"));
		String line = "";
		while ((line = i.readLine()) != null) {
			MyQueue<String> queue = infix.convert(line); // turns the line to postfix
			double answer = postfix.answer(queue); // the postfix then returns the answer
			System.out.println(answer);
			o.write(answer + "");
			o.newLine();
		}
		o.flush();
	}

}
