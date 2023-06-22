package com.example.c_h_e_s_s;

public class Rook extends Pieces{
    public Rook(int type, int color, int col, int row) {
        super(3, color, col, row);
    }

    @Override
    public Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow) {
        /*
        if valid{
            col = desiredCol;
            row = desiredRow;
            Will take in the board
            Then: board[col][row] = null
            board[desiredCol][desiredRow] = this.Pawn

            In game:
                board = pawn.move(board, 2, 2);
        }
        * */
        return board;
    }
}
