package PATFoo;

import java.util.Scanner;

public class _1104 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		float sum = 0;
		for(int i = 0 ; i < num ; i++) sum += (num - i) * (i + 1) * scaner.nextFloat();
		scaner.close();
		System.out.println(String.format("%.2f", sum));

	}

}
