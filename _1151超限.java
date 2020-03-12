package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

public class _1151超限 {
	
	static boolean isExit(int i, int[] arr) {
		for(int j : arr)
			if(j == i)	return true;
		return false;
	}
	
	static void find(int[] preOrder, int[] inOrder, int temp1, int temp2) {
		int index = -1;
		for(int i = 0 ; i < inOrder.length ; i++)
			if(inOrder[i] == preOrder[0]) {index = i; break;}
		int[] leftPre = Arrays.copyOfRange(preOrder, 1, 1+index);
		int[] leftIn = Arrays.copyOfRange(inOrder, 0, index);
		int[] rightPre = Arrays.copyOfRange(preOrder, 1+index, preOrder.length); 
		int[] rightIn = Arrays.copyOfRange(inOrder, index+1, inOrder.length);
		if (leftPre.length > 0 && isExit(temp1, leftPre) && isExit(temp2, leftPre))
			find(leftPre, leftIn, temp1, temp2);
		else if (rightPre.length > 0 && isExit(temp1, rightPre) && isExit(temp2, rightPre))
			find(rightPre, rightIn, temp1, temp2);
		else if (preOrder[0] != temp1 && preOrder[0] != temp2)
			System.out.println("LCA of " + temp1 + " and " + temp2 + " is " + preOrder[0] + ".");
		else if (preOrder[0] == temp1)
			System.out.println(temp1 + " is an ancestor of " + temp2 + ".");
		else
			System.out.println(temp2 + " is an ancestor of " + temp1 + ".");
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		int nodeNum = scaner.nextInt();
		int[] inOrder = new int[nodeNum];int[] preOrder = new int[nodeNum];
		for (int i = 0; i < nodeNum; i++)	inOrder[i] = scaner.nextInt();
		for (int i = 0; i < nodeNum; i++)	preOrder[i] = scaner.nextInt();
		for (int i = 0; i < round; i++) {
			int temp1 = scaner.nextInt();
			int temp2 = scaner.nextInt();
			if(!isExit(temp1, preOrder) && !isExit(temp2, preOrder))
				System.out.println("ERROR: " + temp1 + " and " + temp2 + " are not found.");
			else if(!isExit(temp1, preOrder))
				System.out.println("ERROR: " + temp1 + " is not found.");
			else if(!isExit(temp2, preOrder))
				System.out.println("ERROR: " + temp2 + " is not found.");
			else
				find(preOrder, inOrder, temp1, temp2);
		}
		scaner.close();
	}

}
