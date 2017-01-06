import java.util.ArrayList;
import java.util.Scanner;

public class Part02 {

	// private static ArrayList<char[]> input;
	private Scanner input;
	private final String HYPERNET = "\\[\\w+\\]";

	public Part02(Scanner input) {
		this.input = input.useDelimiter(HYPERNET);
	}

	public int run() {
		int count = 0;

		while (input.hasNextLine()) {
			// char[] line = input.nextLine().toCharArray();
			if (isValid(input.nextLine())) {
				count++;
			}
		}
		return count;
	}

	private boolean isValid(String line) {
		// int length = line.length - 3;
		ArrayList<char[]> aba = getSuperSeq(line); // an ArrayList containing every "aba" outside brackets
		ArrayList<char[]> bab = getHyperSeq(line); // an ArrayList containing every "bab" inside brackets

		return match(aba,bab);

		// boolean valid = false;
		// int index = 0;

		// while (index < length) {
		// 	if (line[index] == '[') { // if start bracket

		// 		if (isValid(line)) { // if abba is found within bracket
		// 			return false;
		// 		}
		// 		while (line[++index] != ']');
		// 	}
		// 	else if (line[index] == ']') { // if end of bracket
		// 		return valid;
		// 	}
		// 	else if (line[index] == line[index+1]); // if 'aaaa'
		// 	else if (line[index] == line[index+3] && line[index+1] == line[index+2]) { // if 'xyyx'
		// 		valid = true;
		// 	}
		// 	index++;
		// }
		// return valid;
	}

	// Matches two lists to find if an "aba" has a matching "bab"
	private boolean match(ArrayList<char[]> aba, ArrayList<char[]> bab) {

		for (char[] c: aba) {
			for (char[] d: bab) {
				if (c[0] == d[1] && d[0] == c[1]) {
					return true;
				}
			}
		}
		return false;
	}

	private ArrayList<char[]> getSuperSeq(String line) {
		ArrayList<char[]> finalSeq = new ArrayList<char[]>();
		String[] aba = line.split(HYPERNET);

		for (String s: aba) {
			char[] seq = s.toCharArray();
			int length = seq.length - 3;

			for (int i = 0; i < length; i++) {

				if (seq[i] == seq[i+2] && seq[i] != seq[i+1]) {
					// String t = "";
					// t = t + (char) seq[i] + (char) seq[i+1] + (char) seq[i+2];
					finalSeq.add(new char[]{seq[i],seq[i+1],seq[i+2]});
				}
			}
		}
		return finalSeq;
	}

	// TODO
	private ArrayList<char[]> getHyperSeq(String line) {
		ArrayList<char[]> finalSeq = new ArrayList<char[]>();
		String[] bab = line.split();

		for (String s: bab) {
			char[] seq = s.toCharArray();
			int length = seq.length - 3;

			for (int i = 0; i < length; i++) {

				if (seq[i] == seq[i+2] && seq[i] != seq[i+1]) {
					// String t = "";
					// t = t + (char) seq[i] + (char) seq[i+1] + (char) seq[i+2];
					finalSeq.add(new char[]{seq[i],seq[i+1],seq[i+2]});
				}
			}
		}
		return finalSeq;
	}
}