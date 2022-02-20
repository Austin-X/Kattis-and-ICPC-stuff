import java.io.*;
import java.util.*;

public class EyeOfSauron {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int cnt1 = 0, cnt2 = 0;
		char[] n = readLine().toCharArray();
		
		int i = 0;
		while (true) {
			if (n[i] == '(') { i += 2; break; }
			i ++;
			cnt1 ++;
		}
		cnt2 = n.length - i;
		System.out.println(cnt1 == cnt2 ? "correct" : "fix");
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
