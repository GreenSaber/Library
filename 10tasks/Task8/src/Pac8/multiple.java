package Pac8;

import java.util.ArrayList;
import java.util.Scanner;

public class multiple {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		int k,n,S = 0,x;
		System.out.println("Please enter the array size:");
		Scanner scn = new Scanner(System.in);
		n=scn.nextInt();
		System.out.println("Please enter the k:");
		Scanner sck = new Scanner(System.in);
		k=sck.nextInt();
		for (int i=1;i<=n;i++){
			System.out.println("Please enter the "+i+" value of array");
			Scanner sc = new Scanner(System.in);
			x=sc.nextInt();
			a.add(x);	
		}
		for (int i=0;i<a.size();i++){
			if ( (a.get(i)) % k==0){
				S=S+a.get(i);
			}		
		}
		if (S==0){
			System.out.println("There is NO elements which multiple "+k);
		}
		System.out.println("The sum of elements which multiple of "+k+" is "+S);
		

		
	}
}

