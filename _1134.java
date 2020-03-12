package PATFoo;

import java.util.LinkedList;
import java.util.Scanner;

public class _1134 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		int edgeNum = scaner.nextInt();
		LinkedList<LinkedList<Integer>> record =new LinkedList<LinkedList<Integer>>();;
		for(int i = 0 ; i < nodeNum ; i++)
			record.add(new LinkedList<Integer>());
		for(int i = 0 ; i < edgeNum ; i++) {
			record.get(scaner.nextInt()).add(i);
			record.get(scaner.nextInt()).add(i);
		}
		int round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int[] flag = new int[edgeNum];
			int num = scaner.nextInt();
			for(int j = 0 ; j < num ; j++) {
				for(int k : record.get(scaner.nextInt()))
					if(flag[k] == 0)
						flag[k] = 1;
			}
			boolean yesOrno = true;
			for(int k : flag)
				if(k == 0) {
					yesOrno = false;
					break;
				}
			if(yesOrno)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		scaner.close();

	}

}
