package PATFoo;

import java.util.Scanner;

public class _1027 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int temp1 = scaner.nextInt();
		int temp2 = scaner.nextInt();
		int temp3 = scaner.nextInt();
		scaner.close();
		String result = "#";
		String str1 = Integer.toString(temp1, 13);
		if(str1.length()==1)
			str1 = "0" + str1;
		String str2 = Integer.toString(temp2, 13); 
		if(str2.length()==1)
			str2 = "0" + str2;
		String str3 = Integer.toString(temp3, 13);
		if(str3.length()==1)
			str3 = "0" + str3;
		result = result + str1 + str2 + str3;
		result = result.replace('a', 'A');
		result = result.replace('b', 'B');
		result = result.replace('c', 'C');
		System.out.println(result);

	}

}
