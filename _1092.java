package PATFoo;

import java.util.Scanner;

public class _1092 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int[] ori = new int[62];
		int eva = 0;
		String str1 = scaner.nextLine();
		String str2 = scaner.nextLine();
		scaner.close();
		for (int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			if (c >= '0' && c <= '9')
				ori[c - 48]++;
			else if (c >= 'a' && c <= 'z')
				ori[c - 61]++;
			else
				ori[c - 55]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			char c = str2.charAt(i);
			if (c >= '0' && c <= '9' && ori[c - 48] > 0) {
				eva++;
				ori[c - 48]--;
			} else if (c >= 'a' && c <= 'z' && ori[c - 61] > 0) {
				eva++;
				ori[c - 61]--;
			} else if (c >= 'A' && c <= 'Z' && ori[c - 55] > 0) {
				eva++;
				ori[c - 55]--;
			}
		}
		if (eva == str2.length())
			System.out.println("Yes" + " " + (str1.length() - eva));
		else
			System.out.println("No" + " " + (str2.length() - eva));

	}

}
