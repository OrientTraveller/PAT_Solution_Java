package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1113 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] arr = new int[num];
		for(int i = 0 ; i < num ; i++) arr[i] = scaner.nextInt();
		scaner.close();
		Arrays.sort(arr);
		int index = num/2 - 1; int sum1 = 0; int sum2 = 0;
		for(int i = 0 ; i < num ; i++)
			if(i <= index) 	sum1 += arr[i];
			else 			sum2 += arr[i];
		System.out.println(num%2 + " " + (sum2 - sum1));
	}

}
