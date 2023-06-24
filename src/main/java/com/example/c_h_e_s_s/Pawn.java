package com.example.c_h_e_s_s;

public class Pawn extends Pieces{
    boolean hasMoved;
    public Pawn(int type, int color, int col, int row, boolean hasMoved) {
        super(0, color, col, row);
        this.hasMoved = hasMoved;
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
    // don't need to worry about going out of bounds because you can only select valid squares
        if (color == 1){ // black
            if (!hasMoved){ // move 2 spaces
                if (desiredCol == col + 2 && desiredRow == row && board[col+1][row] == null){
                    board[col][row] = null; // set old position to be empty
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col + 1 && desiredRow == row){ // move 1 space
                if (board[col + 1][row] == null){ // make sure there's nothing there
                    board[col][row] = null;
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col + 1){ // capturing
                if (board[desiredCol][desiredRow] != null){
                    if (desiredRow == row + 1 || desiredRow == row - 1){
                        board[col][row] = null; // set old position to be empty
                        col = desiredCol;
                        row = desiredRow;
                        board[col][row] = this;
                        hasMoved = true;
                        return board;
                    }
                }
            }
        }
        else{ // white
            if (!hasMoved){ // move 2 spaces
                if (desiredCol == col - 2 && desiredRow == row && board[col-1][row] == null){
                    board[col][row] = null; // set old position to be empty
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col - 1 && desiredRow == row){ // move 1 space
                if (board[col - 1][row] == null){
                    board[col][row] = null;
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col - 1){
                if (board[desiredCol][desiredRow] != null){
                    if (desiredRow == row + 1 || desiredRow == row - 1){
                        board[col][row] = null; // set old position to be empty
                        col = desiredCol;
                        row = desiredRow;
                        board[col][row] = this;
                        hasMoved = true;
                        return board;
                    }
                }
            }
        }
        return board;
    }
    public int[][] validMoves(Pieces[][] board){
        int[][] moves = new int[8][8];
        if (color == 1){ // black
            if (!hasMoved){ // has not moved so 2 down is valid
                moves[col + 2][row] = 1; // populate with anything so long as it isn't null
            }
            if (col < 7){
                moves[col+1][row] = 1; // pawns can always move forward as long as it is not at the end

                if (board[col + 1][row + 1] != null && board[col + 1][row - 1] != null){ // if there is a piece which can be taken it is a valid move
                    moves[col + 1][row + 1] = 1;
                    moves[col + 1][row -1] = 1;
                }
            }
        }
        else{ // white
            if (!hasMoved){ // has not moved so 2 down is valid
                moves[col - 2][row] = 1; // populate with anything so long as it isn't null
            }
            if (col > 0){
                moves[col-1][row] = 1; // pawns can always move forward as long as it is not at the end

                if (board[col - 1][row + 1] != null && board[col - 1][row - 1] != null){ // if there is a piece which can be taken it is a valid move
                    moves[col - 1][row + 1] = 1;
                    moves[col - 1][row -1] = 1;
                }
            }
        }
        return moves;
    }
}
