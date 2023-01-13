package Heap;
import java.util.Scanner;
/*Code : In-place heap sort
Send Feedback
Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array or N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains array elements after sorting. 
The elements of the array in the output are separated by single space.
Constraints :
1 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1:
6 
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2
*/
public class InplaceHeapSort {

	public static void placeIntoVirtualHeap( int arr[], int i ) {
		   
		// ith element have to insert one-by-one into heap which is stored in array
		int childIndex = i;
		int parentIndex = ( childIndex - 1 )/ 2;
		
		while (childIndex > 0) {
			if ( arr[childIndex] < arr[parentIndex]) {
				
				int temp = arr[childIndex];
				arr[childIndex] = arr[parentIndex];
				arr[parentIndex] = temp;
				
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {

				return;
			}
		}
	}
	
	public static void inplaceHeapSort(int arr[]) {
		
		  for( int i = 0; i < arr.length; i++ ) {
			  placeIntoVirtualHeap( arr, i );
		  }
		  
          for( int i = 0; i < arr.length; i++ ) {
        	  arr[arr.length - 1 - i] = removeMinFromVirtualHeap(arr, arr.length - i);
          }
	}
	
	static int removeMinFromVirtualHeap(int heap[], int heapSize) {
		
		int minVal = heap[0];
		heap[0] = heap[heapSize - 1];
		heapSize--;
		
		int parentIndex = 0;
    	int leftChildIndex =  1;
    	int rightChildIndex = 2;
    	int minIndex = parentIndex;
		while ( leftChildIndex < heapSize ) {
		
			if ( heap[leftChildIndex] < heap[minIndex]) {
				
				minIndex = leftChildIndex;
			}
			if ( rightChildIndex < heapSize &&  heap[rightChildIndex] < heap[minIndex]) {
				
				minIndex = rightChildIndex;
			}
			
			if( minIndex == parentIndex ) {
				break;
			}
			else {
				
				int temp = heap[parentIndex];
				heap[parentIndex] = heap[minIndex];
				heap[minIndex] = temp;
				
				parentIndex = minIndex;
				leftChildIndex = 2 * parentIndex + 1;
				rightChildIndex = 2 * parentIndex + 2;
				
			} 
		}
		
		return minVal;
	}
	
    public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int input[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			input[i] = sc.nextInt();
		}
		inplaceHeapSort(input);
		for (int i : input) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
