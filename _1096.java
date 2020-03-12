package PATFoo;

import java.util.Scanner;

public class _1096 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		scaner.close();
		int maxNN = 0;
		int start = 0;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			int mult = i;
			int sum = 1;
			int nn = 0;
			while (sum <= num) {
				sum = sum * mult;
				mult++;
				nn++;
				if (num % sum == 0 && nn > maxNN) {
					maxNN = nn;
					start = i;
				}
				if (num % sum == 0 && nn == maxNN && start > i)
					start = i;
			}
		}
		if(start == 0) {
			System.out.println(1);
			System.out.println(num);
		}
		else {
			System.out.println(maxNN);
			for (int i = 0; i < maxNN; i++) {
				if (i == maxNN - 1)
					System.out.print(start + i);
				else
					System.out.print((start + i) + "*");
			}
		}
	}

}
