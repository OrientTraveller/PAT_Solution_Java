package PATFoo;

import java.util.HashSet;
import java.util.Scanner;

public class _1154 {

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int nodeNum = scaner.nextInt();
		int edgeNum = scaner.nextInt();
		int[][] edge = new int[edgeNum][2];
		for (int i = 0; i < edgeNum; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			edge[i][0] = temp1;
			edge[i][1] = temp2;
		}
		int round = scaner.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < round; i++) {
			int[] color = new int[nodeNum];
			set.clear();
			boolean flag = true;
			for (int j = 0; j < nodeNum; j++) {color[j] = scaner.nextInt();set.add(color[j]);}
			loop:
			for (int j = 0; j < edgeNum; j++)
				if(color[edge[j][0]] == color[edge[j][1]]) {
					System.out.println("No");
					flag = false;
					break loop;
				}	
			if(flag) System.out.println(set.size()+"-coloring");
		}
		scaner.close();
	}
}

/**
 * C++
 *#include <iostream>
#include <stdio.h>
#include <set>
using namespace std;
int main()
{
    int nodeNum,edgeNum,round,colorNum;
    scanf("%d %d",&nodeNum,&edgeNum);
    int edge[edgeNum][2];
    for (int i = 0; i < edgeNum; i++) scanf("%d %d",&edge[i][0],&edge[i][1]);
    scanf("%d",&round);
    for (int i = 0; i < round; i++) {
        int color[nodeNum];
        bool flag = true;
        colorNum = 0;
        set<int> mySet;
        for (int j = 0; j < nodeNum; j++) {
            scanf("%d",&color[j]);
            mySet.insert(color[j]);
        }
        for (int j = 0; j < edgeNum; j++)
            if(color[edge[j][0]] == color[edge[j][1]]) {
                printf("No\n");
                flag = false;
                break;
            }
        if(flag) printf("%d-coloring\n",mySet.size());
    }
    return 0;
}
 */
