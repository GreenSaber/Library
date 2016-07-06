package Pac5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealNumb {
			
	private static boolean answ;
	public boolean isNumber(String s){  
//      Pattern p = Pattern.compile("-?[0-9][.]+");
//      Pattern p = Pattern.compile("^-?\\d+$");
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
	
	private static double v,res;
	public double expCalc(String x){
		v = Double.parseDouble(x);
		if (v>=0) {
			res=Math.pow(v, 2);
		}
		else {
			res=Math.pow(v, 4);
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		RealNumb rn =new RealNumb();
		rn.input();
		if (rn.isNumber(a1)&rn.isNumber(a2)&rn.isNumber(a3)==true){
			System.out.println("The results are: "+rn.expCalc(a1)+", "+rn.expCalc(a2)+", "+rn.expCalc(a3));			
		}
		else 
		{
			System.out.println("Incorrect value(s) was entered");
		}

	}

}
