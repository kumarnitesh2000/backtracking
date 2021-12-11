public class SudukoSolver {
    public static boolean isSafe(char k,char[][] board,int x,int y){
        for(int i=0;i<9;i++){
            if(board[i][y]==k)return false;
            if(board[x][i]==k)return false;
            int r = 3*(x/3)+i/3,c = 3*(y/3)+i%3;
            if(board[r][c]==k)return false;
        }
        return true;
    }
    public static boolean solution(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isSafe(k,board,i,j)){
                            board[i][j] = k;
                            if(solution(board))return true;
                            board[i][j] = '.';
                        }
                    }  
                    return false; 
                }
            }
        }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        solution(board);
        printGrid(board);
    }
    public static void printGrid(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }
}
