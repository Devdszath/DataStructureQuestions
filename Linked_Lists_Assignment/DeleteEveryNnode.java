package Linked_Lists_Assignment;

import java.util.Scanner;

/*Delete every N nodes
Send Feedback
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list.
To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains two integer values 'M,' and 'N,' respectively. A single space will separate them.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5 

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
Explanation of Sample Input 2 :
For the first query, we delete one node after every zero elements hence removing all the items of the list. Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7    */

public class DeleteEveryNnode {
    
	
   public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		
			if(M == 0) {
				return null;
			}
		
		
		LinkedListNode<Integer> temp1 = head, temp2 ;
		
		while ( temp1 != null ) {
			
			int c1 = 1, c2 = 1;
			
			while ( c1 < M && temp1 != null ) {
				
				temp1 = temp1.next;
				
				c1++;
			}
			
			if ( temp1 == null ) {
				
				return head;
			}
			
			temp2 = temp1.next;
			
			while ( c2 <= N && temp2 != null ) {
				
				temp2 = temp2.next;
				
				c2++;
			
			}

			temp1.next = temp2;
			
			temp1 = temp2;
			
		}
		return head;
		
   }
   public static void print(LinkedListNode<Integer> head) {
    	
    	while (head != null) {
    		
    		System.out.print(head.data + " ");
    		
    		head = head.next;
    	}
    }
   
   public static LinkedListNode<Integer> takeInput(){ 
   	
   	Scanner s = new Scanner(System.in);
		
		int data = s.nextInt();
		
	    LinkedListNode<Integer> head = null, tail = null;
		
		while( data != -1 ) {
		 
		   LinkedListNode < Integer > newNode = new LinkedListNode <> ( data  );
		
		   if(head == null) {
			
			   head = newNode;
			   
			   tail = newNode;
		   
		   } else {
			
			   tail.next = newNode;
			   
			   tail = newNode;
		   
		   }
		   
		   data = s.nextInt();
		}
		s.close();
		
		return head;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		LinkedListNode<Integer> head = takeInput();
		
		int m = s.nextInt();
		int n = s.nextInt();
		
		head = skipMdeleteN(head, m, n);
		
		print(head);
		
		s.close();
		
	}


}
