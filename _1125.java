package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1125 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] arr = new int[num];
		for(int i = 0 ; i < num ; i++)
			arr[i] = scaner.nextInt();
		scaner.close();
		Arrays.sort(arr);
		float sum = arr[0];
		for(int i = 1 ; i < arr.length ; i++)
			sum = (sum + arr[i])/2;
		System.out.println((int)Math.floor(sum));
	}

}
