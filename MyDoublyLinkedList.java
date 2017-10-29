/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 07
bneupane@u.rochester.edu
*/

public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {

	public MyDoubleNode<AnyType> first;
	public MyDoubleNode<AnyType> last;

	public MyDoublyLinkedList() {
		first = new MyDoubleNode<AnyType>();
		last = new MyDoubleNode<AnyType>();
		first.next = last;
		last.prev = first;
	}

	@Override
	public void insert(AnyType x) { // inserts element x to the beginning of the
									// queue
		MyDoubleNode<AnyType> newNode = new MyDoubleNode<AnyType>();
		MyDoubleNode<AnyType> end = last;
			newNode.data = x;
			newNode.next = end;
			newNode.prev = end.prev;
			end.prev.next = newNode;
			end.prev = newNode;
		
	}

	@Override
	public void delete(AnyType x) { // deletes element x
		MyDoubleNode<AnyType> node = first;
		while (node.next != null) {
			if (node.next.data.equals(x)) {
				node.next.next.prev = node;
				node.next = node.next.next;
				break;
			} else {
				node = node.next;

			}
		}
	}

	@Override
	public boolean contains(AnyType x) { // returns true if element x is in the
											// list and false otherwise
		MyDoubleNode<AnyType> node = first.next;
		while (node.next != null) {
			if (node.data.equals(x)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	@Override
	public AnyType lookup(AnyType x) { // returns element x if it is in the list
										// and returns null otherwise
		MyDoubleNode<AnyType> node = first.next;
		while (node.next != null) {
			if (node.data.equals(x)) {
				return x;
			}
			node = node.next;
		}
		return null;
	}

	@Override
	public boolean isEmpty() { // returns true if the list is empty and returns
								// false otherwise
		if (first.next.equals(last)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	// runtime is O(n)
	public void printList() { // prints the list
		MyDoubleNode<AnyType> node = first.next;
		System.out.print("[");
		while (node.next != null) {
			if (node.next.next == null) {
				System.out.print(node.data);
				node = node.next;
			} else {
				System.out.print(node.data + ",");
				node = node.next;
			}
		}
		System.out.println("]");
	}

	@Override
	public void printListRev() { // prints the list in reverse
		MyDoubleNode<AnyType> node = last.prev;
		System.out.print("[");
		while (node.prev != null) {
			if (node.prev.prev == null) {
				System.out.print(node.data);
				node = node.prev;
			} else {
				System.out.print(node.data + ",");
				node = node.prev;
			}
		}
		System.out.println("]");
	}

	@Override
	public AnyType returnAndDeleteFirst() { // deletes the first item in the
											// queue
		MyDoubleNode<AnyType> node = first;
		AnyType dataInNode = first.next.data;
		first.next = first.next.next;
		return dataInNode;

	}

	public AnyType returnFirst() { // returns the first item in the queue
		MyDoubleNode<AnyType> node = first;
		AnyType dataInNode = first.next.data;
		return dataInNode;

	}

}
