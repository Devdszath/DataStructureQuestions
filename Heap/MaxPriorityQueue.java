package Heap;

import java.util.ArrayList;
import java.util.Scanner;
/*Code : Max Priority Queue
Send Feedback
Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.
Sample Input : 1 3 1 4 1 63 1 21 1 9 2 3 1 7 3 4 5 3 3 -1
Sample Output : 
63
63
21
4
false*/
public class MaxPriorityQueue {

   ArrayList<Integer> heap = new ArrayList<>();
	
	public MaxPriorityQueue(){
		heap = new ArrayList<>();
	}
	
	int getSize() {
		return heap.size();
	}
	
	Boolean isEmpty() {
		return heap.size() == 0;
	}
	
	int getMax()  {
		if(heap.isEmpty()) {
		    return Integer.MIN_VALUE;
		}
		return heap.get(0);
	}
	
	void insert( int element ) {
		heap.add( element );
		
		upheapify(heap);

	}
	// Time Complexity - O(nlogn) Space Complexity - O(n)
	void upheapify(ArrayList<Integer> heap) {
		int childIndex = heap.size() - 1;
		int parentIndex = ( childIndex - 1 )/ 2;
		
		while (childIndex > 0) {
			if (heap.get(childIndex) > heap.get(parentIndex)) {
				
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {

				return;
			}
		}
	}
    int removeMax()  {
		
    	if(isEmpty()) {
    		
    		return Integer.MIN_VALUE;
    	}
    	int val = heap.get(0);
    	heap.set(0, heap.get(heap.size() - 1) );
    	heap.remove( heap.size() - 1);
    	downheapify(heap);
    	
		return val;
	}
    // Time Complexity - O(nlogn) Space Complexity - O(n)
    void downheapify(ArrayList<Integer> heap) {
    	int parentIndex = 0;
    	int leftChildIndex =  1;
    	int rightChildIndex = 2;
    	int maxIndex = parentIndex;
		while ( leftChildIndex < heap.size() ) {
		
			if ( heap.get(leftChildIndex) > heap.get(maxIndex)) {
				
				maxIndex = leftChildIndex;
			}
			if ( rightChildIndex < heap.size() &&  heap.get(rightChildIndex) > heap.get(maxIndex)) {
				
				maxIndex = rightChildIndex;
			}
			
			if( maxIndex == parentIndex ) {
				break;
			}
			else {
				
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(maxIndex));
				heap.set(maxIndex, temp);
				
				parentIndex = maxIndex;
				leftChildIndex = 2 * parentIndex + 1;
				rightChildIndex = 2 * parentIndex + 2;
				
			} 
		}
    }
	
    static Scanner s = new Scanner(System.in);
	
    public static void main(String[] args) {
		MaxPriorityQueue pq = new MaxPriorityQueue();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMax
					System.out.println(pq.getMax());
					break;
				case 3 : // removeMax
					System.out.println(pq.removeMax());
					break;
				case 4 : // size
					System.out.println(pq.getSize());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = s.nextInt();
		}
	}

}
