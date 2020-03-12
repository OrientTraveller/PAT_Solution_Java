package PATFoo;

import java.util.Scanner;

public class _1049 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int edge = scaner.nextInt();
		scaner.close();
		int a = 1;
		int sum = 0;
		int current = 1;
		while(edge/a >= 1) {
			System.out.println("！！！！！！！！第" + current + "次:");
			current++;
			int left = edge/(a * 10);
			int now = edge/a%10;
			int right = edge%a;
			System.out.println("left: " + left + "right: " + right + "now: " + now);
			System.out.println("没加之前"+sum);
			if(now == 0)
				sum += left * a;
			else if(now == 1)
				sum += left * a + right + 1;
			else
				sum += (left + 1) * a;
			a *= 10;
			System.out.println("加之后"+sum);
		}
		System.out.println(sum);

	}

}
