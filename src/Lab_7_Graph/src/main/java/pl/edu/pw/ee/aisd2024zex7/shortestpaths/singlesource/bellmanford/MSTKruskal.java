package pl.edu.pw.ee.aisd2024zex7.shortestpaths.singlesource.bellmanford;

import java.io.*;
import java.util.*;

public class MSTKruskal {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        String filename = "src\\main\\java\\pl\\edu\\pw\\ee\\aisd2024zex7\\shortestpaths\\singlesource\\bellmanford\\miasta.txt";
        List<Edge> edges = new ArrayList<>();
        Map<String, Integer> cityToIndex = new HashMap<>();
        int cityIndex = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                if (parts.length < 3) continue;

                String city1 = parts[0];
                String city2 = parts[1];
                int weight = Integer.parseInt(parts[2]);

                if (!cityToIndex.containsKey(city1)) {
                    cityToIndex.put(city1, cityIndex++);
                }
                if (!cityToIndex.containsKey(city2)) {
                    cityToIndex.put(city2, cityIndex++);
                }

                edges.add(new Edge(cityToIndex.get(city1), cityToIndex.get(city2), weight));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int numCities = cityIndex;
        UnionFind uf = new UnionFind(numCities);

        // Sort wed wagi
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        // Kruskal
        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                uf.union(e.src, e.dest);
                mst.add(e);
                totalWeight += e.weight;
            }
        }

        Map<Integer, String> indexToCity = new HashMap<>();
        for (Map.Entry<String, Integer> entry : cityToIndex.entrySet()) {
            indexToCity.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Krawędzie w minimalnym drzewie rozpinającym:");
        for (Edge e : mst) {
            String cityA = indexToCity.get(e.src);
            String cityB = indexToCity.get(e.dest);
            System.out.println(cityA + " - " + cityB + " : " + e.weight);
        }
        System.out.println("Całkowity koszt MST: " + totalWeight);
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }


}