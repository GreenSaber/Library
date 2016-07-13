package Pac1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FourDigit {
	
	private static boolean answ;
	public boolean isNumber(String s){  
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s);
        answ=m.matches();
        return answ;
	}
	
	private static String a;;
	
	public void input(){
		System.out.println("Please enter the 4-digit number:");
		Scanner sc = new Scanner(System.in);
		a=sc.nextLine();
	}	
		
	private static boolean res;
	private int first, second, third, fourth,v;

	public boolean isEqual(String numb){
		v = Integer.parseInt(numb);
		first=v/1000;
		second=(v-(first*1000))/100;
		third=(v-(first*1000)-(second*100))/10;
		fourth=(v-(first*1000)-(second*100)-(third*10));
		res=((first+second)==(third+fourth));
		return res;		
	}

	public static void main(String[] args) {		
		FourDigit fd=new FourDigit();
		fd.input();
		if (fd.isNumber(a)==true){
			int ai = Integer.parseInt(a);
			if ((ai>10000)|(ai<1000))
			{
				System.out.println("It is not a 4-digit number."
						+ "Please restart the program and enter the correct value.");	
			}
			else {
				fd.isEqual(a);
				System.out.println(res);
			}
		}
		else {
			System.out.println("Incorrect value(s) was entered.");
		}
	}
	
}
