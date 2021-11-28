import java.util.*;
public class NQueen {
    static boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        //upwards
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
            return false;
        //right-up
        for (i = row, j = col; i>=0 && j < board.length ; i--, j++)
            if (board[i][j] == 1)
            return false;
        //left-up    
        for (i = row, j = col; j >= 0 && i>=0; i--, j--)
            if (board[i][j] == 1)
            return false;
        return true;
    }
    static ArrayList<Integer> transformM(int[][] m){
        ArrayList<Integer> lis = new ArrayList<Integer>();
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m.length;j++){
                if(m[i][j]==1){
                    lis.add(j+1);
                    break;
                }
            }
        }
        return lis;
    }
    static void dfs(int n,ArrayList<ArrayList<Integer>> res,int row,int[][] m){
        if(row==n){
            res.add(transformM(m));
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(m,row,i)){
                m[row][i] = 1;
                dfs(n,res,row+1,m);
                m[row][i] = 0;
            }
        }
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(n,res,0,new int[n][n]);
        return res;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = nQueen(4);
        for(ArrayList<Integer> r : res){
            System.out.println(r);
        }
    }
}
