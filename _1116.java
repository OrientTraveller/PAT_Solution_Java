package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1116 {

	static boolean isPrime(int rank) {
		boolean flag = true;
		for(int i = 2 ; i < Math.sqrt(rank) ; i++)
			if(rank % i == 0) {
				flag = false;
				break;
			}
		return flag;
	}
	
	public static void main(String[] args) {
		int[] flag = new int[10000];
		Arrays.fill(flag, -1);
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++)
			flag[scaner.nextInt()] = i + 1;
		round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			String temp = scaner.next();
			int tempInt = Integer.parseInt(temp);
			if(flag[tempInt] == -1)
				System.out.println(temp+": Are you kidding?");
			else if(flag[tempInt] == 1) {
				System.out.println(temp+": Mystery Award");
				flag[tempInt] = -2;
			}
			else if(flag[tempInt] >= 2 && isPrime(flag[tempInt])) {
				System.out.println(temp+": Minion");
				flag[tempInt] = -2;
			}
			else if(flag[tempInt] >= 2 && !isPrime(flag[tempInt])) {
				System.out.println(temp+": Chocolate");
				flag[tempInt] = -2;
			}
			else if(flag[tempInt] == -2)
				System.out.println(temp+": Checked");
		}
		scaner.close();

	}

}
