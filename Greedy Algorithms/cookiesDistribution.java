import java.util.Arrays;
public class cookiesDistribution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        int gp = 0, sp = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while(gp < n && sp < m){
            if (s[sp] >= g[gp]) { 
                gp++; // child satisfied, move to next child
            }
            sp++; // always move to next cookie
        }

        return gp; // number of satisfied children
    }

    public static int findContentChildren(int[] g, int[] s) {
        //my soln
        // Step 1: store cookies in TreeMap with frequencies
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int cookie : s) {
            freq.put(cookie, freq.getOrDefault(cookie, 0) + 1);
        }

        int satisfied = 0;

        // Step 2: try to satisfy each child
        for (int child : g) {
            // find the smallest cookie >= child's greed
            Integer candidate = freq.ceilingKey(child);

            if (candidate != null) {
                // assign this cookie
                satisfied++;
                // decrease frequency
                int count = freq.get(candidate);
                if (count == 1) {
                    freq.remove(candidate);
                } else {
                    freq.put(candidate, count - 1);
                }
            }
            // else -> no cookie available for this child
        }

        return satisfied;
    }
}