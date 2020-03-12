package PATFoo;

import java.util.Scanner;

public class _1108 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int num = 0;
		float sum = 0;
		for(int i = 0 ; i < round ; i++) {
			String temp = scaner.next();
			try {
				float tempFloat = Float.parseFloat(temp);
				if(tempFloat > 1000 || tempFloat < -1000 || String.valueOf(tempFloat).split("\\.")[1].length() > 2)
					System.out.println("ERROR: " + temp + " is not a legal number");
				else {
					sum += tempFloat;
					num++;
				}
			} catch (Exception e) {
				System.out.println("ERROR: " + temp + " is not a legal number");
			}
		}
		scaner.close();
		if(num == 0)
			System.out.println("The average of 0 numbers is Undefined");
		else if(num == 1)
			System.out.println("The average of 1 number is " + String.format("%.2f", sum));
		else
			System.out.println("The average of " + num + " numbers is " + String.format("%.2f", sum/num));

	}

}
