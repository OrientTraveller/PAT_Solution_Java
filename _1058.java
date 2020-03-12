package PATFoo;

import java.util.Scanner;

public class _1058 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String[] strs = scaner.nextLine().split(" ");
		scaner.close();
		String[] num1 = strs[0].split("\\.");
		String[] num2 = strs[1].split("\\.");
		int[] result = new int[3];
		int add1 = 0;
		int add2 = 0;
		for(int i = 2 ; i >= 0 ; i--) {
			int temp1 = Integer.parseInt(num1[i]);
			int temp2 = Integer.parseInt(num2[i]);
			if(i == 2) {
				if(temp1 + temp2 >= 29) {
					add1 = (temp1 + temp2)/29;
					result[i] = temp1 + temp2 - 29;
				}
				else
					result[i] = temp1 + temp2;
			}
			if(i == 1) {
				if(temp1 + temp2 + add1 >= 17) {
					add2 = (temp1 + temp2 + add1)/17;
					result[i] = temp1 + temp2 + add1 - 17;
				}
				else
					result[i] = temp1 + temp2 + add1;
			}
			if(i == 0) {
				result[i] = temp1 + temp2 + add2;
			}
		}
		for(int i  = 0 ; i <= 2 ; i++)
			if(i <= 1) {
				System.out.print(result[i] + ".");
			}
			else
				System.out.print(result[i]);
	}
}
