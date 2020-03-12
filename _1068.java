package PATFoo;

import java.util.Scanner;

public class _1068 {
	
	static boolean flag = false;
	
	static void check(int[] money , int start , int end , String result) {
		if(end < start&&end==0&&!flag) {
			System.out.println(result.trim());
			flag = true;
		}
		else {
			if(!flag) {
				for(int i = start ; i <= end ; i++)
					if(money[i] == 1)
						check(money,i+1,end-i,result+i+" ");
					else if(money[i] > 1)
						check(money,i,end-i,result+i+" ");
					else
						continue;
			}	
		}
	}

	public static void main(String[] args) {
		int[] money = new int[101];
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int total = scaner.nextInt();
		int sum = 0;
		for(int i = 0 ; i < num ; i++) {
			int temp = scaner.nextInt();
			if(temp <= 100) {
				money[temp]++;
				sum = sum + temp;
			}
		}
		scaner.close();
		if(sum<total)
			System.out.println("No Solution");
		else {
			check(money,1,total,"");
			if(!flag)
				System.out.println("No Solution");
		}
	}

}
