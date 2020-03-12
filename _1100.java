package PATFoo;

import java.util.Scanner;

public class _1100 {
	
	static String convertEtoM(String ori) {
		String[] arr = Integer.toString(Integer.parseInt(ori), 13).split("");
		String result = "";
		if(arr.length == 1) {
			if(arr[0].equals("0"))
				result = "tret";
			else if(arr[0].equals("1"))
				result = "jan";
			else if(arr[0].equals("2"))
				result = "feb";
			else if(arr[0].equals("3"))
				result = "mar";
			else if(arr[0].equals("4"))
				result = "apr";
			else if(arr[0].equals("5"))
				result = "may";
			else if(arr[0].equals("6"))
				result = "jun";
			else if(arr[0].equals("7"))
				result = "jly";
			else if(arr[0].equals("8"))
				result = "aug";
			else if(arr[0].equals("9"))
				result = "sep";
			else if(arr[0].equals("10"))
				result = "oct";
			else if(arr[0].equals("11"))
				result = "nov";
			else
				result = "dec";
		}
		else {
			if(arr[0].equals("1"))
				result = "tam";
			else if(arr[0].equals("2"))
				result = "hel";
			else if(arr[0].equals("3"))
				result = "maa";
			else if(arr[0].equals("4"))
				result = "huh";
			else if(arr[0].equals("5"))
				result = "tou";
			else if(arr[0].equals("6"))
				result = "kes";
			else if(arr[0].equals("7"))
				result = "hei";
			else if(arr[0].equals("8"))
				result = "elo";
			else if(arr[0].equals("9"))
				result = "syy";
			else if(arr[0].equals("10"))
				result = "lok";
			else if(arr[0].equals("11"))
				result = "mer";
			else
				result = "jou";
			
			
			if(arr[1].equals("1"))
				result += " jan";
			else if(arr[1].equals("2"))
				result += " feb";
			else if(arr[1].equals("3"))
				result += " mar";
			else if(arr[1].equals("4"))
				result += " apr";
			else if(arr[1].equals("5"))
				result += " may";
			else if(arr[1].equals("6"))
				result += " jun";
			else if(arr[1].equals("7"))
				result += " jly";
			else if(arr[1].equals("8"))
				result += " aug";
			else if(arr[1].equals("9"))
				result += " sep";
			else if(arr[1].equals("10"))
				result += " oct";
			else if(arr[1].equals("11"))
				result += " nov";
			else
				result += " dec";
		}
		return result;
	}
	
	static String convertMtoE(String ori) {
		String[] arr = ori.split(" ");
		if(arr.length == 1) {
			String num = "";
			if(arr[0].equals("tret"))
				num = "0";
			else if(arr[0].equals("jan"))
				num = "1";
			else if(arr[0].equals("feb"))
				num = "2";
			else if(arr[0].equals("mar"))
				num = "3";
			else if(arr[0].equals("apr"))
				num = "4";
			else if(arr[0].equals("may"))
				num = "5";
			else if(arr[0].equals("jun"))
				num = "6";
			else if(arr[0].equals("jly"))
				num = "7";
			else if(arr[0].equals("aug"))
				num = "8";
			else if(arr[0].equals("sep"))
				num = "9";
			else if(arr[0].equals("oct"))
				num = "10";
			else if(arr[0].equals("nov"))
				num = "11";
			else
				num = "12";
			return num;
		}
		else {
			String num1 = "";
			String num2 = "";
			if(arr[0].equals("tam"))
				num1 = "1";
			else if(arr[0].equals("hel"))
				num1 = "2";
			else if(arr[0].equals("maa"))
				num1 = "3";
			else if(arr[0].equals("huh"))
				num1 = "4";
			else if(arr[0].equals("tou"))
				num1 = "5";
			else if(arr[0].equals("kes"))
				num1 = "6";
			else if(arr[0].equals("hei"))
				num1 = "7";
			else if(arr[0].equals("elo"))
				num1 = "8";
			else if(arr[0].equals("syy"))
				num1 = "9";
			else if(arr[0].equals("lok"))
				num1 = "10";
			else if(arr[0].equals("mer"))
				num1 = "11";
			else
				num1 = "12";
			
			if(arr[1].equals("tret"))
				num2 = "0";
			else if(arr[1].equals("jan"))
				num2 = "1";
			else if(arr[1].equals("feb"))
				num2 = "2";
			else if(arr[1].equals("mar"))
				num2 = "3";
			else if(arr[1].equals("apr"))
				num2 = "4";
			else if(arr[1].equals("may"))
				num2 = "5";
			else if(arr[1].equals("jun"))
				num2 = "6";
			else if(arr[1].equals("jly"))
				num2 = "7";
			else if(arr[1].equals("aug"))
				num2 = "8";
			else if(arr[1].equals("sep"))
				num2 = "9";
			else if(arr[1].equals("oct"))
				num2 = "10";
			else if(arr[1].equals("nov"))
				num2 = "11";
			else
				num2 = "12";
			int i = Integer.parseInt(num1) * 13 + Integer.parseInt(num2);
			return String.valueOf(i);
		}
	}

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		int round = scaner.nextInt();
		scaner.nextLine();
		for(int i = 0 ; i < round ; i++) {
			String temp = scaner.nextLine();
			boolean flag = true;
			if(!Character.isDigit(temp.charAt(0)))
				flag = false;
			if(flag)
				System.out.println(convertEtoM(temp));
			else
				System.out.println(convertMtoE(temp));
		}
		scaner.close();
	}

}
