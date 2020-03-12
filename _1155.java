package PATFoo;

import java.util.Scanner;

public class _1155 {

	static int[] heap;
	static int isMaxOrMin = 0;
	static boolean isHeap = true;
	
	static void run(int index, String result, int pre) {
		result += heap[index]+" ";
		if(isHeap) {
			if(pre == -2) pre = heap[index];
			else if(heap[index] <= pre && (isMaxOrMin == 0 || isMaxOrMin == 1))
				isMaxOrMin = 1;
			else if(heap[index] >= pre && (isMaxOrMin == 0 || isMaxOrMin == -1))
				isMaxOrMin = -1;
			else isHeap = false;
		}
		if(2*index+1 >= heap.length)
			System.out.println(result.trim());
		else if(2*index+2 >= heap.length)
			run(2*index+1, result, heap[index]);
		else {
			run(2*index+2, result, heap[index]);
			run(2*index+1, result, heap[index]);
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		heap = new int[scaner.nextInt()];
		for (int i = 0; i < heap.length; i++) heap[i] = scaner.nextInt();
		scaner.close();
		run(0, "", -2);
		if(!isHeap) System.out.println("Not Heap");
		else if(isMaxOrMin == 1) System.out.println("Max Heap");
		else System.out.println("Min Heap");
	}

}
