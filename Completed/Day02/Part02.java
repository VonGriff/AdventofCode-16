import java.io.BufferedReader;
import java.io.FileReader;

// Part02 goal: Same as part01 but with a different kind of keypad where "-1" indicates 
// indeces you can't travel to.
public class Part02 {

	private final int[][] KEYPAD = new int[][]{{-1,-1,5,-1,-1},{-1,2,6,'A',-1},{1,3,7,'B','D'},
											   {-1,4,8,'C',-1},{-1,-1,9,-1,-1}};
	private int[] code = new int[5];
	private int posY = 2;
	private int posX = 0;

	public Part02() {}

	// Does the same as Part01.run() except with more requirements
	public String run() throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		int i = 0;
		int j = 0;
		while ((j = buf.read()) != -1) {
			switch (j) {
				case 'U':	if (!(posY == 0 || KEYPAD[posX][posY-1] == -1)) {
								posY--;
							}
							break;

				case 'D':	if (!(posY == 4 || KEYPAD[posX][posY+1] == -1)) {
								posY++;
							}
							break;

				case 'L':	if (!(posX == 0 || KEYPAD[posX-1][posY] == -1)) {
								posX--;
							}
							break;

				case 'R':	if (!(posX == 4 || KEYPAD[posX+1][posY] == -1)) {
								posX++;
							}
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

	// Adds the code inputs to a String to return, casts "char" to an "int" to
	// interpret it as a char to get "A" instead of "65".
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