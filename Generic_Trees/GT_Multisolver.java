package Generic_Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

 */

public class GT_Multisolver {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static void display(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public static Node construct(int[] arr) {
		Node root = null;

		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];

				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}

				st.push(t);
			}
		}

		return root;
	}

	public static int size(Node node) {
		int s = 0;
		for (Node child : node.children) {
			int cs = size(child);
			s = s + cs;
		}
		s = s + 1;

		return s;
	}
	
	static int size;
	static int min;
	static int max;
	static int height;
	
	public static void multisolver(Node node, int depth) {
		size++;
		min = Math.min(min, node.data);
		max = Math.max(max, node.data);
		height = Math.max(height, depth);
		
		for (Node child: node.children) {
			multisolver(child, depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}

		Node root = construct(arr);
		
		size = 0;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		height = 0;
		multisolver(root, 0);
		System.out.println("Size = " + size);
		System.out.println("Min = " + min);
		System.out.println("Max  = " + max);
		System.out.println("Height = " + height);
	}

}
