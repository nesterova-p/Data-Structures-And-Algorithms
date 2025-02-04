package pl.edu.pw.ee.aisd2024zex7.graphsearch.services;

import pl.edu.pw.ee.aisd2024zex7.data.input.Graph;
import pl.edu.pw.ee.aisd2024zex7.data.outcome.GraphSearchResult;

public interface GraphSearch {

    GraphSearchResult searchGraphPaths(Graph graph, int startId);
}
