import java.io.*;
import java.util.*;

public class TicTacState {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int c = readInt();
		
		while (c-- > 0) {
			int val = 0;
			char[] arr = readLine().toCharArray();
			for (int i = arr.length - 1, j = 0; i >= 0; i --, j ++) val += Math.pow(8, j) * Character.getNumericValue(arr[i]);
			String res = "";
			for (int i = 18; i >= 0; i --) {
				int v = (int)Math.pow(2, i);
				if (val >= v) {
					val -= v;
					res += "1";
				} else res += "0";
			}
			
			boolean b = true;
			for (int i = 10; i <= 18; i ++) if (res.charAt(i) == '0') { b = false; break; }
			
			int[][] grid = new int[3][3];
			for (int[] x: grid) Arrays.fill(x, -1);

			int idx = 9;
			for (int i = 0; i < 3; i ++) {
				for (int j = 0; j < 3; j ++) {
					if (res.charAt(idx + 9) == '0') { idx --; continue; }
					if (res.charAt(idx) == '0') grid[i][j] = 0;
					else if (res.charAt(idx) == '1') grid[i][j] = 1;
					idx --;
				}
			}
			
			boolean xWin = false, oWin = false;
			for (int i = 0; i < 3; i ++) {
				if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
					if (grid[i][0] == 1) xWin = true;
					else if (grid[i][0] == 0) oWin = true;
				}
			}
			for (int i = 0; i < 3; i ++) {
				if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
					if (grid[0][i] == 1) xWin = true;
					else if (grid[0][i] == 0) oWin = true;
				}
			}
			if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
				if (grid[0][0] == 1) xWin = true;
				else if (grid[0][0] == 0) oWin = true;
			}
			if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
				if (grid[0][2] == 1) xWin = true;
				else if (grid[0][2] == 0) oWin = true;
			}
			
			if (xWin) System.out.println("X wins");
			else if (oWin) System.out.println("O wins");
			else {
				if (!b) System.out.println("In progress");
				else System.out.println("Cat's");
			}
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
