/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Project 2
bneupane@u.rochester.edu
*/

public class Answer { // the postfix expressions are then calculated to return an answer to the expression

	public double answer(MyQueue<String> queue) {
		MyStack<String> stack = new MyStack<String>();

		while (queue.isEmpty() == false) {
			try { //checks to see if the item at queue is a number
				Double.parseDouble(queue.peek());
				stack.push(queue.dequeue());
			} catch (NumberFormatException e) { //if not, the operator is then used to compute the value of two numbers
				if (queue.peek().equals("!")) { //negates the value
					String number = stack.peek();
					if (number.equals("1.0") || number.equals("1")) {
						number = "0";
					} else {
						number = "1";
					}
					stack.push(number);
				} else {
					String tempString2 = stack.peek();
					stack.pop();
					String tempString1 = stack.peek();
					if (queue.peek() == null) {
						break;
					}
					String total = calculate(tempString1, tempString2, queue.peek()); // calculates the total
					stack.pop();
					stack.push(total);

				}
				queue.dequeue();
			}

			if (queue.peek() == null) {
				break;
			}
		}
		return Double.parseDouble(stack.pop());
	}

	public String calculate(String numOneStr, String numTwoStr, String operator) { //this is where the expression is evaluated
		double answer = 0;
		double numOne = Double.parseDouble(numOneStr);
		double numTwo = Double.parseDouble(numTwoStr);
		if (operator.equals("+")) {
			answer = numOne + numTwo;
		} else if (operator.equals("-")) {
			answer = numOne - numTwo;
		} else if (operator.equals("*")) {
			answer = numOne * numTwo;
		} else if (operator.equals("/")) {
			answer = numOne / numTwo;
		} else if (operator.equals(">")) {
			if (numOne > numTwo) {
				answer = 1.0;
			} else {
				answer = 0.0;
			}
		} else if (operator.equals("<")) {
			if (numOne < numTwo) {
				answer = 1.0;
			} else {
				answer = 0.0;
			}
		} else if (operator.equals("=")) {
			if (numOne == numTwo) {
				answer = 1.0;
			} else {
				answer = 0.0;
			}
		} else if (operator.equals("|")) {
			if (numOne == 1.0 || numTwo == 1.0) {
				answer = 1.0;
			} else {
				answer = 0.0;
			}
		} else if (operator.equals("&")) {
			if (numOne == 1.0 && numTwo == 1.0) {
				answer = 1.0;
			} else {
				answer = 0.0;
			}
		} else if (operator.equals("%")) {
			answer = numOne % numTwo;

		} else if (operator.equals("^")) {
			answer = Math.pow(numOne, numTwo);
		}
		return String.valueOf(answer);
	}
}