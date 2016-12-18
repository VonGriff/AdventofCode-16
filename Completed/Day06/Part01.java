// Part goal: for every column in a given input find
// the most common character and add it to spell a word
public class Part01 {

	private char[][] input;

	public Part01(char[][] input) {
		this.input = input;
	}

	// Finds and returns the final word
	public String run() {
		String message = "";
		// For each column
		for (int j = 0; j < 8; j++) {
			char letter = 0;
			int counter = 0;
			int max = 0;
			// In each row
			for (int i = 0; i < 598; i++) {

				counter = count(input[i][j], j);
				if (counter > max) {
					max = counter;
					letter = input[i][j];
				}
			}
			message = message + letter;
		}
		return message;
	}
	// Counts the amount of matching characters "c" from
	// "input" in the given column "j"
	private int count(char c, int j) {
		int counter = 0;

		for (int i = 0; i < 598; i++) {

			if (input[i][j] == c) {
				counter++;
			}
		}

		return counter;
	}
}