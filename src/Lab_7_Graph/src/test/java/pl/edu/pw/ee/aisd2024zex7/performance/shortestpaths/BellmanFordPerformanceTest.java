package pl.edu.pw.ee.aisd2024zex7.performance.shortestpaths;

import pl.edu.pw.ee.aisd2024zex7.shortestpaths.singlesource.bellmanford.BellmanFord;

public class BellmanFordPerformanceTest extends ShortestPathsPerformanceTest {

    public BellmanFordPerformanceTest() {
        super(new BellmanFord());
    }

}
