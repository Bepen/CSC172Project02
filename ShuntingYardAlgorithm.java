/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 2
bneupane@u.rochester.edu
*/

public class ShuntingYardAlgorithm {

	public MyQueue<String> convert(String line) { // converts the infix to postfix
		MyStack<String> stack = new MyStack<String>();
		MyQueue<String> queue = new MyQueue<String>();
		String[] array = balanceSpaces(line);
		for (String s : array) { // goes through all the string in the array and checks if the string is a number...
			try { // in which case, it is placed on a queue...
				Double.parseDouble(s);
				queue.enqueue(s);
			} catch (NumberFormatException e) { // and if it's not a number, it is assumed to be an operator and placed in a stack
				if (stack.isEmpty() || stack.peek().equals("(")) { // parenthesis have the highest precedence so it prioritizes them
					stack.push(s);
				} else if (s.equals("(")) {
					stack.push(s);
				} else if (s.equals(")")) {
					while (!(stack.peek().equals("("))) {
						queue.enqueue(stack.pop());
					}
					stack.pop();
				} else { // if it's not a parenthesis, then the operators are compared and ordered by precedence
					while (compareOperators(precedence(stack.peek()), precedence(s)) || stack.peek().equals("(")
							|| stack.isEmpty()) {
						queue.enqueue(stack.pop());
						if (stack.peek() == null || stack.peek().equals("(")) {
							break;
						}
					}
					stack.push(s);
				}
			}

		}
		while (!stack.isEmpty()) { // every operator is put into the queue
			queue.enqueue(stack.pop());
		}
		return queue;
	}

	public boolean compareOperators(int operatorOne, int operatorTwo) { // if one operator has a higher precedence than the other, then true is returned
		if (operatorOne > operatorTwo) {
			return true;
		} else {
			return false;
		}
	}

	public int precedence(String operator) { // assigns values to operators to check for precedence
		int precedence = 0;
		if (operator.equals("(") || operator.equals(")")) {
			precedence = 5;
		} else if (operator.equals("^")) {
			precedence = 4;
		} else if (operator.equals("*") || operator.equals("/") || operator.equals("%")) {
			precedence = 3;
		} else if (operator.equals("+") || operator.equals("-")) {
			precedence = 2;
		} else {
			precedence = 1;
		}
		return precedence;
	}

	public String[] balanceSpaces(String line) { // this method is used to make sure that the formatting is consistient amongst all operators and unnecessary spaces are removed
		String properFormatting = line;
		properFormatting = properFormatting.replaceAll(" ", "");
		properFormatting = properFormatting.replaceAll("\\+", " + ");
		properFormatting = properFormatting.replaceAll("\\-", " - ");
		properFormatting = properFormatting.replaceAll("\\*", " * ");
		properFormatting = properFormatting.replaceAll("\\/", " / ");
		properFormatting = properFormatting.replaceAll("\\<", " < ");
		properFormatting = properFormatting.replaceAll("\\>", " > ");
		properFormatting = properFormatting.replaceAll("\\=", " = ");
		properFormatting = properFormatting.replaceAll("\\!", "! ");
		properFormatting = properFormatting.replaceAll("\\&", " & ");
		properFormatting = properFormatting.replaceAll("\\|", " | ");
		properFormatting = properFormatting.replaceAll("\\(", "( ");
		properFormatting = properFormatting.replaceAll("\\)", " )");
		properFormatting = properFormatting.replaceAll("\\^", " ^ ");
		properFormatting = properFormatting.replaceAll("\\%", " % ");
		properFormatting.trim();
		String[] array = properFormatting.split("\\s+");

		return array;
	}

}