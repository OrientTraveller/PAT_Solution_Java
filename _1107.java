package PATFoo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class _1107 {
	
	static int peopleNum;
	
	static void getCC(int[][] matrix) {
		boolean[] flag = new boolean[matrix.length];
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		int sum = 0;
		for(int i = 0 ; i < matrix.length ; i++) {
			if(!flag[i]) {
				sum = 0;
				list.clear();
				list.add(i);
				while(list.size() > 0) {
					int temp = list.remove();
					flag[temp] = true;
					if(temp < peopleNum)
						sum++;
					for(int j = 0 ; j < matrix.length ; j++)
						if(!flag[j] && matrix[temp][j] == 1 && !list.contains(j))
							list.add(j);
				}
				if(sum > 0)
					result.add(sum);
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int i = result.size() - 1 ; i >= 0 ; i--) {
			System.out.print(result.get(i));
			if(i != 0)
				System.out.print(" ");
		}
		
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		peopleNum = scaner.nextInt();
		int[][] matrix = new int[peopleNum + 1000][peopleNum + 1000];
		for(int i = 0 ; i < peopleNum ; i++) {
			int temp = Integer.parseInt(scaner.next().split("")[0]);
			int[] tempArr = new int[temp];
			for(int j = 0 ; j < temp ; j++) tempArr[j] = scaner.nextInt();
			for(int j = 0 ; j < temp ; j++) {
				if(j != temp - 1)
					matrix[tempArr[j] - 1 + peopleNum][tempArr[j + 1] - 1 + peopleNum] = matrix[tempArr[j + 1] - 1 + peopleNum][tempArr[j] - 1 + peopleNum] = 1;
				matrix[i][tempArr[j] - 1 + peopleNum] = matrix[tempArr[j] - 1 + peopleNum][i] =  1;
			}
		}
		scaner.close();
		getCC(matrix);
	}

}
