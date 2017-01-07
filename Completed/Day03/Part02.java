import java.util.ArrayList;

public class Part02 {
	
	ArrayList<Integer[]> input;

	public Part02(ArrayList<Integer[]> input) {
		this.input = input;
	}

	public int run() {
		int count = 0;

		for (int i = 0; i < input.size(); i+=3) {
			// Contains the first value of the three next coming arrays
			Integer[] one = {input.get(i)[0],input.get(i+1)[0],input.get(i+2)[0]};
			// Contains the second value of the arrays
			Integer[] two = {input.get(i)[1],input.get(i+1)[1],input.get(i+2)[1]};
			// Contains the third value
			Integer[] three = {input.get(i)[2],input.get(i+1)[2],input.get(i+2)[2]};

			if (isValidTriangle(one)) {
				count++;
			}
			if (isValidTriangle(two)) {
				count++;
			}
			if (isValidTriangle(three)) {
				count++;
			}
			j=i;
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