import java.util.*;
public class Grid {
    
    //https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
    public static boolean isSafe(int r,int c,int x,int y){
        if(x>=0 && x<r && y>=0 && y<c)return true;
        return false;
    }
    public static void solution(ArrayList<ArrayList<Integer>> res,int r,int c,int[][] grid,ArrayList<Integer> path,int x,int y){
        if(x==r-1 && y==c-1){
            ArrayList<Integer> track = new ArrayList<Integer>();
            for(Integer p: path)track.add(p);
            track.add(grid[x][y]);
            res.add(track);
            return;
        }
        // move down
        if(isSafe(r,c,x+1,y)){
            path.add(grid[x][y]);
            solution(res,r,c,grid,path,x+1,y);
            path.remove(path.size()-1);
        }
        // move right
        if(isSafe(r,c,x,y+1)){
            path.add(grid[x][y]);
            solution(res,r,c,grid,path,x,y+1);
            path.remove(path.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> findPath(int r,int c){
        int[][] grid = new int[r][c];
        int count = 1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                grid[i][j] = count++;
            }
        } 
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solution(res,r,c,grid,new ArrayList<Integer>(),0,0);
        return res;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> res = findPath(3,3);
        for(ArrayList<Integer> r : res)System.out.println(r);
    }
}
