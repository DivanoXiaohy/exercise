package ch01;

public class PrintNumberString {
	//P7	图1-4
	//将整型数字，一个一个打印出来
	public static void main(String[] args) {
		printOut(123);
	}
	
	public static void printOut(int num){
		if(num >= 10){
			printOut(num / 10);
		}
		printDigit(num % 10);
	}
	
	public static void printDigit(int str){
		String s = String.valueOf(str);
		if(s.length() != 1){
			System.out.println("error");
		}else{
			System.out.print(s);
		}
	}
	
}
