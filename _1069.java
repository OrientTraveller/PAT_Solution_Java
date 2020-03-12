package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1069 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		scaner.close();
		boolean flag = false;
		if(num % 1111 == 0) {
			String temp = String.format("%04d", num);
			System.out.println(temp + " - " + temp + " = 0000");
		}
		else {
			while(num != 6174||!flag) {
				char[] oriArr = String.format("%04d", num).toCharArray();
				Arrays.sort(oriArr);
				String ori = String.valueOf(oriArr);
				String rev = new StringBuffer(ori).reverse().toString();
				num = Integer.parseInt(rev) - Integer.parseInt(ori);
				if(num == 6174)
					flag = true;
				System.out.println(rev + " - " + ori + " = " + String.format("%04d", num));
			}	
		}
	}
}
