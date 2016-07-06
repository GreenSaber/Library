package Pac6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		ArrayList a = new ArrayList<>();
		double x,max,min;
		
		for (int i=1;i<4;i++){
			System.out.println("Please enter the "+i+" number:");
			Scanner sc = new Scanner(System.in);
			a.add(sc.nextDouble());	
		}
			
		System.out.println("Maximum number is "+Collections.max(a));   		
		System.out.println("Minimum number is "+Collections.min(a)); 
		
	}
	

}
