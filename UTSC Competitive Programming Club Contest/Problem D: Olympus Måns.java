import java.io.*;
import java.util.*;

public class OlympusMans {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	

	public static void main(String[] args) throws IOException {
		int n = readInt(), max = 0, maxIdx = 0;
		int[] h = new int[n];
		for (int i = 0; i < n; i ++) { 
			h[i] = readInt();
			if (h[i] > max) { max = h[i]; maxIdx = i; }
		}

		long ans = 0;
		for (int i = 0; i < maxIdx; i ++) {
			double slope = ((double)max - h[i])/(maxIdx - i);
			long x = (long) Math.floor(maxIdx - (double)(max - h[0] - 4)/slope - 0.000001);
			x = -x;
			ans = Math.max(ans, x);
		}
		
		System.out.println(ans);
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
