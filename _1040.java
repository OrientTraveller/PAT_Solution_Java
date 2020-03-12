package PATFoo;

import java.util.Scanner;
/**
 * Manacher算法
 * 马拉车算法的核心思想就是：关于回文中心对称（且两者都在最右回文边界内时）的字符的回文半径等于Math.min(radius[2*c-i],R-i+1)
 * 再通俗一点，利用回文对称的性质，使用以前计算的每个字符的回文半径作为关于回文中心对称的字符的回文半径基础值，以便减少时间复杂度
 * 以上条件不满足时，计算回文半径的方法同一般方法
 * @author SunFeiran
 * https://www.jianshu.com/p/116aa58b7d81
 * https://www.jianshu.com/p/392172762e55
 *
 */

public class _1040 {
	
	public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
		String str = scaner.nextLine();
		scaner.close();
        System.out.println(manacher(str));
    }

    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static int manacher(String str){
        if(str == null || str.length() < 1)
            return 0;
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        //最右回文边界
        int R = -1;
        //最右回文中心
        int c = -1;
        //最大回文长度
        int max = Integer.MIN_VALUE;
        //遍历新回文数组
        for (int i = 0; i < radius.length; i++) {
        	/*
        	 * 若i小于最右回文边界，radius[i]初始化为Math.min(radius[2*c-i],R-i+1)；在该情况下又有两种情况
        	 * 第一种情况radius[2*c-i]代表i的回文右边界小于等于最右回文边界
        	 * 第二种情况R-i+1代表i的回文右边界大于最右回文边界
        	 */
        	/*
        	 * 若i大于等于最右回文边界，radius[i]初始化为1，因为当R==i时，下一轮循环进行时，下一个字符已经跳出回文序列了所以要初始化为1
        	 */
        	//存在radius[2*c-i]大于R-i+1的情况，比如i距离字符串结尾很近时，可能会出现这种情况
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            if(R > i) {
            	System.out.println("第" + i + "次的radius[2*c-i]值： " + radius[2*c-i]);
                System.out.println("第" + i + "次的R-i+1值： " + (R-i+1));
            }
            System.out.println("第" + i + "次的radius[" + i + "]初始值： " + radius[i]);
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]])
                    radius[i]++;
                else
                    break;
            }
            System.out.println("第" + i + "次的radius[" + i + "]修改后值： " + radius[i]);
            if(i + radius[i] > R){
                R = i + radius[i]-1;//R代表最右回文边界的索引值，该边界包含在回文中，而不是回文的边界+1与其他的程序有区别
                c = i;
            }
            System.out.println("第" + i + "次的R值： " + R);
            System.out.println("第" + i + "次的c值： " + c);
            max = Math.max(max,radius[i]);
        }
        return max-1;
    }
}
