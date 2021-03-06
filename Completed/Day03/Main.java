import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	private static ArrayList<Integer[]> input = new ArrayList<Integer[]>();

	public static void main(String[] args) throws IOException, java.io.FileNotFoundException {
		init();

		Part01 part01 = new Part01(input);
		System.out.println("Result from part 1: " + part01.run());

		Part02 part02 = new Part02(input);
		System.out.println("Result from part 2: " + part02.run()); // 1574 is too low
	}

	private static void init() throws IOException {

		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		Pattern p = Pattern.compile("\\d{3}|\\d{2}|\\d");
		String line;

		while ((line = buf.readLine()) != null) {
			addTri(p.matcher(line));
		}
	}

	// Creates an array with the sides for a triangle and
	// adds it to input for further use
	private static void addTri(Matcher m) {

		Integer[] sides = new Integer[3];

		for (int i = 0; i < 3; i++) {
			m.find();
			sides[i] = Integer.parseInt(m.group());
		}
		input.add(sides);
	}
}