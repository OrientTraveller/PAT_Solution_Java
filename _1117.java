package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1117 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] record = new int[num];
		for(int i = 0 ; i < num ; i++)
			record[i] = scaner.nextInt();
		scaner.close();
		Arrays.sort(record);
		for(int i = num - 1 ; i >= 0 ; i--) {
			if(record[i] <= num - i) {
				System.out.println(record[i]);
				break;
			}
		}
		
	}
}
