import java.util.regex.Matcher;

public class Part02 {
	
	private int lat;
	private int lon;
	private Matcher input;
	private int direction = 90;
	private final static int TURN = 90;
	private boolean[][] grid = new boolean[1000][1000];

	public Part02(Matcher input) {
		this.input = input;
		lat = 500;
		lon = 500;
		grid[lon][lat] = true;
	}

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
							System.out.println("Longitude: " + lon + "\nLatitude: " + lat);
							if (grid[lon][lat]) {
								return Math.abs(lat-500) + Math.abs(lon-500);
							}
							else {
								grid[lon][lat] = true;
							}
			}
		}
		// System.out.println("longitud: " + lon + "\nlatitud: " + lat);
		return -1;
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