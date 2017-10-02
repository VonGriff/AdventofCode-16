import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Main {

	private static BufferedReader buf;
	private static ArrayList<String> input = new ArrayList<String>();
	private static final String RECT =  "rect",
								ROTATE = "rotate",
								ROW = "row",
								COLUMN = "column",
								NUM = "\\d+";

	public static void main(String[] args) throws IOException {
		init();
		Part01 part01 = new Part01();
		System.out.println(part01.run());

		Part02 part02 = new Part02(part01.getScreen());
		System.out.println(part02.run());
	}

	private static void init() throws IOException, FileNotFoundException {
		buf = new BufferedReader(new FileReader("input.txt"));
		Pattern p = Pattern.compile(RECT + "|" + ROTATE + "|" + ROW + "|" + 
									COLUMN + "|" + NUM);
		Matcher m;
		String line;
		while ((line = buf.readLine()) != null) {
			m = p.matcher(line);
		}
		return;
	}
	
}
