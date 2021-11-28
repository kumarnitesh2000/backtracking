import java.util.*;
public class RatInMaze{
    public static void dfs(ArrayList<String> res,String path,int x,int y,int dest,int[][] m){
        if(x==dest-1 && y==dest-1){
            //System.out.println(path.toString());
            res.add(path);
        }
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        String dir = "DLRU";
        for(int i=0;i<4;i++){
            int new_x = x+dx[i];
            int new_y = y+dy[i];
            if(new_x>=0 && new_y>=0 && new_x<dest && new_y<dest && m[new_x][new_y]==1){
                m[x][y] = 0;
                path+=dir.charAt(i);
                dfs(res,path,new_x,new_y,dest,m);
                path=path.substring(0,path.length()-1);
                m[x][y] = 1;
            }
        }
        return;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        String str = new String("");
        dfs(res,str,0,0,n,m);
        return res;
    }
    public static void main(String[] args){
        //Time Complexity: O(4^(n^2)) width power height
        //Space:  O(n^2)
        ArrayList<String> lis = findPath(new int[][]{{1,1},{1,1}},2);
        if(lis.size()==0)
        System.out.println("-1");
        else
        System.out.println(lis);
    }

}