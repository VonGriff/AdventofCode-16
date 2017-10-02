import java.util.LinkedList;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;

public class Part01 {
	
	private Scanner input = new Scanner(new File("input.txt"));
	private boolean[][] screen = new boolean[6][50];
	private final int MAXROW = 6;
	private final int MAXCOL = 50;

	public Part01() throws IOException {

	}

	public int run() {
		String cmd;
		String rotate;

		while (input.hasNextLine()) {
			cmd = input.findInLine("rect|rotate");
			rotate = input.findInLine("row|column");
			int value1 = Integer.parseInt(input.findInLine("\\d+"));
			int value2 = Integer.parseInt(input.findInLine("\\d+"));
			
			if (cmd.matches("rect")){
				createRect(value1, value2);
			}
			else if (cmd.matches("rotate")) {
				
				if (rotate.matches("row")) {
					rotateRow(value1, value2);
				}
				else if (rotate.matches("column")) {
					rotateCol(value1, value2);
				}
			}
			else {
				System.out.println("error");
			}
			if (input.hasNextLine())
				input.nextLine();
		}

		int count = 0;
		for (int i=0; i<MAXROW; i++) {
			for (int j=0; j<MAXCOL; j++) {
				if (screen[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	// Creates a rectangle in the top left corner with row height and col length
	private void createRect(int row, int col) {

		for (int i=0; i<col; i++) {
			for (int j=0; j<row; j++) {
				screen[i][j] = true;
			}
		}
	}

	// rotates a row right, overflowing ends up on left end
	private void rotateRow(int row, int shift) {
		LinkedList<Integer> rotation = new LinkedList<Integer>();

		for (int i=0; i<MAXCOL; i++) {
			if(screen[row][i]) {
				rotation.add((i+shift)%MAXCOL);
				screen[row][i] = false;
			}
		}
		for (int i: rotation) {
			screen[row][i] = true;
		}
		return;
	}
	// rotates a column down, overflowing ends up on top
	private void rotateCol(int col, int shift) {
		LinkedList<Integer> rotation = new LinkedList<Integer>();

		for (int i=0; i<MAXROW; i++) {
			if(screen[i][col]) {
				rotation.add((i+shift)%MAXROW);
				screen[i][col] = false;
			}
		}
		for (int i: rotation) {
			screen[i][col] = true;
		}
		return;
	}

	public boolean[][] getScreen() {
		return screen;
	}
 }