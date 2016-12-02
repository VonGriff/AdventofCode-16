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
							if (move(Integer.parseInt(input.group()))) {
								return Math.abs(lat-500) + Math.abs(lon-500);
							}
							// System.out.println("Longitude: " + lon + "\nLatitude: " + lat);
							// if (grid[lon][lat]) {
							// }
							// else {
							// 	grid[lon][lat] = true;
							// }
			}
		}
		// System.out.println("longitud: " + lon + "\nlatitud: " + lat);
		return Math.abs(lat-500) + Math.abs(lon-500);
	}

	private boolean move(int steps) {

		direction = direction % 360;

		for (int i = 0; i < steps; i++) {
			grid[lon][lat] = true;
			switch (direction) {
				case 0:
						lat++;
						break;
				case 90:
						lon++;
						break;
				case 180:
						lat--;
						break;
				case 270:
						lon--;
						break;
			}
			if (grid[lon][lat]) {
				return true;
			}
		}
		return false;
	}
}