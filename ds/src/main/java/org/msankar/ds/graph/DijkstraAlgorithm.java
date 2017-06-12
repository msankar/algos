package org.msankar.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
	private final List<Vertex> nodes;
	private final List<Edge> edges;
	private Set<Vertex> visitedNodes;
	private Map<Vertex, Vertex> parent;
	
	public DijkstraAlgorithm (Graph graph) {
		this.nodes = graph.getVertices();
		this.edges = graph.getEdges();
	}
	
	private int getShortestDistance() {
		return 0;
		
	}
	
	private int getDistance(Vertex node, Vertex dest) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && edge.getDest().equals(dest)) {
				return edge.getWeight();
			}
		}
		return -1;
	}
	
	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighborList = new ArrayList<Vertex> ();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isVisited(edge.getDest())) {
				neighborList.add(edge.getDest());
			}
		}
		return neighborList;
	}
	
	private boolean isVisited(Vertex dest) {
		if (visitedNodes.contains(dest)) {
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
