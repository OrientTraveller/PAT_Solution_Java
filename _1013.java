package PATFoo;

import java.util.Scanner;

public class _1013 {
	
	public static int[][] clear(int[][] ori) {
		int[][] newmatrix = new int[ori.length][ori.length];
		for(int i = 0 ; i < ori.length ; i++) {
			for(int j = 0 ; j < ori.length ; j++) {
				newmatrix[i][j] = 0;
			}
		}
		return newmatrix;
	}
	
	public static int DFS(int[][] grid){
		boolean[] visited=new boolean[grid.length];
		int count=0;
		for(int i=0;i<grid.length;i++){
			if(!visited[i]){
				count++;
				dfs(i,grid,visited);
			}
		}
		return count;
	}
	public static void dfs(int i,int[][] grid,boolean[] visited){
		visited[i]=true;
		for(int j=0;j<grid.length;j++){
			if(!visited[j] && grid[i][j]==1){
				dfs(j,grid,visited);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int cityNum = scaner.nextInt();
		int roadNum = scaner.nextInt();
		int checkNum = scaner.nextInt();
		scaner.nextLine();
		String[] roads = new String[roadNum];
		for(int i = 0 ; i < roadNum ; i++) {
			roads[i] = scaner.nextLine();
		}
		String[] checkCityNum = scaner.nextLine().split(" ");
		scaner.close();
		int[][] matrix = new int[cityNum][cityNum];
		for(int i = 0 ; i < checkNum ; i++) {
			matrix = clear(matrix);
			String currentCity = checkCityNum[i];
			for(int j = 0 ; j < roads.length ; j++) {
				if(!roads[j].contains(currentCity)) {
					String[] cities = roads[j].split(" ");
					int start = Integer.parseInt(cities[0]);
					int des = Integer.parseInt(cities[1]);
					matrix[start-1][des-1] = 1;
					matrix[des-1][start-1] = 1;	
				}
			}
			int num = DFS(matrix) - 2;
			System.out.println(num);
//			if(num == cityNum - 1)
//				System.out.println(cityNum - 2);
//			else
//				System.out.println(num);
		}

	}

}
