//4. Для данных областей составить линейную программу,
//которая печатает true, если точка с координатами (х, у)
//принадлежит закрашенной области, и false — в противном случае: 

package Pac4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Area {
	
	private static boolean answ;
	public boolean isNumber(String s){  
//      Pattern p = Pattern.compile("-?[0-9][.]+");
//      Pattern p = Pattern.compile("^-?\\d+$");
		Pattern p = Pattern.compile("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");		
        Matcher m = p.matcher(s);
        answ=m.matches();
        return answ;  
	}

	private static String x,y;
	public void input(){
		System.out.println("Please enter the x coordinate:");
		Scanner sc = new Scanner(System.in);
		x=sc.nextLine();
		System.out.println("Please enter the y coordinate:");
		y=sc.nextLine();	
	}
	
	
	private static boolean res;
	private static Double x1,y1;
	public boolean isInMarkedArea(String x, String y){
		x1=Double.parseDouble(x);
		y1=Double.parseDouble(y);
		res=(((x1<=2)&(x1>=-2)&(y1>=0)&(y1<=3)) | ((x1<=4)&(x1>=-4)&(y1>=-3)&(y1<=0)));
		return res;	
	}
		
		
	public static void main(String[] args) {
		Area a = new Area();
		a.input();
		if ((a.isNumber(x)&a.isNumber(y)==true)){
			a.isInMarkedArea(x, y);
			System.out.println(res);
		}
		else 
		{
			System.out.println("Incorrect value(s) was entered");
		}
	}

}