/*
Bepen Neupane
Lab: Tuesday & Thursday 4:50-6:05
Lab Partner: Sailesh Kaveti
Lab 07
bneupane@u.rochester.edu
*/

public interface Queue<AnyType> {
	 public boolean isEmpty();
     public void enqueue(AnyType x);
     public AnyType dequeue();
     public AnyType peek();
}
