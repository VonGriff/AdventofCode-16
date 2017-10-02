import java.util.Scanner;
import java.util.ArrayList;

public class Part01 {

	private Scanner input;

	public Part01(Scanner input) {
		this.input = input;
	}

	public int run() {
		int sum = 0;
		String encryption;
		String sectorID;
		String checkSum;

		while (input.hasNextLine()) {
			encryption = input.findInLine("([a-z]+-)+[a-z]+");
			sectorID = input.findInLine("\\d+");
			checkSum = input.findInLine("\\[\\w+\\]");

			// System.out.println("encryption: " + encryption + "\nsectorID: " + sectorID + "\nChecksum: " + checkSum);
			if (isValidChecksum(checkSum))
				sum += Integer.parseInt(sectorID);
			if (input.hasNextLine())
				input.nextLine();
		}
		return sum;
	}

	// Finds and returns the 5 most common characters from the string
	private char[] getMostCommon(String encryption) {
		ArrayList<Character> letters = new ArrayList<Character>();
		char[] common = new char[5];

		for (int i=0; i<encryption.length(); i++) {
			c = encryption.charAt(i);

			if (!letters.contain(c) && c != '-')
				letters.add(c);
		}
		return common;
	}

	private boolean isValidChecksum(String checkSum) {
		char[] c = checkSum.toCharArray();
		for (int i = 1; i < c.length-1; i++) {
			// if(c[i] > c[i+1])
			// 	return false;
		}
		return true;
	}
}