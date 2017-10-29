/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 06
bneupane@u.rochester.edu
*/

public class ListLinked<AnyType> implements SimpleLinkedList<AnyType> {

	public MyNode<AnyType> first; //first node

	public ListLinked() {
		first = new MyNode<AnyType>();
	}

	@Override
	
	public void insertFirst(AnyType x) { // puts an element at the front of the list
		MyNode<AnyType> node = new MyNode<AnyType>();
		node.data = x;
		node.next = first.next;
		first.next = node;
	}

	@Override
	public AnyType deleteFirst() { //deletes first element in the list
			MyNode<AnyType> node = first;
			AnyType dataInNode = first.next.data;
			first.next = first.next.next;
			return dataInNode;
	}

	

	@Override
	public AnyType lookup(AnyType x) { // returns element x if it is in the list and returns null otherwise
		MyNode<AnyType> node = first.next;
		while (node != null) {
			if (node.data.equals(x)) {
				return x;
			}
			node = node.next;
		}
		return null;
	}

	@Override
	public boolean isEmpty() { // if the list is empty, true is returned
		if (first.next == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void printList() { //prints the list
		MyNode<AnyType> node = first.next;
		System.out.print("[");
		while (node != null) {
			if (node.next == null) {
				System.out.print(node.data);
				node = node.next;
			} else {
				System.out.print(node.data + ", ");
				node = node.next;
			}
		}
		System.out.println("]");
	}

}
