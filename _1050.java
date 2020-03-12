package PATFoo;

import java.util.Scanner;

public class _1050 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		char[] arr = scaner.nextLine().toCharArray();
		boolean[] flag = new boolean[128];
		char[] ban = scaner.nextLine().toCharArray();
		scaner.close();
		for(char c : ban) {
			flag[c] = true;
		}
		for(char c : arr) {
			if(flag[c] != true)
				System.out.print(c);
		}

	}

}
