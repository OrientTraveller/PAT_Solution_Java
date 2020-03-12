package PATFoo;

import java.util.Scanner;

/*
 * https://blog.csdn.net/zjkC050818/article/details/78261628
 * https://blog.csdn.net/zh112711/article/details/93714421
 */

public class _1021 {

	public static int DFS(int[][] grid) {
		boolean[] visited = new boolean[grid.length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			if (!visited[i]) {
				count++;
				dfs(i, grid, visited);
			}
		}
		return count;
	}

	public static void dfs(int i, int[][] grid, boolean[] visited) {
		visited[i] = true;
		for (int j = 0; j < grid.length; j++) {
			if (!visited[j] && grid[i][j] == 1) {
				dfs(j, grid, visited);
			}
		}
	}

	public int[] maxDeepth(int[][] matrix ,int floor) {
		int[] result = new int[matrix.length];
		boolean[] visited = new boolean[matrix.length];
		int deep = 0;
		int temp = 0;
		for (int i = 0; i < matrix.length; i++) {
//			if () {
//				temp++;
//				dfs(i, matrix, visited);
//			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		int[][] matrix = new int[nodeNum][nodeNum];
		scaner.nextLine();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < nodeNum - 1; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			matrix[temp1 - 1][temp2 - 1] = 1;
			matrix[temp2 - 1][temp1 - 1] = 1;
			scaner.nextLine();
		}
		int componentsNum = DFS(matrix);
		if (componentsNum != 1)
			System.out.println("Error: " + componentsNum + " components");
		else {

		}
	}

}
