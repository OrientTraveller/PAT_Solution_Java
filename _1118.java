package PATFoo;

import java.util.Scanner;

public class _1118 {

	static int[] parent = new int[10010];

	static int find(int x) {
		int k = x;
		while (x != parent[x])
			x = parent[x];
		while (k != parent[k]) {
			int z = k;
			k = parent[k];
			parent[z] = x;
		}
		return x;
	}

	static void join(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		if (fx != fy)
			parent[fx] = fy;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;
		int birdNum = 0;
		for (int i = 0; i < round; i++) {
			int num = scaner.nextInt();
			int pre = scaner.nextInt();
			birdNum = pre > birdNum ? pre : birdNum;
			for (int j = 0; j < num - 1; j++) {
				int temp = scaner.nextInt();
				birdNum = temp > birdNum ? temp : birdNum;
				join(pre, temp);
			}
		}
		int treeNum = 0;
		for (int i = 1; i <= birdNum; i++)
			if (parent[i] == i)
				treeNum++;
		System.out.println(treeNum + " " + birdNum);
		round = scaner.nextInt();
		for (int i = 0; i < round; i++)
			if (find(scaner.nextInt()) == find(scaner.nextInt()))
				System.out.println("Yes");
			else
				System.out.println("No");
		scaner.close();

	}
}
