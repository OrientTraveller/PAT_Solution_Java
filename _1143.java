package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1143 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int round = scaner.nextInt();
		int nodeNum = scaner.nextInt();
		for (int i = 0; i < nodeNum; i++)	list.add(scaner.nextInt());
		for (int i = 0; i < round; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			int result = 0;
			if(!list.contains(temp1)&&!list.contains(temp2))	
				System.out.println("ERROR: " + temp1 + " and " + temp2 + " are not found.");
			else if(!list.contains(temp1))						
				System.out.println("ERROR: " + temp1 + " is not found.");
			else if(!list.contains(temp2))						
				System.out.println("ERROR: " + temp2 + " is not found.");
			else {
				for(int j : list)
					if(j >= Math.min(temp1, temp2) && j <= Math.max(temp1, temp2)) {
						result = j;
						break;
					}
				if(result == temp1 || result == temp2)
					System.out.println(result + " is an ancestor of " + (result == temp1 ? temp2 : temp1) + ".");
				else
					System.out.println("LCA of " + temp1 + " and " + temp2 + " is " + result + ".");
			}
			
		}
		scaner.close();
	}
}
