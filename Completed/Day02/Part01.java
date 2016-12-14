import java.io.BufferedReader;
import java.io.FileReader;

public class Part01 {

	private final int[][] KEYPAD = new int[][]{{1,4,7},{2,5,8},{3,6,9}};
	private int[] code = new int[5];
	private int posY = 1;
	private int posX = 1;

	public Part01() {}

	public String run() throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		int i = 0;
		int j = 0;
		while ((j = buf.read()) != -1) {
			switch (j) {
				case 'U':	if (posY == 0) {
								break;					
							}
							posY--;
							break;

				case 'D':	if (posY == 2) {
								break;
							}
							posY++;
							break;

				case 'L':	if (posX == 0) {
								break;
							}
							posX--;
							break;

				case 'R':	if (posX == 2) {
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
			numbers = numbers + j;
		}
		return numbers;
	}
}