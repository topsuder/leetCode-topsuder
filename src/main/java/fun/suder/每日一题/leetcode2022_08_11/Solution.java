package fun.suder.每日一题.leetcode2022_08_11;

import java.util.Arrays;

class Solution {
	private  String s="";
    public String reformat(String s) {
		this.s=s;
		final int[] num = getNum();
		final String[] str = getStr();
		if(num.length==0||str.length==0) return "";
		String returnStr = "";
		Arrays.sort(num);
		Arrays.sort(str);
		for (int i = 0; i < num.length; i++) {
			returnStr+=num[i];
			returnStr+=str[i];
		}
		return returnStr;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reformat("leetcode"));
	}
 
	public String[] getStr(){
		String[] str_string = s.split("\\d");//  \d 为正则表达式表示[0-9]数字
		return str_string;
	}
	
	public int[] getNum(){
		String[] num_string = s.split("\\D");  // \D 为正则表达式表示非数字
		String a = "";
		
		for(String m : num_string){
			a += m;
		}
		
		String[] num = a.split("");  //将分离出的重新保存在新数组num中不要直接用num_string，  因为在正则表达式对字符串进行选择时若前面的几个字符不符合要求但num_string数组中仍会存有其位置 是空格

		int[] inte = new int[num.length];
		if (num_string.length==0) return new int[]{};
		for(int i =0; i < num.length; i++){
			inte[i] = Integer.parseInt(num[i]); //将该数组中的数字存入int数组
		}
		
		return inte;
	}
	//打印字符串中的字母
	public void printStr(){
		String a = "";
		for(String n : getStr()){
			a += n;
		}
		System.out.println(a);
	}
	//打印字符串中的数字
	public void printNum(){
		String a = "";
		for(int n : getNum()){
			a += n;
		}
		System.out.println(a);
	}
}