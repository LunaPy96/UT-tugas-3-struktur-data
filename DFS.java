import java.util.*;

public class DFS {
    private Map<String, List<String>> graph;
    private Set<String> visited;

    public DFS() {
        graph = new HashMap<>();
        visited = new HashSet<>();
        buatGraph();
    }

    private void buatGraph() {
        graph.put("a0", Arrays.asList("a1", "a3"));
        graph.put("a1", Arrays.asList("a0", "a2", "a4"));
        graph.put("a2", Arrays.asList("a1", "a5"));
        graph.put("a3", Arrays.asList("a0", "a4", "a6"));
        graph.put("a4", Arrays.asList("a1", "a3", "a5", "a7"));
        graph.put("a5", Arrays.asList("a2", "a4", "a8"));
        graph.put("a6", Arrays.asList("a3", "a7"));
        graph.put("a7", Arrays.asList("a4", "a6", "a8"));
        graph.put("a8", Arrays.asList("a5", "a7", "a9"));
        graph.put("a9", Arrays.asList("a8"));
    }

    public boolean dfs(String mulai, String target) {
        visited.clear();
        return dfsRekursif(mulai, target, 0);
    }

    private boolean dfsRekursif(String node, String target, int level) {
        System.out.println(" ".repeat(level * 2) + "Kunjungi: " + node);

        if (node.equals(target)) {
            System.out.println(" ".repeat(level * 2) + "Ketemu " + target + "!");
            return true;
        }

        visited.add(node);

        for (String tetangga : graph.get(node)) {
            if (!visited.contains(tetangga)) {
                if (dfsRekursif(tetangga, target, level + 1)) {
                    return true;
                }
            }
        }

        System.out.println(" ".repeat(level * 2) + "Backtrack dari: " + node);
        return false;
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        String target = "a6";
        System.out.println("Mulai DFS cari " + target + " dari a0\n");
        dfs.dfs("a0", target);
    }
}