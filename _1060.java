package PATFoo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class _1060 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int digit = scaner.nextInt();
		String num1 = scaner.next();
		String num2 = scaner.next();
		BigDecimal bd1 = new BigDecimal(num1,new MathContext(digit,RoundingMode.DOWN));
		BigDecimal bd2 = new BigDecimal(num2,new MathContext(digit,RoundingMode.DOWN));
		scaner.close();
		if(bd1.equals(bd2)) {
			int e = bd1.toPlainString().split("\\.")[0].length();
			System.out.println("YES " + bd1.divide(new BigDecimal(Math.pow(10, e))) + "*10^" + e);
		}
		else {
			int e1 = bd1.toPlainString().split("\\.")[0].length();
			int e2 = bd2.toPlainString().split("\\.")[0].length();
			String str1 = bd1.divide(new BigDecimal(Math.pow(10, e1)),digit,RoundingMode.HALF_UP) + "*10^" + e1;
			String str2 = bd2.divide(new BigDecimal(Math.pow(10, e2)),digit,RoundingMode.HALF_UP) + "*10^" + e2;
			bd2.divide(new BigDecimal(Math.pow(10, e2)));
			System.out.print("NO " + str1 + " " + str2);
		}

	}

}
