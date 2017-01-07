import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class Part01 {

	private ArrayList<Integer[]> input;

	public Part01(ArrayList<Integer[]> input) {
		this.input = input;
	}

	public int run() throws IOException {
		int count = 0;

		for (Integer[] i: input) {
			if (isValidTriangle(i)) {
				count++;
			}
		}
		return count;
	}

	private boolean isValidTriangle(Integer[] num) {

		if (num[0] + num[1] <= num[2]) {
			return false;
		}
		if (num[0] + num[2] <= num[1]) {
			return false;
		}
		if (num[1] + num[2] <= num[0]) {
			return false;
		}
		return true;
	}
}