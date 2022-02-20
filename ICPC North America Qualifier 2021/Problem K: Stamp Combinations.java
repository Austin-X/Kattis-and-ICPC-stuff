import java.io.*;
import java.util.*;

public class StampCombinations {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt();
		
		int[] a = new int[m + 1];
		for (int i = 1; i <= m; i ++) a[i] = readInt();
		
		HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = m; i >= 0; i --) {
			sum += a[i];
			right.put(sum, i);
		}

		while (n-- > 0) {
			int q = readInt();
			
			boolean b = false;
			sum = 0;
			for (int i = 0; i <= m; i ++) {
				if (sum > q) break;
				if (sum == q) { b = true; break; }
				
				int diff = q - sum;
				if (right.containsKey(diff) && right.get(diff) >= i) { b = true; break; }
				sum += a[i];
			}
			
			System.out.println(b ? "Yes": "No");
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
