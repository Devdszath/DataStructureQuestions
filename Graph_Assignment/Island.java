package Graph_Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*Islands

An island is a small piece of land surrounded by water . 
A group of islands is said to be connected if we can reach from any given island to any other island in the same group . 
Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count the number of connected groups of islands.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b. 
Output Format :
Print the count the number of connected groups of islands
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V-1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3
Sample Output 1:
1 
*/
public class Island {
  
   public static int numConnected(int[][] edges, int n) {
	   int count = 0;
	   boolean[] visited = new boolean[edges.length];
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		for(int i=0;i<visited.length;i++) {
			if(!visited[i]) {
				arrayList.add(path(edges, i, visited));
				count++;
			}
		}
		return count;
		
   }
   
   public static ArrayList<Integer> path(int[][] edges,int sv,boolean[] visited){
		ArrayList<Integer> arr = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(sv);
		visited[sv] = true;
		while(!queue.isEmpty()) {
			
			int front = queue.poll();
			arr.add(front);
			for(int i=0;i<edges.length;i++) {
				
				if(!visited[i] && edges[front][i] ==1) {
					queue.add(i);
					visited[i] = true;
				}
				
			}
		
		}
		 Collections.sort(arr);
		 return arr;
		
	}
   
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
   public static int[][] takeInput() throws IOException {
		String[] strNums;
       strNums = br.readLine().split("\\s");
       int n = Integer.parseInt(strNums[0]);
       int e = Integer.parseInt(strNums[1]);

       int[][] edges = new int[n][n];
       int firstvertex, secondvertex;

       for (int i = 0; i < e; i++) {
           String[] strNums1;
           strNums1 = br.readLine().split("\\s");
           firstvertex = Integer.parseInt(strNums1[0]);
           secondvertex = Integer.parseInt(strNums1[1]);
           edges[firstvertex][secondvertex] = 1;
           edges[secondvertex][firstvertex] = 1;
       }
       return edges;
   }
   public static void main(String[] args) throws NumberFormatException, IOException {
       int [][]edges = takeInput();
       
       int ans = numConnected(edges, edges.length);
       System.out.println(ans);
		
	}
}
