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
    public Pieces[][] move(Pieces[][] board, int desiredCol, int desiredRow) {

        if (color == 1){ // black
            if (!hasMoved){ // move 2 spaces
                if (desiredCol == col + 2 && desiredRow == row){
                    board[col][row] = null; // set old position to be empty
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col + 1 && desiredRow == row){ // move 1 space
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                hasMoved = true;
                return board;
            }
            if (desiredCol == col + 1){
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
        else{
            if (!hasMoved){ // move 2 spaces
                if (desiredCol == col - 2 && desiredRow == row){
                    board[col][row] = null; // set old position to be empty
                    col = desiredCol;
                    row = desiredRow;
                    board[col][row] = this;
                    hasMoved = true;
                    return board;
                }
            }
            if (desiredCol == col - 1 && desiredRow == row){ // move 1 space
                board[col][row] = null;
                col = desiredCol;
                row = desiredRow;
                board[col][row] = this;
                hasMoved = true;
                return board;
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
}
