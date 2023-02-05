import java.io.*;
import java.util.*;

public class H_Index {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int[] c;
	public static void main(String[] args) throws IOException {
		n = readInt();
		c =  new int[n];
		for (int i = 0; i < n; i ++) c[i] = readInt();
		
		int low = 0, high = n;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (works(mid)) low = mid + 1;
			else high = mid - 1;
		}
		System.out.println(low - 1);
	}
	
	public static boolean works(int x) {
		int cnt = 0;
		for (int i = 0; i < n; i ++) if (c[i] >= x) cnt ++;
		return cnt >= x ? true : false;
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
