package graph;

/**
 * User: absharma
 * Date: 4/19/12
 */
public class Edge {
    private String label;
    private Vertex v1;
    private Vertex v2;
    private float weight;
    private boolean directed = false;

    public Edge(Vertex v1, Vertex v2, boolean directed) {
        this(null, v1, v2, directed);
    }

    public Edge(String label, Vertex v1, Vertex v2, boolean directed) {
        this.label = label;
        this.v1 = v1;
        this.v2 = v2;
        this.directed = directed;
        if(directed) {
            this.v1.addOut(this);
            this.v2.addIn(this);
        } else {
            this.v1.addEdge(this);
            this.v2.addEdge(this);
        }
    }
    
    public Edge(String label, Vertex v1, Vertex v2, boolean directed, float weight) {
        this(label, v1, v2, directed);
        this.weight = weight;
    }

    public Vertex other(Vertex v) {
        if(v1.label().equals(v.label())) {
            return v2;
        } else if((v2.label().equals(v.label()))){
            return v1;
        }
        throw new IllegalStateException("Vertex " + v.label() + " not in edge " + this);
    }

    public String label() {
        return label;
    }

    public Vertex v1() {
        return v1;
    }

    public Vertex v2() {
        return v2;
    }

    public boolean directed() {
        return directed;
    }

    public float weight() {
        return weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (directed != edge.directed) return false;
        if (Float.compare(edge.weight, weight) != 0) return false;
        if (label != null ? !label.equals(edge.label) : edge.label != null) return false;
        if (!v1.equals(edge.v1)) return false;
        if (!v2.equals(edge.v2)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + v1.hashCode();
        result = 31 * result + v2.hashCode();
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        result = 31 * result + (directed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Edge");
        sb.append("{label='").append(label).append('\'');
        sb.append(", v1=").append(v1);
        sb.append(", v2=").append(v2);
        sb.append(", weight=").append(weight);
        sb.append(", directed=").append(directed);
        sb.append('}');
        sb.append('\n');
        return sb.toString();
    }
}
