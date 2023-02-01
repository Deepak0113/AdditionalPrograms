package leetcode;

public class BattleshipsInABoard {
    private void ship(int i, int j, int row, int col, char[][] board){
        board[i][j] = '.';

        if(j<col-1 && board[i][j+1] == 'X'){
            ship(i, j+1, row, col, board);
        }

        if(i<row-1 && board[i+1][j] == 'X'){
            ship(i+1, j, row, col, board);
        }
    }

    public int countBattleships(char[][] board) {
        int m=board.length, n=board[0].length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'X'){
                    ship(i,j,m,n,board);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        BattleshipsInABoard battleshipsInABoard = new BattleshipsInABoard();
        char[][] board = new char[][]{{'X', '.', '.', 'X'},{'.', '.', '.', 'X'},{'.', '.', '.', 'X'}};
        System.out.print(battleshipsInABoard.countBattleships(board));
    }
}
