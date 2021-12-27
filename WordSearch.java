import java.util.*;
class WordSearch {
    public static boolean dfs(int x,int y,char[][] board, String word,int count){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        if(count>=word.length()){
            return true;
        }
        if(x>=0 && x<board.length && y>=0 && y<board[0].length && word.charAt(count)==board[x][y]){
            //System.out.println(x+" "+y+" "+count);
            board[x][y] = '*';
            for(int i=0;i<4;i++){
                int new_x=x+dx[i],new_y = y+dy[i];
                if(dfs(new_x,new_y,board,word,count+1))return true;
            }
            board[x][y] = word.charAt(count);
        }
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        int n = board.length,m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j] && dfs(i,j,board,word,0))return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        exist(new char[][]{{'a'}},"a");
    }
}