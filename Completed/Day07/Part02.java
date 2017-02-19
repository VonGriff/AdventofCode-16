import java.util.ArrayList;
import java.util.Scanner;

public class Part02 {

	private Scanner input;
	private final String HYPERNET = "\\[\\w+\\]";

	public Part02(Scanner input) {
		this.input = input;
	}

	public int run() {
		int count = 0;
		int num = 0;
		while (input.hasNextLine()) {
			// char[] line = input.nextLine().toCharArray(); // This row fucks up
			// everything, not because of nextLine() (I think) but deleting it
			// makes every line not print as they should....
			System.out.println("Line number: " + ++num);
			if (isValid(input.nextLine().toCharArray())) {
				count++;
			}
		}
		return count;
	}

	private boolean isValid(char[] line) {
		ArrayList<char[]> aba = getSuperSeq(line); // an ArrayList containing every "aba" outside brackets
		ArrayList<char[]> bab = getHyperSeq(line); // an ArrayList containing every "bab" inside brackets

		return match(aba,bab);
	}

	// Matches two lists to find if an "aba" has a matching "bab"
	private boolean match(ArrayList<char[]> aba, ArrayList<char[]> bab) {

		for (char[] c: aba) {
			for (char[] d: bab) {
				if (c[0] == d[1] && d[0] == c[1]) {
					System.out.println("aba: " + c[0] + c[1] + c[2] + "\nbab: " + d[0] + d[1] + d[2]);
					return true;
				}
			}
		}
		return false;
	}

	private ArrayList<char[]> getSuperSeq(char[] sup) {
		ArrayList<char[]> finalSeq = new ArrayList<char[]>();
		// char[] sup = line.toCharArray();
		int length = sup.length - 2;

		String s = "";

		for (int i = 0; i < length; i++) {
			s += sup[i];
			if (sup[i+2] == '[') {
				s += '[';
				while(sup[++i] != ']');
				s += ']';
			}
			else if (sup[i] == sup[i+2] && sup[i] != sup[i+1]) {
				finalSeq.add(new char[]{sup[i],sup[i+1],sup[i+2]});
			}
		}
		System.out.println(s);
		return finalSeq;

		// String[] aba = line.split(HYPERNET);
		// String a = "";
		// int j = 0;
		// for (String s: aba) {
		// 	a += s + "[]";
		// 	System.out.println(++j + " String");
		// }
		// System.out.println(a);

		// for (String s: aba) {
		// 	char[] seq = s.toCharArray();
		// 	int length = seq.length - 3;

		// 	for (int i = 0; i < length; i++) {

		// 		if (seq[i] == seq[i+2] && seq[i] != seq[i+1]) {
		// 			// String t = "";
		// 			// t = t + (char) seq[i] + (char) seq[i+1] + (char) seq[i+2];
		// 			finalSeq.add(new char[]{seq[i],seq[i+1],seq[i+2]});
		// 		}
		// 	}
		// }
		// return finalSeq;
	}

	private ArrayList<char[]> getHyperSeq(char[] hyper) {
		ArrayList<char[]> finalSeq = new ArrayList<char[]>();
		// String hyper = line.toCharArray();
		int length = hyper.length - 2;
		String s = "";

		for (int i=0; i<length; i++) {
			if (hyper[i] != '[') {
				while (i < length && hyper[++i] != '[');
				s += "[";
				while (i < length && hyper[++i] != ']') {
					s += hyper[i];
					if (hyper[i] == hyper[i+2] && hyper[i] != hyper[i+1]) {
						finalSeq.add(new char[]{hyper[i],hyper[i+1],hyper[i+2]});
					}
				}
				s += "]";
			}
		}
		System.out.println("Hyper: " + s);
		return finalSeq;
	}

	// This doesn't work, something with pointers, find out why
	private ArrayList<char[]> getHyperSeq() {
		ArrayList<char[]> finalSeq = new ArrayList<char[]>();
		String hyper = "";

		while ((hyper = input.findInLine(HYPERNET)) != null) {
			System.out.println("Hyper: " + hyper);
			char[] seq = hyper.toCharArray();
			int length = seq.length - 3;

			for (int i = 1; i < length; i++) {

				if (seq[i] == seq[i+2] && seq[i] != seq[i+1]) {
					finalSeq.add(new char[]{seq[i],seq[i+1],seq[i+2]});
				}
			}
		}
		return finalSeq;
	}
}