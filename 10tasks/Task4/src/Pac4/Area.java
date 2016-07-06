//4. Для данных областей составить линейную программу,
//которая печатает true, если точка с координатами (х, у)
//принадлежит закрашенной области, и false — в противном случае: 

package Pac4;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		 int x,y;
		 boolean b;
		 System.out.println("Please enter the x coordinate:");
		 Scanner sc = new Scanner(System.in);
			x=sc.nextInt();
		 System.out.println("Please enter the y coordinate:");
			y=sc.nextInt();
			b=(((x<=2)&(x>=-2)&(y>=0)&(y<=3)) | ((x<=4)&(x>=-4)&(y>=-3)&(y<=0)));
		 System.out.println(b);
	}

}
