import java.io.*;
import java.util.*;

public class ABC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int[] arr = new int[3];
		arr[0] = readInt(); arr[1] = readInt(); arr[2] = readInt();
		Arrays.sort(arr);
		String order = readLine();
		for (int i = 0; i < 3; i ++) System.out.print(arr[order.charAt(i) - 'A'] + " ");
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
