package org.msankar.ds.practice.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
	private int id;
	private int parentId;
	private List<GraphNode> adjacentNodes;

	public GraphNode(int id) {
		this.id = id;
		this.adjacentNodes = new LinkedList<>();
		this.parentId = -1;
	}

	public int getId() {
		return this.id;
	}

	public List<GraphNode> getAdjacentNodes() {
		return this.adjacentNodes;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (adjacentNodes == null) {
			if (other.adjacentNodes != null)
				return false;
		} else if (!adjacentNodes.equals(other.adjacentNodes))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
