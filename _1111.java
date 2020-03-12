package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1111 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		int edgeNum = scaner.nextInt();
		int[][] lengthMatrix = new int[nodeNum][nodeNum];
		int[][] timeMatrix = new int[nodeNum][nodeNum];
		for(int i = 0 ; i < edgeNum ; i++) {
			int start = scaner.nextInt();
			int end = scaner.nextInt();
			int flag = scaner.nextInt();
			int length = scaner.nextInt();
			int time = scaner.nextInt();
			if(flag == 0) {
				lengthMatrix[start][end] = lengthMatrix[end][start] = length;
				timeMatrix[start][end] = timeMatrix[end][start] = time;
			}
			else {
				lengthMatrix[start][end] = length;
				timeMatrix[start][end] = time;
			}
		}
		int start = scaner.nextInt();
		int end = scaner.nextInt();
		scaner.close();
		//两者都需要的数组
		boolean[] flag = new boolean[nodeNum];
		//时间需要的辅助数组
		int[] time = new int[nodeNum];
		int[] node = new int[nodeNum];
		int[] timePre = new int[nodeNum];
		Arrays.fill(node, 1);
		Arrays.fill(time, 99999);
		time[start] = 0;
		//距离需要的辅助数组
		int[] dis = new int[nodeNum];
		int[] disPre = new int[nodeNum];
		int[] disTime = new int[nodeNum];
		Arrays.fill(dis, 99999);
		dis[start] = 0;
		
		//初始化
		for(int i = 0 ; i < nodeNum ; i++) if(timeMatrix[start][i] > 0) {time[i] = disTime[i] = timeMatrix[start][i]; timePre[i] = start;}
		for(int i = 0 ; i < nodeNum ; i++) if(lengthMatrix[start][i] > 0) {dis[i] = lengthMatrix[start][i]; disPre[i] = start;}
		//时间迪杰斯特拉
		for(int i = 0 ; i < nodeNum ; i++) {
			int minTime = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0 ; j < nodeNum ; j++)
				if(!flag[j] && time[j] < minTime) {
					minTime = time[j];
					minIndex = j;
				}
			flag[minIndex] = true;
			for(int j = 0 ; j < nodeNum ; j++) {
				if(!flag[j] && timeMatrix[minIndex][j] > 0 && time[j] > time[minIndex] + timeMatrix[minIndex][j]) {
					time[j] = time[minIndex] + timeMatrix[minIndex][j];
					timePre[j] = minIndex;
					node[j] = node[minIndex] + 1;
				}
				if(!flag[j] && timeMatrix[minIndex][j] > 0 && time[j] == time[minIndex] + timeMatrix[minIndex][j] && node[minIndex] + 1 < node[j]) {
					timePre[j] = minIndex;
					node[j] = node[minIndex] + 1;
				}
			}
		}
		Arrays.fill(flag, false);
		//距离迪杰斯特拉
		for(int i = 0 ; i < nodeNum ; i++) {
			int minDis = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int j = 0 ; j < nodeNum ; j++)
				if(!flag[j] && dis[j] < minDis) {
					minDis = dis[j];
					minIndex = j;
				}
			flag[minIndex] = true;
			for(int j = 0 ; j < nodeNum ; j++) {
				if(!flag[j] && lengthMatrix[minIndex][j] > 0 && dis[j] > dis[minIndex] + lengthMatrix[minIndex][j]) {
					dis[j] = dis[minIndex] + lengthMatrix[minIndex][j];
					disTime[j] = disTime[minIndex] + timeMatrix[minIndex][j];
					disPre[j] = minIndex;
				}
				if(!flag[j] && lengthMatrix[minIndex][j] > 0 && dis[j] == dis[minIndex] + lengthMatrix[minIndex][j] && disTime[j] > disTime[minIndex] + timeMatrix[minIndex][j]) {
					disTime[j] = disTime[minIndex] + timeMatrix[minIndex][j];
					disPre[j] = minIndex;
				}
			}
		}
		int timeIndex = end;
		int disIndex = end;
		String timeResult = "";
		String disResult = "";
		while(timeIndex != start) {
			timeResult = " -> " + timeIndex + timeResult;
			timeIndex = timePre[timeIndex];
		}
		timeResult = start + timeResult;
		while(disIndex != start) {
			disResult = " -> " + disIndex + disResult;
			disIndex = disPre[disIndex];
		}
		disResult = start + disResult;
		if(timeResult.equals(disResult))
			System.out.println("Distance = " + dis[end] + "; Time = " + time[end] + ": " + timeResult);
		else {
			System.out.println("Distance = " + dis[end] + ": " + disResult);
			System.out.println("Time = " + time[end] + ": " + timeResult);
		}
	}

}
