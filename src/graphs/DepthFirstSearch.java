package graphs;

public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(UndirectedGraph G, int s){
        marked= new boolean[G.getNumVertices()];
        dfs(G,s);
    }

    private void dfs(UndirectedGraph G, int v){
        count++;
        marked[v] =true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }
    public boolean marked(int v){
        return marked[v];
    }

    public int getCount(){
        return count;
    }


}
