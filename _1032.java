package PATFoo;

import java.util.Scanner;

public class _1032 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String[] temp = scaner.nextLine().split(" ");
		String astart = temp[0];
		String bstart = temp[1];
		int round = Integer.parseInt(temp[2]);
		String[] num = new String[100000];
		for(int i = 0 ; i < num.length ; i++) {
			num[i] = "";
		}
		for(int i = 0 ; i < round ; i++) {
			String[] temp1 = scaner.nextLine().split(" ");
			num[Integer.parseInt(temp1[0])] = temp1[2];
		}
		scaner.close();
		String a = astart;
		String currenta = astart;
		String currentb = bstart;
		while(!currenta.equals("-1")) {
			currenta = num[Integer.parseInt(currenta)];
			a = a + " " + currenta;
		}
		while(true) {
			if(a.contains(currentb)) {
				System.out.println(currentb);
				break;
			}
			else
				currentb = num[Integer.parseInt(currentb)];
		}
	}

}
