package mineSweeper;

import java.util.Random;
import java.util.Scanner;

public class mineSweeper {

	private int row;
	private int column;
	private int mineCount;
	private String[][] gameField;
	private String[][] minePosition;

	public mineSweeper(int row, int column) {
		this.row = row;
		this.column = column;
		this.mineCount = (row * column) / 4;
		this.gameField = fillGameField();
		this.minePosition = fillMinePositions();
		// printGameField();
		printMine();
	}

	public void run() {
		boolean isOver = false;
		
		Scanner input = new Scanner(System.in);
		int selectedRow, selectedColumn;
		while (!isOver && !isWin()) {

			System.out.print("\nSatýr seçiniz: ");
			selectedRow = input.nextInt() - 1;
			System.out.print("Sütun seçiniz: ");
			selectedColumn = input.nextInt() - 1;
			System.out.println();
			
			if(selectedRow>this.row-1||selectedColumn>this.column-1) {
				System.out.print("Oyun sýnýrýný aþtýnýz lütfen yeni seçim yapýnýz.");
			}else {
				if (this.minePosition[selectedRow][selectedColumn].equals("*")) {
					isOver = true;
					printMine();
					System.out.println("KAYBETTÝNÝZ !!");
				} else {
					this.gameField[selectedRow][selectedColumn] = String.valueOf(checkCells(selectedRow, selectedColumn));
					printGameField();
					if (isWin()) {
						System.out.println("KAZANDINIZ !!");
						printMine();
					}
						

				}
			}
				
			

		}

	}

	

	private boolean isWin() {
		boolean isWin = false;
		int countCell = this.column * this.row;
		for (int row = 0; row < this.gameField.length; row++) {
			for (int column = 0; column < this.gameField[0].length; column++) {
				if (!this.gameField[row][column].equals("-") && !this.gameField[row][column].equals("*"))
					countCell--;
			}

			if (countCell == this.mineCount)
				isWin = true;

		}
		return isWin;
	}

	private int checkCells(int checkRow, int checkColumn) {
		int numberOfMineOnAround = 0;
		if (checkRow == 0) {
			if (checkColumn == 0) {
				if (minePosition[checkRow][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
			} else if (checkColumn == this.column - 1) {
				if (minePosition[checkRow][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
			} else {
				if (minePosition[checkRow][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
			}
		} else if (checkRow == this.row - 1) {
			if (checkColumn == 0) {
				if (minePosition[checkRow][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
			} else if (checkColumn == this.column - 1) {
				if (minePosition[checkRow][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
			} else {
				if (minePosition[checkRow][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
			}
		} else {
			if (checkColumn == 0) {
				if (minePosition[checkRow][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
			} else if (checkColumn == this.column - 1) {
				if (minePosition[checkRow][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
			} else {
				if (minePosition[checkRow][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow - 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn + 1].equals("*"))
					numberOfMineOnAround++;
				if (minePosition[checkRow + 1][checkColumn - 1].equals("*"))
					numberOfMineOnAround++;
			}
		}
		return numberOfMineOnAround;
	}

	private String[][] fillMinePositions() {
		String[][] positionMine = fillGameField();
		Random random = new Random();
		boolean isDone = false;
		int mine = 0;

		while (!isDone) {
			int row = random.nextInt(this.row);
			int column = random.nextInt(this.column);
			if (positionMine[row][column].equals("*"))
				continue;
			positionMine[row][column] = "*";
			mine++;
			if (mine == this.mineCount)
				isDone = true;
		}

		return positionMine;
	}

	private String[][] fillGameField() {
		String[][] pos = new String[this.row][this.column];
		for (int row = 0; row < this.row; row++) {
			for (int column = 0; column < this.column; column++) {
				pos[row][column] = "-";
			}
		}
		return pos;
	}

	private void printGameField() {
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				System.out.print(this.gameField[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void printMine() {
		// System.out.println("-----------------------" + this.mineCount + " ");
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				System.out.print(this.minePosition[i][j] + " ");
			}
			System.out.println();
		}
	}

}
