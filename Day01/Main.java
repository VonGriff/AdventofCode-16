import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, java.io.FileNotFoundException {

		Matcher input = init();
		Part01 part01 = new Part01(input); // 333 too high
		System.out.println("Result from part 1: " + part01.run());

		input.reset();
		Part02 part02 = new Part02(input); // 269 too high
		System.out.println("Result from part 2: " + part02.run());
	}

	private static Matcher init() throws IOException, java.io.FileNotFoundException {

		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		Pattern p = Pattern.compile("[RL]|\\d{3}|\\d{2}|\\d");
		String line = in.readLine();
		Matcher m = p.matcher(line);
		// System.out.println(m);
		return m;
	}
}