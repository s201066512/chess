package com.example.c_h_e_s_s;
import java.lang.Math;
public class Bishop extends Pieces{
    public Bishop(int type, int color, int col, int row) {
        super(2, color, col, row);
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
        if (desiredCol == col || desiredRow == row){ // invalid move
            return board;
        }
        else{ // different row and column
            int columnMovement = Math.abs(col - desiredCol);
            int rowMovement = Math.abs(row - desiredRow);
            if (columnMovement != rowMovement){ // but not moving diagonally
                return board; // so it's invalid
            }
        }

        // up left
        if (desiredCol < col && desiredRow < row){
            for (int i = 1; i < Math.abs(desiredCol - col) - 1; i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                if (board[col - i][row - i] != null){ // there is a piece in the way
                    return board; // invalid
                }
            }
            // means the piece has made it to its desired position without encountering another piece
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }


        // up right
        if (desiredCol < col && desiredRow >  row){
            for (int i = 1; i < Math.abs(desiredCol - col) - 1; i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                // col down
                // row up
                if (board[col - i][row + i] != null){ // there is a piece in the way
                    return board; // invalid
                }
            }
            // means the piece has made it to its desired position without encountering another piece
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }


        // down left
        if (desiredCol > col && desiredRow < row){
            for (int i = 1; i < Math.abs(desiredCol - col) - 1; i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                // col up
                // row down
                if (board[col + i][row - i] != null){ // there is a piece in the way
                    return board; // invalid
                }
            }
            // means the piece has made it to its desired position without encountering another piece
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }


        // down right
        if (desiredCol > col && desiredRow > row){
            for (int i = 1; i < Math.abs(desiredCol - col) - 1; i++){ // Math.abs(desiredCol - col) could be row as well, but they're already equal if this is reached
                // col up
                // row down
                if (board[col + i][row + i] != null){ // there is a piece in the way
                    return board; // invalid
                }
            }
            // means the piece has made it to its desired position without encountering another piece
            board[col][row] = null;
            col = desiredCol;
            row = desiredRow;
            board[col][row] = this;
            return board;
        }
        return board;
    }
    public int[][] validMoves(Pieces[][] board){
        int[][] moves = new int[8][8];
        return moves;
    }
}
