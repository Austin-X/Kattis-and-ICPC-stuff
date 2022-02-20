import java.io.*;
import java.util.*;

public class AlienIntegers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String val = readLine();
		char[] n = val.toCharArray();
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (char c: n) s.add(Character.getNumericValue(c));
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i <= 9; i ++) set.add(i);
		for (int x: s) set.remove(x);
		
		if (set.isEmpty()) { System.out.println("Impossible"); System.exit(0); }
	
		String lower = "", upper = "";
		
		for (int i = s.get(0) - 1; i >= 0; i --) if (!s.contains(i)) { lower = String.valueOf(i); break; }
		for (int i = s.get(0) + 1; i <= 9; i ++) if (!s.contains(i)) { upper = String.valueOf(i); break; }
		if (upper.equals("")) {
			if (set.first() == 0) {
				for (int i = 1; i <= 9; i ++) if (set.contains(i)) { upper = String.valueOf(i) + set.first(); break; }
			} else upper = String.valueOf(set.first()) + set.first();
		}
		
		for (int i = 1; i < n.length; i ++) lower += set.last();
		if (!upper.equals("")) for (int i = 1; i < n.length; i ++) upper += set.first();
	
		long dis1 = Long.MAX_VALUE, dis2 = Long.MAX_VALUE;
		if (!lower.equals("")) {
			lower = String.valueOf(Long.parseLong(lower));
			dis1 = Long.parseLong(val) - Long.parseLong(lower);
		}
		if (!upper.equals("")) dis2 = Long.parseLong(upper) - Long.parseLong(val);

		if (dis1 == dis2) System.out.println(lower + " " + upper);
		else if (dis1 < dis2) System.out.println(lower);
		else System.out.println(upper);
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
