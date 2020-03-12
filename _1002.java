package PATFoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1002 {

	public static void cal() throws IOException {
		int length = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr1 = br1.readLine().split(" ");
		for (int i = 0; i < strArr.length; i++) {
			if (i % 2 == 1 && Integer.parseInt(strArr[i]) > length) {
				length = Integer.parseInt(strArr[i]);
			}
		}
		for (int i = 0; i < strArr1.length; i++) {
			if (i % 2 == 1 && Integer.parseInt(strArr1[i]) > length) {
				length = Integer.parseInt(strArr1[i]);
			}
		}

		double[] a = new double[length + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = 0;
		}
		for (int i = 0; i < strArr.length; i++) {
			if (i % 2 == 1) {
				a[Integer.parseInt(strArr[i])] = a[Integer.parseInt(strArr[i])] + Double.parseDouble(strArr[i + 1]);
			}
		}
		for (int i = 0; i < strArr1.length; i++) {
			if (i % 2 == 1) {
				a[Integer.parseInt(strArr1[i])] = a[Integer.parseInt(strArr1[i])] + Double.parseDouble(strArr1[i + 1]);
			}
		}
		int num =0;
		for(int i=0 ;i<a.length;i++) {
			if(a[i]!=0)
				num++;
		}
		System.out.print(num);
		for (int i = a.length - 1; i >= 0; i--) {
			if(a[i] != 0) {
//				System.out.print(" " + i + " " + Double.parseDouble(String.format("%.1f",a[i])));
				System.out.print(" " + i + " " + a[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		cal();
	}

}
