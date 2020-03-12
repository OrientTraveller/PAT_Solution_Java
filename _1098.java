package PATFoo;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 在判断插入排序当前排序的右边界时，不能用边界右端数组元素相同，左端呈顺序的方法；
 * 要使用左端呈顺序，然后右端元素相等
 * 因为这种特例：
 * 原顺序		645123798
 * 现在的顺序	123456798
 * 你说现在当前排序的右边界的下标是5还是6，按照题意应该取最大的6
 */

public class _1098 {
	
	static int[] adjust(int[] heap, int start, int end) {
		while(true) {
			int left = (start + 1) * 2 - 1;
			int right = (start + 1) * 2;
			int temp = heap[start];
			if(left <= end && right <= end) {
				if(heap[left] > heap[right]) {
					heap[start] = heap[left];
					heap[left] = temp;
					start = left;
				}
				else {
					heap[start] = heap[right];
					heap[right] = temp;
					start = right;
				}
			}
			else if(left <= end && right > end) {
				heap[start] = heap[left];
				heap[left] = temp;
				start = left;
			}
			else
				break;
		}
		return heap;
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int num = scaner.nextInt();
		int[] ori = new int[num];
		int[] oriCopy = new int[num];
		int[] current = new int[num];
		for(int i = 0 ; i < num ; i++) {
			ori[i] = scaner.nextInt();
			oriCopy[i] = ori[i];
		}
		for(int i = 0 ; i < num ; i++)
			current[i] = scaner.nextInt();
		scaner.close();
		int insertIndex = 0;
		int p = 0;
		for(int i = 0 ; i < num - 1; i++)
			if(current[i] < current[i + 1])
				p++;
			else
				break;
		insertIndex = p;
		for(int i = insertIndex + 1 ; i < num ; i++)
			if(ori[i] == current[i])
				p++;
			else
				break;
		if(p + 1 == num) {
			System.out.println("Insertion Sort");
			Arrays.sort(current, 0, insertIndex + 2);
			for(int i = 0 ; i < num ; i++) {
				if(i < num - 1)
					System.out.print(current[i] + " ");
				else
					System.out.print(current[i]);
			}
		}
		else {
			Arrays.sort(ori);
			int heapIndex = 0;
			for(int i = num - 1 ; i >= 0 ; i--)
				if(ori[i] != current[i]) {
					heapIndex = i;
					break;
				}
			int temp = current[heapIndex];
			current[heapIndex] =  current[0];
			current[0] = temp;
			adjust(current, 0, heapIndex - 1);
			System.out.println("Heap Sort");
			for(int i = 0 ; i < current.length ; i++) {
				if(i < current.length - 1)
					System.out.print(current[i] + " ");
				else
					System.out.print(current[i]);
			}
		}

	}

}
