package PATFoo;

import java.util.Scanner;

public class _1046 {

	public static void main(String[] args) {
		long startTime=System.nanoTime();   //获取开始时间 
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int sum = 0;
		int dis[] = new int[round];
		for(int i = 0 ; i < round ; i++) {
			int temp = scaner.nextInt();
			dis[i] = temp;
			if(i >= 1)
				dis[i] += dis[i - 1];
		}
		sum = dis[round - 1];
		round = scaner.nextInt();
		for(int i = 0 ; i < round ; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			int start = temp1 > temp2? temp2 : temp1;
			int end = temp1 > temp2? temp1 : temp2;
			int result = 0;
			if(start == end)
				System.out.println(0);
			else {
				if(start == 1) {
					result = dis[end - 2];
					if(result <= sum/2)
						System.out.println(result);
					else
						System.out.println(sum - result);
				}
				else {
					result = dis[end - 2] - dis[start - 2];
					if(result <= sum/2)
						System.out.println(result);
					else
						System.out.println(sum - result);
				}
			}
		}

		scaner.close();
		long endTime=System.nanoTime(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); 

	}

}
