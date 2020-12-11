package graphs;

public class test {

    public static void main(String[] args) {
        UndirectedGraph g= new UndirectedGraph(5);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);
        DepthFirstSearch d= new DepthFirstSearch(g,1);
        

    }
}
