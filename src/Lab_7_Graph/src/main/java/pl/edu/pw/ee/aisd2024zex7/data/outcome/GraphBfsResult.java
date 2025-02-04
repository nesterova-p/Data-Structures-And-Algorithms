package pl.edu.pw.ee.aisd2024zex7.data.outcome;

public class GraphBfsResult extends GraphSearchResult {

    private final int[] distance;

    public GraphBfsResult(int startId, int[] prevVertices, int[] distance) {
        super(startId, prevVertices);

        this.distance = distance;
    }

    public int[] getDistance() {
        return distance;
    }

}
