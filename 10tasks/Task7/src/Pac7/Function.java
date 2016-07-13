package Pac7;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Pac7.Function1;

public class Function {
	
	private static boolean answ;
	public boolean isNumber(String s){  
		Pattern p = Pattern.compile("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");		
        Matcher m = p.matcher(s);
        answ=m.matches();
        return answ;
	}
	
private static String a,b,h;;
	
	public void input(){
		System.out.println("Please enter the a :");
		Scanner sc = new Scanner(System.in);
		a=sc.nextLine();
		System.out.println("Please enter the b :");
		b=sc.nextLine();
		System.out.println("Please enter the h :");
		h=sc.nextLine();
	}
			
	int n;
	double x;
	private static double a1,b1,h1;
	static ArrayList<Double> arx = new ArrayList<>();
	public ArrayList<Double> xCalc(String a_str, String b_str, String h_str){
		a1 = Double.parseDouble(a_str);
		b1 = Double.parseDouble(b_str);
		h1 = Double.parseDouble(h_str);
		n=(int) (((b1-a1)/h1)+1); /*n - number of x values*/
		for (int i=0; i<n;i++){
			double x=a1+h1*(i-1);
			arx.add(x);
		}
		return arx;	
	}
	
	private static double fx;
	static ArrayList<Double> arfx = new ArrayList<>();
	public ArrayList<Double> fxCalc(ArrayList<Double> array){
		for (int i=0; i<array.size();i++){
			fx=Math.pow ((Math.sin((array.get(i)))),2)-(Math.cos((array.get(i))*2));
			arfx.add(fx);
		}
		return arfx;
		
	}
	
	public void print(){
		for (int i=0;i<arx.size();i++){
			System.out.println("|  "+arx.get(i)+" | "+arfx.get(i));
		}
	}
	

	public static void main(String[] args) {	
		Function f =new Function();
		f.input();
		if (f.isNumber(a)&f.isNumber(b)&f.isNumber(h)==true){
			f.xCalc(a,b,h);
			f.fxCalc(arx);
			f.print();	
		}
		else {
			System.out.println("Incorrect values");
		}
		
		
	}
}
