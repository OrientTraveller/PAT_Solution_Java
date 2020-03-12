package PATFoo;

import java.util.Scanner;

public class _1088 {
	
	// 最大公约数，辗转相除法
	static public int getGCD(int m, int n) {
		if (n == 0) {
			return m;
		}
		return getGCD(n, m % n);
	}

	// 最小公倍数
	static public int getLCM(int m, int n) {
		int mn = m * n;
		return mn / getGCD(m, n);
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String num1 = scaner.next();
		String num2 = scaner.next();
		scaner.close();
		String[] arr1 = num1.split("/");
		String[] arr2 = num2.split("/");
		boolean neg1 = Integer.parseInt(arr1[0]) < 0 ? true : false;
		boolean neg2 = Integer.parseInt(arr2[0]) < 0 ? true : false;
		String r1 = "";
		String r2 = "";
		if(Integer.parseInt(arr1[0])%Integer.parseInt(arr1[1]) == 0)
			r1 = String.valueOf(Math.abs(Integer.parseInt(arr1[0])/Integer.parseInt(arr1[1])));
		else
			r1 = num1;
		if(Integer.parseInt(arr2[0])%Integer.parseInt(arr2[1]) == 0)
			r2 = String.valueOf(Math.abs(Integer.parseInt(arr2[0])/Integer.parseInt(arr2[1])));
		else
			r2 = num2;
		//加法
		int lcm = getLCM(Integer.parseInt(arr1[1]), Integer.parseInt(arr2[1]));
		int fz = Integer.parseInt(arr1[0]) * (lcm/Integer.parseInt(arr1[1])) + Integer.parseInt(arr2[0]) * (lcm/Integer.parseInt(arr2[1]));
		int zs = fz/lcm;
		int gcd = getGCD(fz, lcm);
		//减法
		//乘法
		//除法
		

	}

}
