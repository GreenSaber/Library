package Pac6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxMinValue {
	
	public boolean isNumber(String s){
		boolean answ;
		Pattern p = Pattern.compile("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");		
        Matcher m = p.matcher(s);
        answ=m.matches();
        return answ;
	}
	
	private static String a1,a2,a3;
	public void input(){
		System.out.println("Please enter the 1st real number:");
		Scanner sc = new Scanner(System.in);
		a1=sc.nextLine();
		System.out.println("Please enter the 2nd real number:");
		a2=sc.nextLine();
		System.out.println("Please enter the 3rd real number:");
		a3=sc.nextLine();	
	}
		
	public double maxValueCalc(String s1, String s2, String s3){
		double v1,v2,v3,max;
		max=0;
		v1 = Double.parseDouble(s1);
		v2 = Double.parseDouble(s2);
		v3 = Double.parseDouble(s3);
		if ((v1>v2)&(v1>v3))
		{
			max=v1;
		}
		if ((v2>v1)&(v2>v3))
		{
			max=v2;
		}
		if ((v3>v1)&(v3>v2))
		{
			max=v3;
		}
		return max;	
	}
	
	public double minValueCalc(String s1, String s2, String s3){
		double c1,c2,c3,min;
		min=0;
		c1 = Double.parseDouble(s1);
		c2 = Double.parseDouble(s2);
		c3 = Double.parseDouble(s3);
		if ((c1<c2)&(c1<c3))
		{
			min=c1;
		}
		if ((c2<c1)&(c2<c3))
		{
			min=c2;
		}
		if ((c3<c1)&(c3<c2))
		{
			min=c3;
		}
		return min;	
	}	

	public static void main(String[] args) {
		MaxMinValue mm =new MaxMinValue();
		mm.input();
		if (mm.isNumber(a1)&mm.isNumber(a2)&mm.isNumber(a3)==true){
			System.out.println("The maximum value is "+mm.maxValueCalc(a1, a2, a3));
			System.out.println("The minimum value is "+mm.minValueCalc(a1, a2, a3));
		}
		else 
		{
			System.out.println("Incorrect value(s) was entered");
		}
		
		
		
	}
	

}