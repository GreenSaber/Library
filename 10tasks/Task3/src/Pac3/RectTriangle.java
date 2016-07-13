package Pac3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RectTriangle {
		
	private static String a,b;
	public void input(){
		System.out.println("Please enter the a :");
		Scanner sc = new Scanner(System.in);
		a=sc.nextLine();
		System.out.println("Please enter the b :");
		b=sc.nextLine();	
	}
	
	private static boolean answ;
	public boolean isNumber(String s){  
//      Pattern p = Pattern.compile("-?[0-9][.]+");
//      Pattern p = Pattern.compile("^-?\\d+$");
		Pattern p = Pattern.compile("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");		
        Matcher m = p.matcher(s);
        answ=m.matches();
        return answ;  
	}
	
	double c;
	static double P;
	double a1,b1;
	public double perimCalc(String a,String b){
		a1=Double.parseDouble(a);
		b1=Double.parseDouble(b);
		c=Math.sqrt(a1*a1+b1*b1);
		P=a1+b1+c;
		return P;	
	}
		
	static double S;
	double a2,b2;
	public double squareCalc(String a,String b){
		a2=Double.parseDouble(a);
		b2=Double.parseDouble(b);
		S=0.5*a2*b2;
		return S;	
	}
	
	public static void main(String[] args) {
		RectTriangle rt = new RectTriangle();
		rt.input();
		if (rt.isNumber(a)&rt.isNumber(b)==true){
			rt.perimCalc(a,b);
			System.out.println("Perimetr equals "+P);
			rt.squareCalc(a,b);
			System.out.println("Square equals "+S);		
		}
		else 
		{
			System.out.println("Incorrect value(s) was entered");
		}	
	}

}
