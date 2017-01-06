import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(new File("input.txt"));

		Part01 part01 = new Part01(input);
		System.out.println("Result from part 1: " + part01.run()); //138 too high, 38 too low (38,138)

		Part02 part02 = new Part02(new Scanner(new File("input.txt")));
		System.out.println("Result from part 2: " + part02.run());
	}

	// private static void init() throws IOException, FileNotFoundException {
	// 	BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
	// 	String line = "";

	// 	while ((line = buf.readLine()) != null) {
	// 		input.add(line);
	// 	}
	// }
}