package Pac10;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
	
	
	public void matrixBuilder(){
		System.out.println("Please enter the n number:");
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
			
		ArrayList<Integer> a1 = new ArrayList();
		for (int i=1;i<=n;i++){
			a1.add(i);
			}
		ArrayList<Integer> a2 = new ArrayList();
		for (int i=n;i>=1;i--){
			a2.add(i);
			}
		for (int i=0;i<n/2;i++){
			System.out.println(a1);
			System.out.println(a2);
		}
	}
	
	public static void main(String[] args) {			
		Matrix m = new Matrix();
		m.matrixBuilder();
		
	}
}