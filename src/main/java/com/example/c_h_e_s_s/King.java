package com.example.c_h_e_s_s;

public class King extends Pieces{
    public King(int type, int color, int col, int row) {
        super(5, color, col, row);
    }
    @Override
    public int getColor() {
        return super.getColor();
    }
    @Override
    public int getCol() {
        return super.getCol();
    }

    @Override
    public int getRow() {
        return super.getRow();
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
