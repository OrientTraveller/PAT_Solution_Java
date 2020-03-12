package PATFoo;

import java.util.HashMap;
import java.util.Scanner;

public class _1151 {
	
	static int[] in, pre;
	static HashMap<Integer, Integer> pos;
	
	static void lca(int inl, int inr, int preRoot, int a, int b) {
	    if (inl > inr) return;
	    int inRoot = pos.get(pre[preRoot]), aIn = pos.get(a), bIn = pos.get(b);
	    if (aIn < inRoot && bIn < inRoot)		lca(inl, inRoot-1, preRoot+1, a, b);
	    else if (aIn > inRoot && bIn > inRoot)	lca(inRoot+1, inr, preRoot+1+(inRoot-inl), a, b);
	    else if (aIn == inRoot)					System.out.println(a+" is an ancestor of "+b+".");
	    else if (bIn == inRoot)					System.out.println(b+" is an ancestor of "+a+".");
	    else									System.out.println("LCA of "+a+" and "+b+" is "+in[inRoot]+".");
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		pos = new HashMap<Integer, Integer>();
		int m, n, a, b;
		m = scaner.nextInt();
		n = scaner.nextInt();
		in = new int[n+1];
		pre = new int[n+1];
	    for (int i = 1; i <= n; i++) {
	        in[i] = scaner.nextInt();
	        pos.put(in[i], i);
	    }
	    for (int i = 1; i <= n; i++) pre[i] = scaner.nextInt();
	    for (int i = 0; i < m; i++) {
	        a = scaner.nextInt();
	        b = scaner.nextInt();
	        if (pos.get(a) == null && pos.get(b) == null)	System.out.println("ERROR: "+a+" and "+b+" are not found.");
	        else if (pos.get(a) == null)					System.out.println("ERROR: "+a+" is not found.");
	        else if (pos.get(b) == null)					System.out.println("ERROR: "+b+" is not found.");
	        else											lca(1, n, 1, a, b);
	    }
		scaner.close();
	}
}
