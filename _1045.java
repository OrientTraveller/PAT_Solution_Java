package PATFoo;

import java.util.Scanner;

public class _1045 {

	public static void main(String[] args) {
		int[][] dp = new int[205][10005];
		Scanner scaner = new Scanner(System.in);
		scaner.nextInt();
		int round1 = scaner.nextInt();
		int[] order = new int[round1];
		for(int i = 0 ; i < round1 ; i++) {
			order[i] = scaner.nextInt();
		}
		int round2 = scaner.nextInt();
		int[] color = new int[round2];
		for(int i = 0 ; i < round2 ; i++) {
			color[i] = scaner.nextInt();
		}
		scaner.close();
		for(int i = 1 ; i <= round1 ; i++) {
			for(int j = 1 ; j <= round2 ; j++) {
				if(order[i - 1] == color[j - 1])
					//元素不能重复版本
					dp[i][j]=dp[i-1][j-1]+1;
				    //元素可以重复版本
//					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+1;
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					
			}
		}
		System.out.println(dp[round1][round2]);
		for(int i = 1 ; i <= round1 ; i++) {
			for(int j = 1 ; j <= round2 ; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}

}
