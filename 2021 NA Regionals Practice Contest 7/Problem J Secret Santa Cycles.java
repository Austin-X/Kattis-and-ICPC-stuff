// THIS SOLUTION DOESN'T WORK YET! THIS IS A WORK-IN-PROGRESS!

import java.io.*;
import java.util.*;

public class SecretSantaCycles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

  static int[] dp;
  static boolean[] vis;
  
  static int solve(ArrayList<Integer>[] adj, int idx) {
    if (vis[idx]) return 0;
    vis[idx] = true;
    
    if (adj[idx].size() > 1 || adj[idx].size() == 0) return dp[idx] = 1;

    int val = adj[idx].get(0);
    if (dp[val] != -1) return dp[idx] = dp[val] + 1;
    else return dp[idx] = solve(adj, val) + 1;
  }
  
	public static void main(String[] args) throws IOException {
		int n = readInt();

    ArrayList<Integer>[] adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
    for (int i = 1; i <= n; i ++) adj[readInt()].add(i);
    
    dp = new int[n + 1];
    vis = new boolean[n + 1];
    Arrays.fill(dp, -1);

    int max = 0;
    for (int i = 1; i <= n; i ++) {
      solve(adj, 1);
      max = Math.max(max, dp[i]);
    }

    System.out.println(n - max);
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
