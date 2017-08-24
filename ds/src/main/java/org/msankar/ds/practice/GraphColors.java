package org.msankar.ds.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GraphColors {

	public static void main(String[] args) {
		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");

		a.addNeighbor(b);
		b.addNeighbor(a);
		b.addNeighbor(c);
		c.addNeighbor(b);

		List<GraphNode> graph = Arrays.asList(a, b, c);

	}

	public static void fillColor(List<GraphNode> graphs, List<String> colors) {
		Set<GraphNode> visited = new HashSet<>();
		Set<String> illegalColors = new HashSet<>();

		for (GraphNode node: graphs) {
			if (visited.contains(node)) {
				continue;
			}
			visited.add(node);
			for (GraphNode child : node.getNeighbors()) {
				if (child.hasColor()) {
					illegalColors.add(child.getColor());
				}
			}
			for (String color : colors) {
				if (!illegalColors.contains(color)) {
					node.setColor(color);
					break;
				}
			}
		}


	}
}
class GraphNode {
    private String label;
    private Set<GraphNode> neighbors;
    private Optional<String> color;

    public GraphNode(String label) {
        this.label = label;
        neighbors = new HashSet<GraphNode>();
        color = Optional.empty();
    }

    public String getLabel() {
        return label;
    }
    public Set<GraphNode> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }
    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }
    public boolean hasColor() {
        return color.isPresent();
    }
    public String getColor() {
        return color.get();
    }
    public void setColor(String color) {
        this.color = Optional.ofNullable(color);
    }
}
