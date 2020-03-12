package PATFoo;

import java.util.HashSet;
import java.util.Scanner;

public class _1142 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		int[][] matrix = new int[nodeNum + 1][nodeNum + 1];
		for(int i = 1 ; i <= nodeNum ; i++)
			matrix[i][i] = 1;
		int edgeNum = scaner.nextInt();
		for (int i = 0; i < edgeNum; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			matrix[temp1][temp2] = matrix[temp2][temp1] = 1;
		}
		int round = scaner.nextInt();
		for (int i = 0; i < round; i++) {
			int num = scaner.nextInt();
			HashSet<Integer> set = new HashSet<Integer>();
			HashSet<Integer> oriSet = new HashSet<Integer>();
			boolean[] flag = new boolean[nodeNum + 1];
			for (int j = 0; j < num; j++) {
				int temp = scaner.nextInt();
				oriSet.add(temp);
				for(int k = 1 ; k <= nodeNum ; k++)
					if(!flag[k] && matrix[temp][k] == 1)
						set.add(k);
					else {
						flag[k] = true;
						if(set.contains((Object)k))
							set.remove((Object)k);
					}
			}
			if(set.equals(oriSet))
				System.out.println("Yes");
			else if(set.containsAll(oriSet))
				System.out.println("Not Maximal");
			else
				System.out.println("Not a Clique");
		}
		scaner.close();

	}

}
