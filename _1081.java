package PATFoo;

import java.util.Scanner;

public class _1081 {

	// 最大公约数
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
	
	// 求一组数的最大公倍数
	static public int lcm(int[] arr) {
		int value = arr[0];
		for (int i = 1; i < arr.length; i++) {
			value = getLCM(value, arr[i]);
		}
		return value;
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		if(round == 0)
			System.out.println(0);
		else {
			int[] fz = new int[round];
			int[] fm = new int[round];
			for(int i = 0 ; i < round ; i++) {
				String[] tempArr = scaner.next().split("/");
				fz[i] = Integer.parseInt(tempArr[0]);
				fm[i] = Integer.parseInt(tempArr[1]);
			}
			scaner.close();
			int lcm = lcm(fm);
			int fzSum = 0;
			for(int i = 0 ; i < round ; i++) {
				fz[i] = fz[i] * (lcm / fm[i]);
				fzSum += fz[i];
			}
			int[] result = new int[2];
			result[0] = fzSum / lcm;
			result[1] = fzSum % lcm;
			int gcd = getGCD(result[1], lcm);
			if(result[0] != 0 && result[1] != 0) {
				int temp1 = result[1]/gcd;
				int temp2 = lcm/gcd;
				if(temp1 * temp2 > 0)
					System.out.println(result[0] + " " + Math.abs(temp1) + "/" + Math.abs(temp2));
				else
					System.out.println(result[0] + " -" + Math.abs(temp1) + "/" + Math.abs(temp2));
			}
			else if(result[0] == 0 && result[1] != 0) {
				int temp1 = result[1]/gcd;
				int temp2 = lcm/gcd;
				if(temp1 * temp2 > 0)
					System.out.println(Math.abs(temp1) + "/" + Math.abs(temp2));
				else
					System.out.println("-" + Math.abs(temp1) + "/" + Math.abs(temp2));
			}
			else if(result[0] != 0 && result[1] == 0)
				System.out.println(result[0]);
			else
				System.out.println(0);
		}
	}

}
