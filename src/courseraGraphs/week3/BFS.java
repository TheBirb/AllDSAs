package courseraGraphs.week3;

import javax.sound.sampled.Line;
import java.util.*;

public class BFS {


    private static int[] distance(ArrayList<Integer>[] adj, int s, int t) {
        int ret=-1;
        int[] dist= new int[adj.length];
        int[] prev= new int[adj.length];
        for (int i=0;i<dist.length;i++){
            dist[i]=-1;
            prev[i]=-1;
        }

        Queue<Integer> queue= new Queue<Integer>() {
            ArrayList<Integer> list=new ArrayList<>();
            @Override
            public boolean add(Integer integer) {
                list.add(integer);
                return true;
            }

            @Override
            public boolean offer(Integer integer) {
                return false;
            }

            @Override
            public Integer remove() {
                return list.remove(0);
            }

            @Override
            public Integer poll() {
                return null;
            }

            @Override
            public Integer element() {
                return null;
            }

            @Override
            public Integer peek() {
                return null;
            }

            @Override
            public int size() {
                return list.size();
            }

            @Override
            public boolean isEmpty() {
                return list.size()==0;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        queue.add(s);
        dist[s]=0;
        prev[s]=-1;
        int u=-1;
        boolean found=false;
        while(!queue.isEmpty() && !found){
            u=queue.remove();
            for(int i=0; i<adj[u].size(); i++){
                int vex=adj[u].get(i);
                if(dist[vex]==-1){
                    queue.add(vex);
                    dist[vex]=dist[u]+1;
                    prev[vex]=u;
                    if(vex==t){
                        found=true;
                    }
                }
            }
        }
        if(!found){
            return null;
        }else{
            return prev;
        }

    }

    private static String printPath(int u, int s, int[] prev){
        LinkedList<Integer> result= new LinkedList<>();
        while(u!=s){
            result.add(0,u+1);
            u=prev[u];
        }
        result.add(0,u+1);
        return result.toString();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        int[] prev=distance(adj, x, y);
        if(prev==null){
            System.out.println("There is no path");
        }else{
            System.out.println(printPath(y,x,prev));
        }

    }
}

