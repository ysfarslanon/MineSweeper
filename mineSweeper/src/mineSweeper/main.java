package mineSweeper;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input =new Scanner(System.in);
		
		System.out.print("Satýr sayýsýný giriniz: ");
		int row=input.nextInt();
		
		System.out.print("Sütun sayýsýný giriniz: ");
		int column=input.nextInt();
		
		
		mineSweeper mine = new mineSweeper(row,column);
		mine.run();
		
	}

}
