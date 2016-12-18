import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		char[][] input = init();
		Part01 part01 = new Part01(input);
		System.out.println("Result from part 1: " + part01.run());

		Part02 part02 = new Part02(input);
		System.out.println("Result from part 2: " + part02.run());
	}

	// Reads from the input text and puts it in and returns a char array
	private static char[][] init() throws IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		int index = 0;
		String line;
		char[][] c = new char[598][];

		while ((line =buf.readLine()) != null) {
			c[index] = line.toCharArray();
			index++;
		}
		return c;
	}
}