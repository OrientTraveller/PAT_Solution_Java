package PATFoo;

import java.util.Scanner;

public class _1128 {
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int num = scaner.nextInt();
			int[] arr = new int[num];
			boolean flag = true;
			for(int j = 0 ; j < num ; j++) {
				arr[j] = scaner.nextInt();
				for(int k = 0 ; k < j ; k++)
					if(arr[j] == arr[k] || Math.abs(arr[j] - arr[k]) == Math.abs(j - k)) {
						flag = false;
						break;
					}
			}
			if(flag)	System.out.println("YES");
			else		System.out.println("NO");
		}
		scaner.close();
	}
}
