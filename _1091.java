package PATFoo;

import java.util.Scanner;

public class _1091 {

	static boolean[][][] flag;
	static int height;
	static int length;
	static int width;
	
	static int check(int[][][] slice, int len, int wid, int hei) {
		int total = 0;
		if(!flag[len][wid][hei]) {
			flag[len][wid][hei] = true;
			if(slice[len][wid][hei] == 1)
				total++;
			//上
			if(slice[len][wid][hei] == 1 && hei + 1 <= height - 1)
				total += check(slice, len, wid, hei + 1);
			//下
			if(slice[len][wid][hei] == 1 && hei - 1 >= 0)
				total += check(slice, len, wid, hei - 1);
			//左
			if(slice[len][wid][hei] == 1 && wid - 1 >= 0)
				total += check(slice, len, wid - 1, hei);
			//右
			if(slice[len][wid][hei] == 1 && wid + 1 <= width - 1)
				total += check(slice, len, wid + 1, hei);
			//前
			if(slice[len][wid][hei] == 1 && len - 1 >= 0)
				total += check(slice, len - 1, wid, hei);
			//后
			if(slice[len][wid][hei] == 1 && len + 1 <= length - 1)
				total += check(slice, len + 1, wid, hei);
		}
		return total;
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		length = scaner.nextInt();
		width = scaner.nextInt();
		height = scaner.nextInt();
		int threshold = scaner.nextInt();
		int[][][] slice = new int[length][width][height];
		flag = new boolean[length][width][height];
		for(int i = 0 ; i < height ; i++)
			for(int j = 0 ; j < length ; j++)
				for(int k = 0 ; k < width ; k++)
					slice[j][k][i] = scaner.nextInt();
		scaner.close();
		int sum = 0;
		for(int i = 0 ; i < height ; i++)
			for(int j = 0 ; j < length ; j++)
				for(int k = 0 ; k < width ; k++) {
					int temp = check(slice, j, k, i);
					if(temp >= threshold)
						sum += temp;
				}
		System.out.println(sum);

	}

}
