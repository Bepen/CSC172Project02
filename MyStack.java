/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 06
bneupane@u.rochester.edu
*/

public class MyStack<AnyType> implements Stack<AnyType> {

	ListLinked<AnyType> list;

	public MyStack() {
		list = new ListLinked<AnyType>();
	}

	@Override
	public boolean isEmpty() { // checks if the list is empty
		if (list.first.next == null) {
			return true;
		} else {
			return false;
		}
	}

	public void push(AnyType x) { // puts an element at the front of the list
		list.insertFirst(x);
	}

	@Override
	public AnyType pop() { // removes the element at the front of the list
		if (isEmpty() == false) {
			return list.deleteFirst();
		}
		else{
			return null;
		}

	}

	@Override
	public AnyType peek() { // returns whatever the first element in the list is
		if (isEmpty() == false) {
			return list.first.next.data;
		} else {

			return null;
		}
	}

	public void printList() {
		list.printList();
	}
}
