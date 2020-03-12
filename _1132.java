package PATFoo;

import java.util.Scanner;

/**
 * 注意分母为零的情况
 * @author SunFeiran
 *
 */

public class _1132 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		scaner.nextLine();
		for(int i = 0 ; i < round ; i++) {
			String temp = scaner.nextLine();
			String temp1 = temp.substring(0, temp.length()/2);
			String temp2 = temp.substring(temp.length()/2);
			if(Integer.parseInt(temp1) * Integer.parseInt(temp2) != 0 && Integer.parseInt(temp)%(Integer.parseInt(temp1) * Integer.parseInt(temp2)) == 0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		scaner.close();
	}
}
