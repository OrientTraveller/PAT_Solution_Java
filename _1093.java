package PATFoo;

import java.util.Scanner;

public class _1093 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String str = scaner.nextLine();
		scaner.close();
		int len = str.length(); int result = 0; int countp = 0; int countt = 0;
		for (int i = 0; i < len; i++)
			if (str.charAt(i) == 'T')
				countt++;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'P')
				countp++;
			if (str.charAt(i) == 'T')
				countt--;
			if (str.charAt(i) == 'A')
				result = (result + (countp * countt) % 1000000007) % 1000000007;
		}
		System.out.println(result);
	}

}
