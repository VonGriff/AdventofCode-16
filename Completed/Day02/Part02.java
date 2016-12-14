import java.io.BufferedReader;
import java.io.FileReader;

public class Part02 {

	private final int[][] KEYPAD = new int[][]{{-1,-1,5,-1,-1},{-1,2,6,'A',-1},{1,3,7,'B','D'},
											   {-1,4,8,'C',-1},{-1,-1,9,-1,-1}};
	private int[] code = new int[5];
	private int posY = 2;
	private int posX = 0;

	public Part02() {}

	public String run() throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		int i = 0;
		int j = 0;
		while ((j = buf.read()) != -1) {
			switch (j) {
				case 'U':	if (posY == 0 || KEYPAD[posX][posY-1] == -1) {
								break;					
							}
							posY--;
							break;

				case 'D':	if (posY == 4 || KEYPAD[posX][posY+1] == -1) {
								break;
							}
							posY++;
							break;

				case 'L':	if (posX == 0 || KEYPAD[posX-1][posY] == -1) {
								break;
							}
							posX--;
							break;

				case 'R':	if (posX == 4 || KEYPAD[posX+1][posY] == -1) {
								break;
							}
							posX++;
							break;

				default:	//System.out.println("Number: " + KEYPAD[posX][posY]);
							code[i] = KEYPAD[posX][posY];
							i++;
			}
			// System.out.println("Number: " + KEYPAD[posX][posY]);
			code[i] = KEYPAD[posX][posY];
		}
		return interpret(code);
	}

	private String interpret(int[] i) {
		String numbers = "";
		for (int j: i) {
			if (j > 9) {
				numbers = numbers + (char) j;
			}
			else {
				numbers = numbers + j;
			}
		}
		return numbers;
	}
}