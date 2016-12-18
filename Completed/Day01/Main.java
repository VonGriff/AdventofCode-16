import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {

	// Creates two objects an fetches the result from respective parts
	public static void main(String[] args) throws IOException, FileNotFoundException {

		Matcher input = init();
		Part01 part01 = new Part01(input);
		System.out.println("Result from part 1: " + part01.run());

		input.reset();
		Part02 part02 = new Part02(input);
		System.out.println("Result from part 2: " + part02.run());
	}

	// Takes our input, and returns a Matcher with a certain compiled Pattern
	private static Matcher init() throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		Pattern p = Pattern.compile("[RL]|\\d{3}|\\d{2}|\\d");
		String line = in.readLine();
		Matcher m = p.matcher(line);

		return m;
	}
}