import java.util.Scanner;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("input.txt"));
		Part01 part01 = new Part01(input);
		System.out.println("Result from part 1: " + part01.run());
	}
}