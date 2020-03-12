package PATFoo;

import java.util.Scanner;

public class _1150 {
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		int edgeNum = scaner.nextInt();
		int[][] matrix = new int[nodeNum+1][nodeNum+1];
		for (int i = 0; i < edgeNum; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			int dis = scaner.nextInt();
			matrix[temp1][temp2] = matrix[temp2][temp1] = dis;
		}
		int round = scaner.nextInt();
		int index = -1;
		int dis = Integer.MAX_VALUE;
		for (int i = 1; i <= round; i++) {
			int num = scaner.nextInt();
			int pre = scaner.nextInt();
			int first = pre;
			int end = -1;
			int[] flag = new int[nodeNum+1];
			flag[pre] = 1;
			boolean isConnected = true;
			int sum = 0;
			for(int j = 1 ; j < num ; j++) {
				int temp = scaner.nextInt();
				if(j == num - 1) end = temp;
				if(isConnected && matrix[pre][temp] != 0) {
					sum += matrix[pre][temp];
					pre = temp;
					flag[temp]++;
				}
				else isConnected = false;
			}
			if(num > nodeNum && isConnected && first == end) {
				boolean isAllReach = true;
				for(int j = 1 ; j <= nodeNum ; j++)
					if(flag[j] < 1) {
						isAllReach = false;
						break;
					}
				if(isAllReach) {
					if(num == nodeNum + 1)
						System.out.println("Path " + i + ": " + sum + " (TS simple cycle)");
					else
						System.out.println("Path " + i + ": " + sum + " (TS cycle)");
					if(sum < dis) {
						dis = sum;
						index = i;
					}
				}
				else System.out.println("Path " + i + ": " + sum + " (Not a TS cycle)");
			}
			else if(isConnected) System.out.println("Path " + i + ": " + sum + " (Not a TS cycle)");
			else System.out.println("Path " + i + ": NA (Not a TS cycle)");
		}
		scaner.close();
		System.out.println("Shortest Dist(" + index + ") = " + dis);
	}

}
