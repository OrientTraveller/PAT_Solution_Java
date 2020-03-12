package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1097 {
	
	static class Node {
		String address;
		int key;
		String next;
		public Node(String address, int key, String next) {
			this.address = address;
			this.key = key;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String start = scaner.next();
		int round = scaner.nextInt();
		Node[] ori = new Node[100000];
		ArrayList<Node> deduplication = new ArrayList<Node>();
		ArrayList<Node> duplication = new ArrayList<Node>();
		for(int i = 0 ; i < round ; i++) {
			String address = scaner.next();
			int key = scaner.nextInt();
			String next = scaner.next();
			ori[Integer.parseInt(address)] = new Node(address, key, next);
		}
		scaner.close();
		boolean[] flag = new boolean[10005]; 
		while(!start.equals("-1")) {
			Node temp = ori[Integer.parseInt(start)];
			start = temp.next;
			if(!flag[Math.abs(temp.key)]) {
				deduplication.add(temp);
				flag[Math.abs(temp.key)] = true;
			}
			else
				duplication.add(temp);
		}
		for(int i = 0 ; i < deduplication.size() ; i++) {
			Node temp = deduplication.get(i);
			if(i < deduplication.size() - 1)
				System.out.println(temp.address + " " + temp.key + " " + deduplication.get(i + 1).address);
			else
				System.out.println(temp.address + " " + temp.key + " -1");
		}
		for(int i = 0 ; i < duplication.size() ; i++) {
			Node temp = duplication.get(i);
			if(i < duplication.size() - 1)
				System.out.println(temp.address + " " + temp.key + " " + duplication.get(i + 1).address);
			else
				System.out.println(temp.address + " " + temp.key + " -1");
		}
	}

}
