package PATFoo;

import java.util.Scanner;

public class _1041超时 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int[] num = new int[round];
		for(int i = 0 ; i < round ; i++) {
			num[i] = scaner.nextInt();
		}
		scaner.close();
		boolean b = false;
		for(int i = 0 ; i < num.length ; i++) {
			boolean flag = true;
			for(int j = 0 ; j < num.length ; j++) {
				if(num[j] == num[i]&&j != i) {
					flag = false;
					break;
				}
			}
			if(flag) {
				b = true;
				System.out.println(num[i]);
				break;
			}
		}
		if(!b)
			System.out.println("None");

	}

}
