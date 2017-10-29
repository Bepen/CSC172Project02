/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 07
bneupane@u.rochester.edu
*/

public class MyQueue <AnyType> implements Queue<AnyType> {

	MyDoublyLinkedList<AnyType> dList;
	
	public MyQueue() {
		dList = new MyDoublyLinkedList<AnyType>();
	}
	
	@Override
	public boolean isEmpty() { // checks if the queue is empty
		if (dList.first.next == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void enqueue(AnyType x) { // adds an element to the beginning of the queue
		dList.insert(x);
	}

	@Override
	public AnyType dequeue() { // removes the element from the beginning of the queue
		if (isEmpty() == false) {
			return dList.returnAndDeleteFirst();
		} else {
			return null;
		}
	}

	@Override
	public AnyType peek() { // returns the first item in the queue
		return dList.returnFirst();
	}
	
	public void printQueue() { // prints the queue
		dList.printList();
	}

}
