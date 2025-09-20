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
}