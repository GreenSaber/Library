package Pac8;

import java.util.ArrayList;
import java.util.Scanner;

public class multiple {
	
private static int n,x,k;
	
	public int[] input(){
		System.out.println("Please enter the array size :");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		int[] a=new int[n];
		System.out.println("Please enter the k:");
		Scanner sck = new Scanner(System.in);
		k=sck.nextInt();
		Scanner sc1 = new Scanner(System.in);
		for (int i = 0; i<n; i++){
			System.out.println("Please enter the "+i+" element of array :");
			a[i]=sc1.nextInt();
			}
		return a; 		
	}
	
	static int S;
	public int div(int array[]){
		for (int i=0;i<array.length;i++){
			if ( (array[i]) % k==0){
				S=S+array[i];
			}		
		}
		return S;		
	}
	
	public static void main(String[] args) {
		
		multiple m = new multiple();
		m.div(m.input());
		System.out.println("S = "+S);	
	}
}
