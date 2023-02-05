import java.io.*;
import java.util.*;

public class Bela {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), ans = 0;
		char s = readCharacter();
		
		for (int i = 0; i < 4 * n; i ++) {
			char[] l = readLine().toCharArray();
			switch (l[0]) {
			case 'A': ans += 11; break;
			case 'K': ans += 4; break;
			case 'Q': ans += 3; break;
			case 'J': ans += l[1] == s ? 20 : 2; break;
			case 'T': ans += 10; break;
			case '9': ans += l[1] == s ? 14 : 0; break;
			}
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
