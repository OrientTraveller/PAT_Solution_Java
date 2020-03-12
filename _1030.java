package PATFoo;

import java.util.Scanner;
import java.util.Stack;

public class _1030 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int citiesNum = scaner.nextInt();
		int roadNum = scaner.nextInt();
		int dep = scaner.nextInt();
		int des = scaner.nextInt();
		int[][] distanceMatrix = new int[citiesNum][citiesNum];
		int[][] costMatrix = new int[citiesNum][citiesNum];
		for(int i = 0 ; i < citiesNum ; i++) {
			for(int j = 0 ; j < citiesNum ; j++) {
				distanceMatrix[i][j] = 999;
				costMatrix[i][j] = 999;
			}
		}
		scaner.nextLine();
		for(int i = 0 ; i < roadNum ; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			int temp3 = scaner.nextInt();
			int temp4 = scaner.nextInt();
			distanceMatrix[temp1][temp2] = distanceMatrix[temp2][temp1] = temp3;
			costMatrix[temp1][temp2] = costMatrix[temp2][temp1] = temp4;
			scaner.nextLine();
		}
		scaner.close();
		
		//
		int[] dis = new int[citiesNum];
		boolean[] flag = new boolean[citiesNum];
		int[] pre = new int[citiesNum];
		int[] cost = new int[citiesNum];
		for(int i = 0 ; i < citiesNum ; i++) {
			dis[i] = distanceMatrix[dep][i];
			if(dis[i] < 999)
				pre[i] = dep;
			flag[i] = false;
			cost[i] = costMatrix[dep][i];
		}
		dis[dep] = 0;
		flag[dep] = true;
		pre[dep] = -1;
		cost[dep] = 0;
		for(int i = 0 ; i < citiesNum -1; i++) {
			int current = -1;
			int tempDis = Integer.MAX_VALUE;			
			for(int j = 0 ; j < citiesNum ; j++) {
				if(flag[j] == false&&dis[j]<tempDis) {
					current = j;
					tempDis = dis[j];
				}
			}
			flag[current] = true;
			for(int j = 0 ; j < citiesNum ; j++) {
				if(dis[current] + distanceMatrix[current][j] < dis[j]) {
					dis[j] = dis[current] + distanceMatrix[current][j];
					pre[j] = current;
					cost[j] = cost[current] + costMatrix[current][j];
				}
				else if(dis[current] + distanceMatrix[current][j] == dis[j]&&cost[current] + costMatrix[current][j] < cost[j]) {
					pre[j] = current;
					cost[j] = cost[current] + costMatrix[current][j];
				}
				else;
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		int current = des;
		while(current != -1) {
			stack.push(current);
			current = pre[current];
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.print(dis[des] + " " + cost[des]);
		
	}

}
