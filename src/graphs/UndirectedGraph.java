package graphs;

import java.util.LinkedList;

public class UndirectedGraph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;


    /**
     * Creates an empty graph with V vertices
     * Precondition: V must be greater than 0
     * @param V, number of vertices
     */
    public UndirectedGraph(int V){
       this.V=V;
       this.E=0;
       adj=(LinkedList<Integer>[]) new LinkedList[V];
       for(int v=0; v<V; v++){
           adj[v]= new LinkedList<Integer>();
       }
    }

    /**
     * Return the number of vertices in the graph
     * @return vertices of the graph
     */
    public int getNumVertices(){
        return V;
    }

    /**
     * Return the number of edges of the graph
     * @return number of vertices of the graph
     */
    public int getNumEdges(){
        return E;
    }

    public void addEdge(int v, int w){
        if(v<0 || v>=V) throw new IndexOutOfBoundsException();
        if(w<0 ||w>=V) throw new IndexOutOfBoundsException();
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        if(v<0 ||v>=V) throw new IndexOutOfBoundsException();
        return adj[v];
    }






}
