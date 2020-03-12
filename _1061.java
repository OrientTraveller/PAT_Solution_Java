package PATFoo;

import java.util.Scanner;

public class _1061 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String str1 = scaner.nextLine();
		String str2 = scaner.nextLine();
		String str3 = scaner.nextLine();
		String str4 = scaner.nextLine();
		scaner.close();
		int edge1 = Math.min(str1.length(), str2.length());
		int edge2 = Math.min(str3.length(), str4.length());
		int mid = 0;
		for(int i = 0 ; i < edge1 ; i++) {
			char temp1 = str1.charAt(i);
			char temp2 = str2.charAt(i);
			if(Character.isUpperCase(temp1)&&temp1 >= 'A'&&temp1 <= 'G'&&temp1 == temp2) {
				if(temp1 == 'A')
					System.out.print("MON ");
				else if(temp1 == 'B')
					System.out.print("TUE ");
				else if(temp1 == 'C')
					System.out.print("WED ");
				else if(temp1 == 'D')
					System.out.print("THU ");
				else if(temp1 == 'E')
					System.out.print("FRI ");
				else if(temp1 == 'F')
					System.out.print("SAT ");
				else
					System.out.print("SUN ");
				mid = i + 1;
				break;
			}
		}
		for(int i = mid ; i < edge1 ; i++) {
			char temp1 = str1.charAt(i);
			char temp2 = str2.charAt(i);
			if(((temp1 >= 'A'&&temp1 <= 'N')||(temp1 >= '0' && temp1 <= '9'))&&temp1 == temp2) {
				int hour = 0;
				if(temp1 >= 'A'&&temp1 <= 'N')
					hour = temp1 - 55;
				else
					hour = temp1 - 48;
				System.out.print(String.format("%02d", hour) + ":");
				break;
			}
		}
		for(int i = 0 ; i < edge2 ; i++) {
			char temp1 = str3.charAt(i);
			char temp2 = str4.charAt(i);
			if(Character.isAlphabetic(temp1)&&temp1 == temp2) {
				System.out.print(String.format("%02d", i));
				break;
			}
		}
	}

}
