//9. Заданы два одномерных массива с различным количеством элементов
//и натуральное число k. Объединить их в один массив,
//включив второй массив между k-м и (k+1) - м элементами первого.

package Pac9;

import java.util.ArrayList;
import java.util.Scanner;

public class Paste {

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList<>();
		ArrayList a2 = new ArrayList<>();
		ArrayList a3 = new ArrayList<>();
		ArrayList a4 = new ArrayList<>();
		int k,n1,n2;
		Object x1,x2;
		System.out.println("Please enter the 1st array size:");
		Scanner scn1 = new Scanner(System.in);
		n1=scn1.nextInt();
		
		for (int i=0;i<n1;i++){
			System.out.println("Please enter the "+i+" value of 1st array");
			Scanner sc1 = new Scanner(System.in);
			x1=sc1.nextLine();
			a1.add(x1);	
		}
			System.out.println("Please enter the 2nd array size:");
			Scanner scn2 = new Scanner(System.in);
			n2=scn2.nextInt();
			
		for (int j=0;j<n2;j++){
			System.out.println("Please enter the "+j+" value of 1st array");
			Scanner sc2 = new Scanner(System.in);
			x2=sc2.nextLine();
			a2.add(x2);
		}
		
		
		System.out.println("Please enter the k:");
		Scanner sck = new Scanner(System.in);
		k=sck.nextInt();
		if (k>a1.size()){
			System.out.println("K must be less than 1st array");
		}
		else{
		
		System.out.println("Your 1st array is "+a1);
		System.out.println("Your 2nd array is "+a2);
		
		for (int i=0; i<k;i++){
			a3.add(a1.get(i));
		}
		for (int i=0; i<a1.size()-k;i++){
			a4.add(a1.get(i+k));
		}

		a3.addAll(a2);
		a3.addAll(a4);
		System.out.println("The result is "+a3);
		}
	}
}

