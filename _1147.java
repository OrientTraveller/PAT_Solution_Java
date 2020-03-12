package PATFoo;

import java.util.Scanner;

public class _1147 {
	
	static int[] arr;
	static String result;

	static int check(int index, int pre) {
		if(2*index+1 >= arr.length) return pre;
		else if(2*index+2 >= arr.length) {
			if(arr[index] >= arr[2*index+1] && (pre == 1 || pre == -2))	return 1;
			if(arr[index] <= arr[2*index+1] && (pre == -1 || pre == -2)) 	return -1;
			return 0;
		}
		else {
			if(arr[index] >= Math.max(arr[2*index+1], arr[2*index+2]) && (pre == 1 || pre == -2))
				return check(index+1, 1);
			if(arr[index] <= Math.min(arr[2*index+1], arr[2*index+2]) && (pre == -1 || pre == -2))
				return check(index+1, -1);
			return 0;
		}
	}
	
	static void postOrder(int index) {
		if(index < arr.length) {
			postOrder(2*index+1);
			postOrder(2*index+2);
			result += arr[index] + " ";
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int size = scaner.nextInt();
		for (int i = 0; i < round; i++) {
			arr = new int[size];
			result = "";
			for (int j = 0; j < size; j++)
				arr[j] = scaner.nextInt();
			int flag = check(0, -2);
			if(flag == 1)		System.out.println("Max Heap");
			else if(flag == 0)	System.out.println("Not Heap");
			else				System.out.println("Min Heap");	
			postOrder(0);
			System.out.println(result.trim());
		}
		scaner.close();

	}

}
