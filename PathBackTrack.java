import java.util.*;
public class PathBackTrack {
    // https://practice.geeksforgeeks.org/problems/path-of-greater-than-equal-to-k-length1034/1
    public static ArrayList<ArrayList<Pair>> createGraph(int V,int E,int[] A){
        ArrayList<ArrayList<Pair>> adj_list = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj_list.add(new ArrayList<Pair>());
        }
        for(int i=0;i+3<A.length;i=i+3){
            adj_list.get(A[i]).add(new Pair(A[i+1],A[i+2]));
            adj_list.get(A[i+1]).add(new Pair(A[i],A[i+2]));
        }
        return adj_list;
    }
    public static boolean backtrack(int node,ArrayList<ArrayList<Pair>> adj_list,ArrayList<Integer> path,boolean[] vis,int k){
        if(k<=0){
            //System.out.println(path);
            return true;
        }
        Iterator<Pair> it = adj_list.get(node).listIterator();
        while(it.hasNext()){
            Pair p = it.next();int w = p.w,v=p.v;
            if(vis[v])continue;
            vis[v] = true;
            path.add(v);
            if(backtrack(v,adj_list,path,vis,k-w))return true;
            vis[v] = false;
            path.remove(path.size()-1);
        }
        return false;
    }
    public static boolean pathMoreThanK(int V , int E , int K , int [] A){
        ArrayList<ArrayList<Pair>> adj_list = createGraph(V,E,A);
        //for(ArrayList<Pair> r : adj_list)System.out.println(r);
        ArrayList<Integer> path = new ArrayList<Integer>();
        boolean[] vis = new boolean[V];vis[0] = true;
        return backtrack(0,adj_list,path,vis,K);      
    }
    public static void main(String[] args){
        System.out.println(pathMoreThanK(4,3,8,new int[]{0, 1, 5, 1, 2, 1, 2, 3, 1}));
    }
}

class Pair{
    int v,w;
    Pair(int v,int w){
        this.v = v;
        this.w = w;
    }
    public String toString(){
        return "("+v+","+w+")";
    }
}