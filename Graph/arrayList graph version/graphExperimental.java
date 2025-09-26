import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class graphExperimental {
    // DFS traversal function
    public static ArrayList<Integer> dfsOfGraph(int start, int V, Map<Integer, ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        st.add(start);
        vis.add(start);

        while (!st.isEmpty()) {
            int curr = st.pop();
            dfs.add(curr);

            for (int i = adj.get(curr).size() - 1; i >= 0; i--) {
                int it = adj.get(curr).get(i);
                if (!vis.contains(it)) {
                    st.push(it);
                    vis.add(it);
                }
            }
        }

        return dfs;
    }

    // BFS traversal function
    public static List<Integer> bfsOfGraph(int start, Map<Integer, ArrayList<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        vis.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            for (Integer it : adj.getOrDefault(node, new ArrayList<>())) {
                if (!vis.contains(it)) {
                    vis.add(it);
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // undirected
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        List<Integer> bfsResult = bfsOfGraph(start, adj);
        System.out.println("BFS traversal of the graph: " + bfsResult);

        sc.close();
    }
}
