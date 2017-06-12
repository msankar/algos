package org.msankar.ds.graph;

public class Edge {
	
	private final String id;
	private final Vertex source;
	private final Vertex dest;
	private final int weight;

	public Edge(String id, Vertex source, Vertex dest, int weight) {
		this.id = id;
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDest() {
		return dest;
	}

	public int getWeight() {
		return weight;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + weight;
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
		Edge other = (Edge) obj;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuffer("Edge: Id = ").append(id)
				.append(" source = ").append(source)
				.append(" dest = ").append(dest)
				.append(" weight = ").append(weight).toString();		
	}
	
}
