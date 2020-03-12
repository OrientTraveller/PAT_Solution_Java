package PATFoo;

import java.util.Scanner;

public class _1082 {
	
	static String result = "";
	static String oriNum;

	static void run(char c , int index , int len , char pre) {
		if(c == '0') {
			if(len - index == 5)
				result += "Wan ";
			else if(len - index > 5) {
				if(pre != '0' && index < len - 1 && oriNum.substring(index+1,len-4).replace("0", "").length() != 0)
					result += "ling ";
			}
			else {
				if((pre != '0'||index == len - 4) && index < len - 1 && oriNum.substring(index+1).replace("0", "").length() != 0)
					result += "ling ";
			}
		}			
		else if(c == '1') {
			if(len - index == 9)
				result += "yi Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "yi Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "yi Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "yi Shi ";
			else if(len - index == 5)
				result += "yi Wan ";
			else
				result += "yi";
		}
		else if(c == '2') {
			if(len - index == 9)
				result += "er Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "er Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "er Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "er Shi ";
			else if(len - index == 5)
				result += "er Wan ";
			else
				result += "er";
		}
		else if(c == '3') {
			if(len - index == 9)
				result += "san Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "san Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "san Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "san Shi ";
			else if(len - index == 5)
				result += "san Wan ";
			else
				result += "san";
		}
		else if(c == '4') {
			if(len - index == 9)
				result += "si Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "si Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "si Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "si Shi ";
			else if(len - index == 5)
				result += "si Wan ";
			else
				result += "si";
		}
		else if(c == '5') {
			if(len - index == 9)
				result += "wu Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "wu Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "wu Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "wu Shi ";
			else if(len - index == 5)
				result += "wu Wan ";
			else
				result += "wu";
		}
		else if(c == '6') {
			if(len - index == 9)
				result += "liu Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "liu Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "liu Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "liu Shi ";
			else if(len - index == 5)
				result += "liu Wan ";
			else
				result += "liu";
		}
		else if(c == '7') {
			if(len - index == 9)
				result += "qi Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "qi Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "qi Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "qi Shi ";
			else if(len - index == 5)
				result += "qi Wan ";
			else
				result += "qi";
		}
		else if(c == '8') {
			if(len - index == 9)
				result += "ba Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "ba Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "ba Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "ba Shi ";
			else if(len - index == 5)
				result += "ba Wan ";
			else
				result += "ba";
		}
		else {
			if(len - index == 9)
				result += "jiu Yi ";
			else if(len - index == 8 || len - index == 4)
				result += "jiu Qian ";
			else if(len - index == 7 || len - index == 3)
				result += "jiu Bai ";
			else if(len - index == 6 || len - index == 2)
				result += "jiu Shi ";
			else if(len - index == 5)
				result += "jiu Wan ";
			else
				result += "jiu";
		}
	}
	
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		oriNum = scaner.nextLine();
		if(oriNum.equals("0"))
			System.out.println("ling");
		else {
			scaner.close();
			char[] num = oriNum.toCharArray();
			if(num[0] == '-') {
				result += "Fu ";
				for(int i = 1 ; i < num.length ; i++)
					run(num[i],i,num.length,num[i-1]);
			}
			else {
				for(int i = 0 ; i < num.length ; i++) {
					if(i == 0)
						run(num[i],i,num.length,'-');
					else
						run(num[i],i,num.length,num[i-1]);
				}
			}
			System.out.println(result.trim());
		}	

	}

}
