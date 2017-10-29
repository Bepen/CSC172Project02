/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 07
bneupane@u.rochester.edu
*/

public interface DoublyLinkedList <AnyType>{
	public void insert(AnyType x);
    public void delete(AnyType x);
    public boolean contains(AnyType x);
    public AnyType lookup(AnyType x);
    public boolean isEmpty();
    public void printList();
    public void printListRev();
	public AnyType returnAndDeleteFirst();
}
