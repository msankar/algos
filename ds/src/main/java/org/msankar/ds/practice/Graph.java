package org.msankar.ds.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private Map<Integer, GraphNode> idToNodeMap = new HashMap<>();

	GraphNode getNode(int id) {
		return idToNodeMap.get(id);
	}

	public void constructGraph(int numVertices) {
		for (int i = 0; i < numVertices; i++) {
			idToNodeMap.put(i, new GraphNode(i));
		}
	}

	public boolean hasPathDFS(int srcId, int destId) {
		GraphNode srcNode = idToNodeMap.get(srcId);
		GraphNode destNode = idToNodeMap.get(destId);
		Set<Integer> visitedSet = new HashSet<>();
		return hasPathDFS(srcNode, destNode, visitedSet);
	}

	public boolean hasPathDFS(GraphNode src, GraphNode dest, Set<Integer> visited) {
		if (visited.contains(src.getId())) {
			return false;
		}
		visited.add(src.getId());
		if (src.equals(dest)) {
			return true;
		}
		for (GraphNode node : src.getAdjacentNodes()) {
			if (hasPathDFS(node, dest, visited)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPathDFSStack(GraphNode src, GraphNode dest) {
		Set<Integer> visited = new HashSet<>();
		Stack<GraphNode> stack = new Stack<>();
		stack.add(src);
		while (!stack.isEmpty()) {
			GraphNode currNode = stack.pop();
			if (visited.contains(currNode.getId())) {
				continue;
			}
			visited.add(currNode.getId());
			if (currNode.equals(dest)) {
				return true;
			}
			for (GraphNode child : src.getAdjacentNodes()) {
				stack.push(child);
			}
		}
		return false;
	}

	public boolean hasPathBFSQueue(GraphNode src, GraphNode dest) {
		Set<Integer> visited = new HashSet<>();
		List<GraphNode> queue = new LinkedList<>();
		queue.add(src);
		while (!queue.isEmpty()) {
			GraphNode currNode = queue.remove(0);
			if (visited.contains(currNode.getId())) {
				continue;
			}
			visited.add(currNode.getId());
			if (currNode.equals(dest)) {
				return true;
			}
			for (GraphNode child : src.getAdjacentNodes()) {
				queue.add(child);
			}
		}
		return false;
	}

	public boolean hasCycleDirected(GraphNode src) {
		Set<Integer> visited = new HashSet<>();
		Stack<GraphNode> stack = new Stack<>();
		stack.push(src);

		while(!stack.isEmpty()) {
			GraphNode node = stack.pop();

			if (visited.contains(node.getId())) {
				return true;
			}
			visited.add(node.getId());
			for (GraphNode adjacentNode : node.adjacentNodes) {
				stack.push(adjacentNode);
			}
		}
		return false;
	}

	public boolean hasCycleUndirected(GraphNode node) {
		Map<Integer, Integer> nodeToParent = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);

		while(!stack.isEmpty()) {
			node = stack.pop();
			if (visited.contains(node.getId()) && nodeToParent.containsKey(node.getId())) {
				return true;
			}
			visited.add(node.getId());
			for (GraphNode child : node.adjacentNodes) {
				nodeToParent.put(child.getId(), node.getId());
				stack.push(child);
			}
		}
		return false;
	}

	public void addEdge (int sourceId, int destId, boolean directed) {
		GraphNode srcNode = idToNodeMap.get(sourceId);
		GraphNode destNode = idToNodeMap.get(destId);
		srcNode.getAdjacentNodes().add(destNode);
		if (!directed) {
			destNode.getAdjacentNodes().add(srcNode);
		}
	}

	public class GraphNode {
		private int id;
		private List<GraphNode> adjacentNodes;

		public GraphNode (int id) {
			this.id = id;
			this.adjacentNodes = new LinkedList<>();
		}

		public int getId() {
			return this.id;
		}

		public List<GraphNode> getAdjacentNodes() {
			return adjacentNodes;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((adjacentNodes == null) ? 0 : adjacentNodes.hashCode());
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GraphNode other = (GraphNode) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (adjacentNodes == null) {
				if (other.adjacentNodes != null)
					return false;
			} else if (!adjacentNodes.equals(other.adjacentNodes))
				return false;
			if (id != other.id)
				return false;
			return true;
		}

		private Graph getOuterType() {
			return Graph.this;
		}
	}

}
