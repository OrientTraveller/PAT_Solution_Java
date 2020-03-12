package PATFoo;

import java.math.BigDecimal;
import java.util.Scanner;

public class _1073 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String str = scaner.nextLine();
		scaner.close();
		BigDecimal bd = new BigDecimal(str);
		System.out.println(bd.toPlainString());

	}

}
