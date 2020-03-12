package PATFoo;

import java.util.Scanner;

public class _1031 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String str = scaner.nextLine();
		scaner.close();
		Double len = (double) str.length();
		int lastNum = (int) Math.ceil((len+2)/3.0);
		if((len - lastNum)%2 != 0)
			lastNum++;
		System.out.println(lastNum);
		String[] strs = str.split("");
		int floorNum = (int) ((len - lastNum)/2 + 1);
		for(int i = 0 ; i < floorNum - 1 ; i++) {
			System.out.print(strs[i]);
			for(int j = 0 ; j < lastNum - 2 ; j++) {
				System.out.print(" ");
			}
			System.out.print(strs[strs.length - 1 - i]);
			System.out.println();
		}
		for(int i = floorNum - 1 ; i < floorNum - 1 + lastNum ; i++) {
			System.out.print(strs[i]);
		}

	}

}
