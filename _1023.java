package PATFoo;

import java.math.BigInteger;
import java.util.Scanner;

public class _1023 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		String num = scaner.nextLine();
		scaner.close();
		BigInteger bn = new BigInteger(num);
		String[] bnstr = bn.toString().split("");
		BigInteger dn = bn.multiply(new BigInteger("2"));
		String[] dnstr = dn.toString().split("");
		if(bnstr.length != dnstr.length) {
			System.out.println("No");
			System.out.println(dn.toString());
		}
		else{
			int[] bnnum = new int[10];
			int[] dnnum = new int[10];
			for(int i = 0 ; i < bnnum.length ; i++) {
				bnnum[i] = 0;
				dnnum[i] = 0;
			}
			for(int i = 0 ; i < bnstr.length ; i++) {
				bnnum[Integer.valueOf(bnstr[i])]++;
				dnnum[Integer.valueOf(dnstr[i])]++;
			}
			boolean flag = true;
			for(int i = 0 ; i < bnnum.length ; i++) {
				if(bnnum[i] != dnnum[i])
					flag = false;
			}
			if(flag == false) {
				System.out.println("No");
				System.out.println(dn.toString());
			}
			else {
				System.out.println("Yes");
				System.out.println(dn.toString());
			}
		}

	}

}
