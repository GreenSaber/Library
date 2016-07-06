package Pac2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpCalc {
		
	 
	
	private static String a,b,c;
	public void input(){
		System.out.println("Please enter the a:");
		Scanner sc = new Scanner(System.in);
		a=sc.nextLine();
		System.out.println("Please enter the b:");
		b=sc.nextLine();
		System.out.println("Please enter the c:");
		c=sc.nextLine();	
	}

	private static boolean answ;
	public boolean isNumber(String s){  
		Pattern p = Pattern.compile("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");		
        Matcher m = p.matcher(s);
        answ=m.matches();
        return answ;
	}	
	
	static double x;
	private static Double a1,b1,c1;
	public double calc(String a,String b,String c){
		a1 = Double.parseDouble(a);
		b1 = Double.parseDouble(b);
		c1 = Double.parseDouble(c);	
		x=((b1+(Math.sqrt(b1*b1+4*a1*c1)))/(2*a1))-(a1*a1*a1*c1)+Math.pow(b1, -2);	
		return x;	
	}
	
	
	public static void main(String[] args) {
		
		ExpCalc ec = new ExpCalc();
		ec.input();
		if (ec.isNumber(a)&ec.isNumber(b)&ec.isNumber(c)==true){
			ec.calc(a,b,c);
			System.out.println("The answer is "+x);
		}
		else 
		{
			System.out.println("Incorrect value(s) was entered");
		}
	}

}
