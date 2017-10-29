/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 06
bneupane@u.rochester.edu
*/

public interface Stack<AnyType>{ // interface for Stack
	public boolean isEmpty();

	public void push(AnyType x);

	public AnyType pop();

	public AnyType peek();
}
