package PATFoo;

import java.util.Scanner;

public class _1041 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int[] num = new int[round];
		int[] temp = new int[10005];
		for(int i = 0 ; i < temp.length ; i++) {
			temp[i] = 0;
		}
		for(int i = 0 ; i < round ; i++) {
			int tempint = scaner.nextInt();
			num[i] = tempint;
			temp[tempint]++;
		}
		scaner.close();
		boolean flag = false;
		for(int i = 0 ; i < round ; i++) {
			if(temp[num[i]] == 1) {
				System.out.println(num[i]);
				flag = true;
				break;
			}
		}
		if(!flag)
			System.out.println("None");

	}

}
