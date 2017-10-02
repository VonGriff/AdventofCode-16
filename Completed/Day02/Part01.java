import java.io.BufferedReader;
import java.io.FileReader;

// Part01 goal: With given instructions from input, travel around a keypad and enter the last
// number of a line as a code entry.
public class Part01 {

	private final int[][] KEYPAD = new int[][]{{1,4,7},{2,5,8},{3,6,9}};
	private int[] code = new int[5];
	private int posY = 1;
	private int posX = 1;

	public Part01() {}

	// Initiates to read from input and then reads instructions to travel around the keypad
	// and then enters the last number of a line as anumber for the final code.
	// Returns a String interpretation of the code.
	public String run() throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		int i = 0;
		int j = 0;
		while ((j = buf.read()) != -1) {
			switch (j) {
				case 'U':	if (!(posY == 0)) {
								posY--;				
							}
							break;

				case 'D':	if (!(posY == 2)) {
								posY++;
							}
							break;

				case 'L':	if (!(posX == 0)) {
								posX--;
							}
							break;

				case 'R':	if (!(posX == 2)) {
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

	// Adds the numbers from the code to a String
	// (in a slow fashion, but with so few numbers it doesn't matter)
	private String interpret(int[] i) {
		String numbers = "";
		for (int j: i) {
			numbers = numbers + j;
		}
		return numbers;
	}
}