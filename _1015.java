package PATFoo;

import java.util.ArrayList;
import java.util.Scanner;

public class _1015 {

	public static boolean prime(int x) {
		boolean flag = true;
		if (x <= 1)
			flag = false;
		else {
			for (int i = 2; i * i <= x; i++) {
				if (x % i == 0)
					flag = false;
			}
		}
		return flag;
	}

	public static int reverse(int n, int d) {

		return 0;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		ArrayList<Integer> n = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		while (true) {
			int num = scaner.nextInt();
			if (num < 0)
				break;
			int dia = scaner.nextInt();
			n.add(num);
			d.add(dia);
			scaner.nextLine();
		}
		scaner.close();
		for (int i = 0; i < n.size(); i++) {
			int ori = n.get(i);
			String[] tran = Integer.toString(n.get(i), d.get(i)).split("");
			for (int j = 0; j < tran.length / 2; j++) {
				String temp = tran[j];
				tran[j] = tran[tran.length - 1 - j];
				tran[tran.length - 1 - j] = temp;
			}
			int rev = 0;
			int pow = 0;
			for(int j = tran.length - 1 ; j >= 0 ; j--) {
				rev = (int) (rev + Integer.parseInt(tran[j]) * Math.pow(d.get(i), pow));
				pow++;
			}
			if(prime(ori)&&prime(rev))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		

	}

}
