package mineSweeper;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input =new Scanner(System.in);
		
		System.out.print("Sat�r say�s�n� giriniz: ");
		int row=input.nextInt();
		
		System.out.print("S�tun say�s�n� giriniz: ");
		int column=input.nextInt();
		
		
		mineSweeper mine = new mineSweeper(row,column);
		mine.run();
		
	}

}
