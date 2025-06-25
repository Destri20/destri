public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Langkah 1: Inisialisasi
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Langkah 2: Isi in-degree dan adjacency list
        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        // Langkah 3: Masukkan semua mata kuliah dengan inDegree == 0 ke dalam queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Langkah 4: Proses BFS
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();        // Ambil satu node dari queue
            order.add(node);                // Tambahkan ke hasil urutan
            for (int neighbor : adj.get(node)) { // Untuk setiap tetangga node
                inDegree[neighbor]--;            // Kurangi inDegree-nya
                if (inDegree[neighbor] == 0) {   // Jika inDegree tetangga jadi 0
                    queue.offer(neighbor);       // Masukkan ke queue
                }
            }
        }

        // Placeholder return, implementasi pengecekan siklus di langkah berikutnya
        return new int[0];
    }
}
