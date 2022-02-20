import java.io.*;
import java.util.*;

public class PizzaParty {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int c = readInt();
		
		HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		
		ArrayList<String> single = new ArrayList<String>();
		int cnt = 1;
		
		HashMap<String, Integer> req = new HashMap<String, Integer>();
		
		while (c-- > 0) {
			String str = readLine();
			if (str.contains(" and ")) {
				String spl = str.substring(3, str.indexOf(" then "));
				String res = str.substring(str.indexOf(" then ") + 6);
				String[] temp = spl.split(" and ");
				
				String id = " and " + cnt;
				cnt ++;
				
				for (String x: temp) {
					if (!map.containsKey(x)) map.put(x, new HashSet<String>());
					if (!map.get(x).contains(id)) {
						map.get(x).add(id);
						
						if (!req.containsKey(id)) req.put(id, 0);
						req.put(id, req.get(id) + 1);
					}
 				}
				map.put(id, new HashSet<String>());
				map.get(id).add(res);
			} else if (str.contains("if ")) {
				String spl = str.substring(3, str.indexOf(" then "));
				String res = str.substring(str.indexOf(" then ") + 6);
				String[] temp = spl.split(" or ");
				
				for (String x: temp) {
					if (!map.containsKey(x)) map.put(x, new HashSet<String>());
					map.get(x).add(res);
 				}
			} else {
				single.add(str);
			}
		}
		
		for (int i = 0; i < single.size(); i ++) {
			for (int j = i + 1; j < single.size(); j ++) {
				String val1 = single.get(i), val2 = single.get(j);
				if (!map.containsKey(val1)) map.put(val1, new HashSet<String>());
				if (!map.containsKey(val2)) map.put(val2, new HashSet<String>());
				map.get(val1).add(val2);
				map.get(val2).add(val1);
			}
		}

		if (single.isEmpty()) { System.out.println(0); System.exit(0); }

		Queue<String> q = new LinkedList<String>();
		q.add(single.get(0));

		HashSet<String> vis = new HashSet<String>();
		vis.add(single.get(0));
		
		HashMap<String, HashSet<String>> counter = new HashMap<String, HashSet<String>>();
		
		while (!q.isEmpty()) {
			String cur = q.poll();
			
			if (cur.contains(" and ")) {
				if (counter.get(cur).size() == req.get(cur)) {
					for (String d: map.get(cur)) {
						if (!vis.contains(d)) {
							vis.add(d);
							q.add(d);
						}
					}
				}
			}
			else {
				if (!map.containsKey(cur)) continue;
				for (String x: map.get(cur)) {
					if (!vis.contains(x)) {
						if (x.contains(" and ")) {
							if (!counter.containsKey(x)) counter.put(x, new HashSet<String>());
							counter.get(x).add(cur);
						}
						vis.add(x);
						q.add(x);
					} else if (x.contains(" and ")) {
						counter.get(x).add(cur);
						q.add(x);
					}
				}
			}
		}

		int ans = 0;
		for (String x: vis) if (!x.contains(" and ")) ans ++;

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
