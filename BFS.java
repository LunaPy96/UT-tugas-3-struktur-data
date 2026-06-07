import java.util.*;

public class BFS {
    private Map<String, List<String>> graph;

    public BFS() {
        graph = new HashMap<>();
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

    public boolean bfs(String mulai, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(mulai);
        visited.add(mulai);
        parent.put(mulai, null);

        System.out.println("Queue awal :" + queue);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.println("Ambil dari queue: " + node);

            if (node.equals(target)) {
                cetakJalur(parent, target);
                return true;
            }

            for (String tetangga : graph.get(node)) {
                if (!visited.contains(tetangga)) {
                    visited.add(tetangga);
                    queue.add(tetangga);
                    parent.put(tetangga, node);
                    System.out.println(" Masukkan ke queue: " + tetangga);
                }
            }
            System.out.println(" Queue sekarang: " + queue);
        }
        return false;
    }

    private void cetakJalur(Map<String, String> parent, String target) {
        List<String> jalur = new ArrayList<>();
        String node = target;
        while (node != null) {
            jalur.add(node);
            node = parent.get(node);
        }
        Collections.reverse(jalur);
        System.out.println("Ketemu! Jalur terpendek: " + String.join(" -> ", jalur));
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        String target = "a6";
        System.out.println("Mulai BFS cari " + target + " dari a0\n");
        bfs.bfs("a0", target);
    }
}
