//7. —оставить программу дл€ вычислени€
//значений функции  F(x) на отрезке [а, b] с шагом h.
//–езультат представить в виде таблицы, первый столбец
//которой Ц значени€  аргумента, второй - соотђветствующие значени€ функции:
//F(x)=(sin(x))^2-cos(2*x)

package Pac7;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Function1 {

	public static void main(String[] args) {
		System.out.println("[a,b], h");
		System.out.println("Please enter the a:");
		Scanner sca = new Scanner(System.in);
		double a=sca.nextDouble();
		System.out.println("Please enter the b");
		Scanner scb = new Scanner(System.in);
		double b=scb.nextDouble();
		
		System.out.println("Please enter the h");
		Scanner sch = new Scanner(System.in);
		double h=sca.nextDouble();
		
		System.out.println("["+a+", "+b+"], "+h);
		
		int n;
		double fx,x;
		ArrayList<Double> arx = new ArrayList<>();
		ArrayList<Double> arfx = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.###");
		n=(int) (((b-a)/h)+1); /*n - number of x values*/
		for (int i=1; i<=n;i++){
			x=a+h*(i-1);
			fx=Math.pow ((Math.sin((Math.toDegrees(x)))),2)-(Math.cos((Math.toDegrees(x))*2));
			arx.add(x);
			arfx.add(fx);
		}
		System.out.println("   x     f(x)");
		for (int i=0;i<arx.size();i++){
			System.out.println("|  "+df.format(arx.get(i))+" | "+df.format(arfx.get(i)));
		}
	}
}