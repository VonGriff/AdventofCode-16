import java.util.Scanner;

public class Part01 {

	private Scanner input;

	public Part01(Scanner input) {
		this.input = input;
	}

	public int run() {
		int count = 0;

		while (input.hasNextLine()) {
			char[] line = input.nextLine().toCharArray();
			if (isValid(line,0)) {
				count++;
			}
		}
		return count;
	}

	private boolean isValid(char[] line, int index) {
		int length = line.length - 3;
		boolean valid = false;

		while (index < length) {
			if (line[index] == '[') { // if start bracket

				if (isValid(line,index+1)) { // if abba is found within bracket
					return false;
				}
				while (line[++index] != ']');
			}
			else if (line[index] == ']') { // if end of bracket
				return valid;
			}
			else if (line[index] == line[index+1]); // if 'aaaa'
			else if (line[index] == line[index+3] && line[index+1] == line[index+2]) { // if 'xyyx'
				valid = true;
			}
			index++;
		}
		return valid;
	}
}