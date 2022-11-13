import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
	public static void main(String[] args) {  
		String champion = "";
		String candidate = StdIn.readString();
		int i = 1;
		while(!StdIn.isEmpty()) {
			if (StdRandom.bernoulli(1f / i)) {
				champion = candidate;
			}
			candidate = StdIn.readString();
			i++;
		}
		StdOut.println(champion);
	}
}


