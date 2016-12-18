import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	private static final String NAME = "\\w+",
								SECTORID = "\\d+",
								CHECKSUM = "\\[\\w+\\]";


	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<LinkedList<String>> input = init();
		Part01 part01 = new Part01(input);
		System.out.println("Result from part 1: " + part01.run());
	}

	// Initiates and returns an ArrayList for saving each line and each match within the line
	private static ArrayList<LinkedList<String>> init() throws IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		Pattern p = Pattern.compile(CHECKSUM + "|" + NAME + "|" + SECTORID);
		Matcher m;
		String line;
		ArrayList<LinkedList<String>> input = new ArrayList<LinkedList<String>>();

		while ((line = buf.readLine()) != null) {
			m = p.matcher(line);
			LinkedList<String> categories = new LinkedList<String>();
			while (m.find()) {
				categories.add(m.group());
			}
			input.add(categories);
		}
		return input;
	}
}