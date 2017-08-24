package org.msankar.ds.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private Map<Integer, GraphNode> idToNode = new HashMap<>();

	public void createGraph(int nVertices) {
		for (int i = 1; i <= nVertices; i++) {
			idToNode.put(i, new GraphNode(i));
		}
	}

	public GraphNode getNode(int id) {
		return idToNode.get(id);
	}

	public boolean addEdge(int srcId, int destId, boolean directed) {
		return addEdge(idToNode.get(srcId), idToNode.get(destId), directed);
	}

	public boolean addEdge(GraphNode srcNode, GraphNode destNode, boolean directed) {
		if (srcNode == null || destNode == null) {
			throw new IllegalArgumentException("Cannot add edges to non-existent nodes");
		}
		srcNode.getAdjacentNodes().add(destNode);
		if (!directed) {
			destNode.getAdjacentNodes().add(srcNode);
		}
		return true;
	}

	public boolean hasPathDFS(int srcId, int destId) {
		GraphNode srcNode = idToNode.get(srcId);
		GraphNode destNode = idToNode.get(destId);
		if (srcNode == null || destNode == null) {
			throw new IllegalArgumentException("Cannot add edges to non-existent nodes");
		}
		Set<Integer> visitedSet = new HashSet<>(idToNode.size());
		Stack<GraphNode> stack = new Stack<>();
		stack.push(srcNode);

		while (!stack.isEmpty()) {
			GraphNode currNode = stack.pop();
			if (visitedSet.contains(currNode.getId())) {
				continue;
			}
			visitedSet.add(currNode.getId());
			if (currNode.equals(destNode)) {
				return true;
			}

			for (GraphNode child : currNode.getAdjacentNodes()) {
				if (!visitedSet.contains(child.getId())) {
					stack.push(child);
				}
			}
		}
		return false;
	}

	public boolean hasPathBFS(int srcId, int destId) {
		GraphNode srcNode = idToNode.get(srcId);
		GraphNode destNode = idToNode.get(destId);
		if (srcNode == null || destNode == null) {
			throw new IllegalArgumentException("Cannot add edges to non-existent nodes");
		}
		Set<Integer> visitedSet = new HashSet<>(idToNode.size());
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(srcNode);

		while (!queue.isEmpty()) {
			GraphNode currNode = queue.poll();
			if (visitedSet.contains(currNode.getId())) {
				continue;
			}
			visitedSet.add(currNode.getId());
			if (currNode.equals(destNode)) {
				return true;
			}

			for (GraphNode child : currNode.getAdjacentNodes()) {
				if (!visitedSet.contains(child.getId())) {
					queue.add(child);
				}
			}
		}
		return false;
	}

	public boolean hasCycleDirected(GraphNode node) {
		Set<Integer> visitedSet = new HashSet<>(idToNode.size());
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);

		while (!stack.isEmpty()) {
			GraphNode currNode = stack.pop();
			if (visitedSet.contains(currNode.getId())) {
				return true;
			}
			visitedSet.add(currNode.getId());
			for (GraphNode child : currNode.getAdjacentNodes()) {
				stack.push(child);
			}
		}
		return false;
	}

	public boolean hasCycleUnDirected(GraphNode node) {
		Set<Integer> visitedSet = new HashSet<>(idToNode.size());
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);

		while(!stack.isEmpty()) {
			GraphNode currNode = stack.pop();

			if (!visitedSet.contains(currNode.getId())) {
				visitedSet.add(currNode.getId());
				for (GraphNode child : currNode.getAdjacentNodes()) {
					if (visitedSet.contains(child.getId()) && child.getId() != currNode.getParentId()) {
						return true;
					} else {
						child.setParentId (currNode.getId());
						stack.push(child);
					}
				}
			}
		}
		return false;
	}

}
