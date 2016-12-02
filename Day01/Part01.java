import java.util.regex.Matcher;
import java.lang.Math;

public class Part01 {

	private int lat;
	private int lon;
	private Matcher input;
	private int direction = 90;
	private final static int TURN = 90;

	public Part01(Matcher input) {
		this.input = input;
		lat = 0;
		lon = 0;
	}

	// TODO
	public int run() {
		while (input.find()) {

			switch (input.group()) {
				case "R":
							if ((direction -= TURN) < 0) {
								direction = 270;
							}
							break;
				case "L":	
							if ((direction += TURN) > 360) {
								direction = 90;
							}
						 	break;
				default:
							move(Integer.parseInt(input.group()));
			}
		}
		// System.out.println("longitud: " + lon + "\nlatitud: " + lat);
		return Math.abs(lat) + Math.abs(lon);
	}

	private void move(int steps) {
		direction = direction % 360;

		switch (direction) {
			case 0:
					lat += steps;
					break;
			case 90:
					lon += steps;
					break;
			case 180:
					lat -= steps;
					break;
			case 270:
					lon -= steps;
					break;
		}
	}
}