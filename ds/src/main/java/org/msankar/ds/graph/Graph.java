package org.msankar.ds.graph;

import java.util.List;

public class Graph {
	
	private final List<Vertex> vertices;
	private final List<Edge> edges;
	
	public Graph(List<Vertex> v, List<Edge> e) {
		this.vertices = v;
		this.edges = e;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public List<Vertex> getVertices() {
		return vertices;
	}
	
}
