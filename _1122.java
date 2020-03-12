package PATFoo;

import java.util.Scanner;

public class _1122 {

	static int[][] matrix;
	
	static void check(int[] arr) {
		if(arr.length != matrix.length + 1 || arr[0] != arr[matrix.length] || isRepeated(arr))
			System.out.println("NO");
		else {
			int pre = arr[0] - 1;
			boolean flag = true;
			for(int i = 1 ; i < arr.length ; i++)
				if(matrix[pre][arr[i] - 1] == 1)
					pre = arr[i] - 1;
				else {
					flag = false;
					break;
				}
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");		
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		matrix = new int[round][round];
		round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int temp1 = scaner.nextInt() - 1;
			int temp2 = scaner.nextInt() - 1;
			matrix[temp1][temp2] = matrix[temp2][temp1] = 1;
		}
		round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int num = scaner.nextInt();
			int[] arr = new int[num];
			for(int j = 0 ; j < num ; j++)
				arr[j] = scaner.nextInt();
			check(arr);
		}
		scaner.close();
	}
	
	static boolean isRepeated(int[] arr) {
		boolean flag = false;
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = i + 1 ; j < arr.length ; j++)
				if(arr[i] == arr[j] && (i != 0 || j!= arr.length - 1)) {
					flag = true;
					break;
				}
			if(flag)
				break;
		}
		return flag;
	}

}
