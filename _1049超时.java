package PATFoo;

import java.util.Scanner;

public class _1049超时 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int edge = scaner.nextInt();
		scaner.close();
		int sum = 0;
		for(int i = 1 ; i <= edge ; i++) {
			String temp = String.valueOf(i);
			while ((temp.indexOf("1")) != -1) {
	            sum++;
	            temp = temp.substring(temp.indexOf("1") + 1);
	        }
		}
		System.out.println(sum);

	}

}
