import java.util.regex.Matcher;
import java.lang.Math;

// Part01 goal: Take a direction, move a certain amount of steps and at the end of
// instructions calculate the shortest distance from the starting point to end point.
public class Part01 {

	private int lat;
	private int lon;
	private Matcher input;
	private int direction;
	private final static int TURN = 90;

	public Part01(Matcher input) {
		this.input = input;
		lat = 0;
		lon = 0;
		direction = 90;
	}

	// Executes part01, finds the corresponding command and changes direction.
	// Returns the result of part01
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

	// Moves e certain amount of steps in the current given direction
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