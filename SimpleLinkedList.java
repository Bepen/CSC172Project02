/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 06
bneupane@u.rochester.edu
*/

public interface SimpleLinkedList <AnyType> { //methods for the linked list interface
	public void insertFirst(AnyType x);
	public AnyType deleteFirst();
	public AnyType lookup(AnyType x);
	public boolean isEmpty();
	public void printList();
}
