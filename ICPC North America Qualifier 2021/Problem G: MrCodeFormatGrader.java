import java.io.*;
import java.util.*;

public class MrCodeFormatGrader {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int c = readInt(), n = readInt();
		
		boolean[] e = new boolean[c + 1];
		ArrayList<String> errors = new ArrayList<String>(), correct = new ArrayList<String>();
		
		for (int i = 0; i < n; i ++) {
			int x = readInt();
			e[x] = true;
			
			if (errors.isEmpty()) { errors.add(String.valueOf(x)); continue; }
			String[] temp = errors.get(errors.size() - 1).split("-");

			int start = Integer.parseInt(temp[0]);
			if (temp.length > 1) {
				int end = Integer.parseInt(temp[1]);
				if (x == end + 1) {
					String s = start + "-"  + x;
					errors.remove(errors.size() - 1);
					errors.add(s);
				} else errors.add(String.valueOf(x));
			} else {
				if (x == start + 1) {
					String s = start + "-"  + x;
					errors.remove(errors.size() - 1);
					errors.add(s);
				} else errors.add(String.valueOf(x));
			}
		}
		
		for (int i = 1; i <= c; i ++) {
			if (e[i]) continue;
			
			if (correct.isEmpty()) { correct.add(String.valueOf(i)); continue; }
			String[] temp = correct.get(correct.size() - 1).split("-");

			int start = Integer.parseInt(temp[0]);
			if (temp.length > 1) {
				int end = Integer.parseInt(temp[1]);
				if (i == end + 1) {
					String s = start + "-"  + i;
					correct.remove(correct.size() - 1);
					correct.add(s);
				} else correct.add(String.valueOf(i));
			} else {
				if (i == start + 1) {
					String s = start + "-"  + i;
					correct.remove(correct.size() - 1);
					correct.add(s);
				} else correct.add(String.valueOf(i));
			}
		}
		
		System.out.print("Errors: ");
		
		for (int i = 0; i < errors.size(); i ++) {
			if (i == errors.size() - 2) { 
				if (i > 0) System.out.print(", ");
				System.out.println(errors.get(i) + " and " + errors.get(i + 1)); break; 
			}
			else if (i == 0) System.out.print(errors.get(0));
			else System.out.print(", " + errors.get(i));
		}
		System.out.print("Correct: ");
		for (int i = 0; i < correct.size(); i ++) {
			if (i == correct.size() - 2) { 
				if (i > 0) System.out.print(", ");
				System.out.println(correct.get(i) + " and " + correct.get(i + 1)); break; 
			}
			else if (i == 0) System.out.print(correct.get(0));
			else System.out.print(", " + correct.get(i));
		}
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
